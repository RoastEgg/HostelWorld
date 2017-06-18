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
import model.Hostel;

@WebServlet("/HostelRegisterServlet")
public class HostelRegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReserveDao reserveDao = new ReserveDaoImpl(); 
	public AccommodationDao accommodationDao = new AccommodationDaoImpl(); 
	public HostelDao hostelDao = new HostelDaoImpl(); 
	public RoomDao roomDao = new RoomDaoImpl(); 
	public CardDao cardDao = new CardDaoImpl();
	
	public int code = -1;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/hostel/hostelRegister.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		
		String openApply = request.getParameter("openApply");
		String passWord = request.getParameter("passWord");
		
		code = getCode();
		
		Hostel hostel = new Hostel();
		hostel.setId(code);
		hostel.setPassWord(passWord);
		hostel.setApply(openApply);
		hostel.setAccepted(false);
		hostelDao.saveHostel(hostel);
		
		writeCode(code);
		
//		request.getSession().setAttribute("hostelID", Integer.toString(code));
		
//		context.getRequestDispatcher("/hostel/hostelHomePage.jsp").forward(request, response);
		context.getRequestDispatcher("/hostel/index.jsp").forward(request, response);
	}
	
	public int getCode(){
		File f = new File("G:/j2ee/HostelWorld/hostelID.txt");
		int ans = 0;
		String line="";
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			try {
				while ((line = br.readLine())!=null){
					ans = Integer.parseInt(line);
					ans++;
					System.out.println("客栈编号=: "+ans);
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
			writer = new FileWriter("G:/j2ee/HostelWorld/hostelID.txt");
			writer.write(Integer.toString(code));
			writer.close();
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
	
}