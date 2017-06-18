package servlet;

import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;

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
import model.Room;

@WebServlet("/HostelPlanPubServlet")
public class HostelPlanPubServlet extends HttpServlet{

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
		RequestDispatcher dispatcher = context.getRequestDispatcher("/hostel/hostelHomePage.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		
		String hostelID = request.getParameter("hostelID"); 
		String roomID = request.getParameter("roomID");
		//String date = request.getParameter("date");
		String price = request.getParameter("price");
		
		//DateFormat format =new SimpleDateFormat("yyyy-MM-dd");
		
		Room room = new Room();
		room.setHostelID(hostelID);
		room.setId(Integer.parseInt(roomID));
		room.setPrice(Double.parseDouble(price));
		room.setIsApproved(false);
		roomDao.save(room);
		
//		HostelPlan hostelPlan = new HostelPlan();
//
//		hostelPlan.setHostelID(hostelID);
//		hostelPlan.setRoomID(Integer.parseInt(roomID));
//		hostelPlan.setPrice(Double.parseDouble(price));
//
//		try {
//			hostelPlan.setDate(format.parse(date));
////			System.out.println(format.parse(date));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		ServiceFactory.getHostelService().savePlan(hostelPlan);
//		
		context.getRequestDispatcher("/hostel/hostelPlanPubSuccess.jsp").forward(request, response);
	}

}
