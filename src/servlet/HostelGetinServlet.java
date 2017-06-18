package servlet;

import java.io.IOException;

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
import model.Card;

@WebServlet("/HostelGetinServlet")
public class HostelGetinServlet extends HttpServlet{

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
		
		 String hostelID = request.getParameter("hostelID");
		 String roomID = request.getParameter("roomID");
		 String name  = request.getParameter("name");
		 String member = request.getParameter("member");
		 String cardID  = request.getParameter("cardID");
		 String payType = request.getParameter("payType");
		 
		 String price = request.getParameter("price");

		 Card originalCard = cardDao.find(cardID);
		 double originalPrice = cardDao.find(cardID).getConsumption();
		 
		 Card card = originalCard;
		 card.setConsumption(originalPrice+Double.parseDouble(price));
		 cardDao.update(card);
		 
		 
		 Accommodation accommodation = new Accommodation();

		 accommodation.setHostelID(hostelID);
		 accommodation.setRoomID(Integer.parseInt(roomID));
		 accommodation.setPersonName(name);
		 if (member.equals("is")){
			 accommodation.setIsMember(true);
		 }
		 else {
			 accommodation.setIsMember(false);
		 }
		 if (cardID!=null){
			 accommodation.setCardID(cardID); 
		 }
		 if (payType.equals("cash")){
			 accommodation.setPayType(0);
		 }
		 else {
			 accommodation.setPayType(1);
		 }
		 if (!member.equals("is")){
			 if (reserveDao.find(Integer.parseInt(roomID))!=null){
				 System.out.println("不是会员，且房间已经被预定");
				 
				 context.getRequestDispatcher("/hostel/getInError.jsp").forward(request, response);
				 return ;
			 }
		 }
		 else {
			 if (reserveDao.find(Integer.parseInt(roomID))!=null&&
					 !reserveDao.find(Integer.parseInt(roomID)).getCardID().equals(cardID)){
				 System.out.print(reserveDao.find(Integer.parseInt(roomID)).getCardID());
				 System.out.print(",input框中的cardID："+cardID);
				 System.out.println("是会员，但是房间已经被别的会员预定"); 
				 		 
				 context.getRequestDispatcher("/hostel/getInError.jsp").forward(request, response);
				 return ;
			 }			 
		 }
		 
		 accommodationDao.save(accommodation);
		 if (roomDao.canIn(Integer.parseInt(roomID))){
			 roomDao.updateState(Integer.parseInt(roomID));
		 }
		 if (reserveDao.find(Integer.parseInt(roomID))!=null){
			 reserveDao.delete(Integer.parseInt(roomID));			 
		 }context.getRequestDispatcher("/hostel/getInSuccess.jsp").forward(request, response);
	}

	
}
