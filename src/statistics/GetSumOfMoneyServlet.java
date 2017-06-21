
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

@WebServlet("/GetSumOfMoneyServlet")
public class GetSumOfMoneyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccommodationDao accommodationDao = new AccommodationDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("GetSumOfMoneyServlet页面");
		
		ArrayList<Double> sum = accommodationDao.getSumOfMoney();

		JSONArray arr = new JSONArray();
		for (int i = 0; i < sum.size(); i++) {
			arr.add(sum.get(i));
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

