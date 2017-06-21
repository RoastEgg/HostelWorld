
package statistics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HostelDao;
import daoImpl.HostelDaoImpl;
import net.sf.json.JSONArray;

@WebServlet("/GetAreaOfHostelServlet")
public class GetAreaOfHostelServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HostelDao hostelDao = new HostelDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("GetAreaOfHostelServlet页面");
		
		ArrayList<Integer> areaDistribution = hostelDao.areaOfHostel();

		JSONArray arr = new JSONArray();
		for (int i = 0; i < areaDistribution.size(); i++) {
			arr.add(areaDistribution.get(i));
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
