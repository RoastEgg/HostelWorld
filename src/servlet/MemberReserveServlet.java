package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import model.Reserve;

@WebServlet("/MemberReserveServlet")
public class MemberReserveServlet extends HttpServlet{

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		
		String cardID = request.getParameter("cardID");
		String hostelID = request.getParameter("hostelID");
		String roomID  = request.getParameter("roomID");
		String stayDate = request.getParameter("stayDate");
		
		Date nowDate = new Date(); 
		DateFormat format =new SimpleDateFormat("yyyy-MM-dd");
		
		Reserve  reserve = new Reserve();
		reserve.setCardID(cardID);
		reserve.setHostelID(hostelID);
		reserve.setRoomID(Integer.parseInt(roomID));
		try {
			reserve.setNowDate(nowDate);
			reserve.setStayDate(format.parse(stayDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean canIn = false;
		canIn = roomDao.canIn(Integer.parseInt(roomID));
		if (canIn){
			reserveDao.saveReserve(reserve);
			
			roomDao.updateState(Integer.parseInt(roomID));
			
			context.getRequestDispatcher("/hostel/memberRechargeSuccess.jsp").forward(request, response);
		}
		else {
			context.getRequestDispatcher("/hostel/reserveError.jsp").forward(request, response);
		}
		
	}

}
