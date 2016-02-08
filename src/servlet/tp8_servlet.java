package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tp8_servlet
 */
@WebServlet("/CalculateBonus3")
public class tp8_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public tp8_servlet() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HELLO WORLD");
		response.setContentType("text/html;charset=UTF-8");
		InitialContext ctx = null;
		PrintWriter out = response.getWriter();

		String[] SSNValue = null;
		String[] MultiplierValue = null;

		Enumeration<String> NomsParam = request.getParameterNames();
		while (NomsParam.hasMoreElements()) {
			String nameParam = (String) NomsParam.nextElement();
			if ("multiplier".equals(nameParam)) {
				MultiplierValue = request.getParameterValues(nameParam);
			} else if ("SSN".equals(nameParam)) {
				System.out.println(nameParam);
				SSNValue = request.getParameterValues(nameParam);
			} else {
				System.out.print("No used parameter");
			}
		}

		List<Map<String, String>> parameters = new ArrayList<Map<String, String>>();
		Map<String, String> couple = null;

		for (int i = 0; i < SSNValue.length; i++) {
			couple = new HashMap<String, String>();
			couple.put("SSN", SSNValue[i]);
			couple.put("Multiplier", MultiplierValue[i]);
			parameters.add(couple);
		}

		try {
			ctx = new InitialContext();
			session.CalculatriceDistantRemote ref = (session.CalculatriceDistantRemote) ctx
					.lookup("java:global/CalculatriceDistant/CalculatriceDistant!session.CalculatriceDistantRemote");
			request.setAttribute("listResult", ref.calculateBonus(parameters).getListCouple());
		} catch (NamingException ex) {
			System.out.println(ex.getMessage());
		} finally {
			out.close();
		}
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}
}
