package servlet;

import java.io.IOException;
import java.util.List;

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
import model.Accommodation;
import model.Reserve;

@WebServlet("/MemberStatisticsServlet")
public class MemberStatisticsServlet extends HttpServlet{

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
		
		String cardID = (String)request.getSession().getAttribute("cardID");
		List<Reserve> reserveList = reserveDao.getForMember(cardID);
	    List<Accommodation> accommodationList = accommodationDao.getForMember(cardID);
	    
		request.getSession().setAttribute("memberReserve", reserveList);
	    request.getSession().setAttribute("memberAccommodation", accommodationList);
	    
		ServletContext context = request.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/hostel/memberStatistics.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
}
