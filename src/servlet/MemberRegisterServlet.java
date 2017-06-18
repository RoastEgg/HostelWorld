package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.AccommodationDao;
import dao.CardDao;
import dao.HostelDao;
import dao.ReserveDao;
import dao.RoomDao;
import daoImpl.AccommodationDaoImpl;
import daoImpl.CardDaoImpl;
import daoImpl.HostelDaoImpl;
import daoImpl.ReserveDaoImpl;
import daoImpl.RoomDaoImpl;
import model.Card;

@WebServlet("/MemberRegisterServlet")
public class MemberRegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReserveDao reserveDao = new ReserveDaoImpl(); 
	public AccommodationDao accommodationDao = new AccommodationDaoImpl(); 
	public HostelDao hostelDao = new HostelDaoImpl(); 
	public RoomDao roomDao = new RoomDaoImpl(); 
	public CardDao cardDao = new CardDaoImpl();
	
	public  int code= -1;
	public MemberRegisterServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/hostel/memberRegister.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String bankID = request.getParameter("bankID");
		String passWord = request.getParameter("passWord");
		
		Card card = new Card();
		code = getCode();
		card.setId(Integer.toString(code));
		card.setBankID(bankID);
		card.setPassWord(passWord);
		card.setConsumption(0);
		cardDao.save(card);
		
		writeCode(code);
		
		
		request.getSession().setAttribute("cardID", Integer.toString(code));
		request.getSession().setAttribute(
				"cardIsActive", 
				cardDao.find(Integer.toString(code)).getActivateState());
		
		
		context.getRequestDispatcher("/hostel/memberHomePage.jsp").forward(request, response);
		
	}
	public int getCode(){
		File f = new File("G:/j2ee/HostelWorld/cardNumber.txt");
		int ans = 0;
		String line="";
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			try {
				while ((line = br.readLine())!=null){
					ans = Integer.parseInt(line);
					ans++;
					System.out.println("会员号=: "+ans);
					return ans;
				}
				
			} catch (IOException e) {
				System.out.println("io exception");				
				 e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			 e.printStackTrace();
		}
		return 1;
	}
	public void writeCode(int code){
		FileWriter writer;
		try {
			writer = new FileWriter("G:/j2ee/HostelWorld/cardNumber.txt");
			writer.write(Integer.toString(code));
			writer.close();
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
	
}
