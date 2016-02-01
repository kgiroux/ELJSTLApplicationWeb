package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Data;

/**
 * Servlet implementation class test_servlet
 */
@WebServlet("/test_servlet")
public class test_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public test_servlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String calculateBonus(String multiplier){
		if(!multiplier.equals(""))
			return String.valueOf(Integer.parseInt(multiplier)*10);
		else
			return "";
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		Data data = new Data();

		data.setSsn(request.getParameter("SSN"));
		data.setMultiplier(request.getParameter("multiplier"));
		data.setBonus(calculateBonus(data.getMultiplier()));

		request.setAttribute("data", data);

		request.getRequestDispatcher("result.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request,response);
	}

}
