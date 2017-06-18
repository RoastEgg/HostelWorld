package servlet;

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
 

@WebServlet("/HostelLoginServlet")
public class HostelLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ReserveDao reserveDao = new ReserveDaoImpl(); 
	public AccommodationDao accommodationDao = new AccommodationDaoImpl(); 
	public HostelDao hostelDao = new HostelDaoImpl(); 
	public RoomDao roomDao = new RoomDaoImpl(); 
	public CardDao cardDao = new CardDaoImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/hostel/hostelLogin.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		
		String hostelID = request.getParameter("hostelID");
		String passWord = request.getParameter("passWord");
		
		boolean IsRight = false;
		IsRight = hostelDao.check(hostelID, passWord);
		if (IsRight){
			
			request.getSession().setAttribute("hostelID", hostelID);
		
			context.getRequestDispatcher("/hostel/hostelHomePage.jsp").forward(request, response);
		}
		else {
			context.getRequestDispatcher("/hostel/LoginError.jsp").forward(request, response);
		}
	}
	
}
