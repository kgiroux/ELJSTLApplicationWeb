package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

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
	private List<Data> listResult;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public test_servlet() {
		super();
		listResult = new ArrayList<Data>();
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
		System.out.println("HELLO WORLD");
		response.setContentType("text/html;charset=UTF-8");
		Data data = null; 
		String[]SSNValue;
		String[]MultiplierValue;
		Enumeration<String> NomsParam = request.getParameterNames();
		//while(NomsParam.hasMoreElements()) {
			String nameParam = (String) NomsParam.nextElement();
			SSNValue = request.getParameterValues(nameParam);
			nameParam = (String)NomsParam.nextElement();
			MultiplierValue = request.getParameterValues(nameParam);
			
		//}
		
		for(int i = 0; i<SSNValue.length; i++){
			data = new Data();
			data.setSsn(SSNValue[i]);
			data.setMultiplier(MultiplierValue[i]);
			data.setBonus(calculateBonus(data.getMultiplier()));
			listResult.add(data);
		}
		
		System.out.println(listResult.toString());

		request.setAttribute("listResult", listResult);
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
