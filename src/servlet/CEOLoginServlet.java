package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import model.Hostel;
import model.Reserve;
import model.Room;

@WebServlet("/CEOLoginServlet")
public class CEOLoginServlet extends HttpServlet{

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
		RequestDispatcher dispatcher = context.getRequestDispatcher("/hostel/CEOLogin.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		
		List<Reserve> reserveList = reserveDao.getForCEO();
	    List<Accommodation> accommodationList = accommodationDao.getForCEO();
	    List<Hostel>         applyList        = hostelDao.getForCEO();
		List<Room>           roomList  = roomDao.getForCEO();
	   // ArrayList<Integer>   areaDistribution = cardDao.areaOfCard();
		
	    
	    request.getSession().setAttribute("CEOReserve", reserveList);
	    request.getSession().setAttribute("CEOAccommodation", accommodationList);
	    request.getSession().setAttribute("CEOHostelApply", applyList);
	    request.getSession().setAttribute("CEORoomApply", roomList);
	   // request.getSession().setAttribute("areaDistribution", areaDistribution);
	    
		context.getRequestDispatcher("/hostel/CEO.jsp").forward(request, response);

	}

	
}
