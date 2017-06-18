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

@WebServlet("/MemberRechargeServlet")
public class MemberRechargeServlet extends HttpServlet{

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
		request.getSession().setAttribute(
				"cardIsActive", 
				cardDao.find( 
						(String)(request.getSession().getAttribute("cardID"))
						).getActivateState()
				);
		ServletContext context = request.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/hostel/memberHomePage.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletContext context = request.getServletContext();
		 String number = request.getParameter("number");
		 double numberValue= Double.parseDouble(number);
		 String cardID = request.getParameter("cardID");
		 cardDao.recharge(cardID, numberValue);
		 System.out.println("recharge:"+cardID+" number:"+number);
		 context.getRequestDispatcher("/hostel/memberRechargeSuccess.jsp").forward(request, response);
	}

}
