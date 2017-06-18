package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccommodationDao;
import dao.HostelDao;
import dao.ReserveDao;
import dao.RoomDao;
import daoImpl.AccommodationDaoImpl;
import daoImpl.HostelDaoImpl;
import daoImpl.ReserveDaoImpl;
import daoImpl.RoomDaoImpl;
import model.Accommodation;
import model.Hostel;
import model.Reserve;
import model.Room;

@WebServlet("/ApproveServlet")
public class ApproveServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReserveDao reserve = new ReserveDaoImpl(); 
	public AccommodationDao accommodation = new AccommodationDaoImpl(); 
	public HostelDao hostel = new HostelDaoImpl(); 
	public RoomDao room = new RoomDaoImpl(); 
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		
		List<Reserve> reserveList = reserve.getForCEO();
	    List<Accommodation> accommodationList = accommodation.getForCEO();
	    List<Hostel>         applyList        = hostel.getForCEO();
		List<Room>           roomList  = room.getForCEO();
	    
	    request.getSession().setAttribute("CEOReserve", reserveList);
	    request.getSession().setAttribute("CEOAccommodation", accommodationList);
	    request.getSession().setAttribute("CEOHostelApply", applyList);
	    request.getSession().setAttribute("CEORoomApply", roomList);
	    
		context.getRequestDispatcher("/hostel/CEO.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type.equals("hostelApply")){
			hostel.approve();			
		}
		else{
			room.approve();
		}
		request.getServletContext().getRequestDispatcher("/hostel/approveSuccess.jsp").forward(request, response);
	}

}
