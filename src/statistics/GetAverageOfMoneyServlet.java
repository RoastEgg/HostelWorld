package statistics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccommodationDao;
import daoImpl.AccommodationDaoImpl;
import net.sf.json.JSONArray;

@WebServlet("/GetAverageOfMoneyServlet")
public class GetAverageOfMoneyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccommodationDao accommodationDao = new AccommodationDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("GetAreaOfCardServlet页面");
		
		ArrayList<Double> average = accommodationDao.getAverageOfMoney();

		JSONArray arr = new JSONArray();
		for (int i = 0; i < average.size(); i++) {
			arr.add(average.get(i));
		}

		System.out.println("JSON:"+arr);
		
		PrintWriter out = response.getWriter();
		out.print(arr);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}


