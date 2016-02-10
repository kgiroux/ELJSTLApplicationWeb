package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tp15_servlet
 */
@WebServlet("/CalculateBonus10")
public class tp15_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	session.CalculatriceLocalForEntiteLocal Ejb;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public tp15_servlet() {
		super();
	}
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		InitialContext ctx = null;
		String[]SSNValue = null;
		String[]MultiplierValue = null;
		
		Enumeration<String> NomsParam = request.getParameterNames();
		
		while(NomsParam.hasMoreElements()) {
			String nameParam = (String) NomsParam.nextElement();
			if("multiplier".equals(nameParam)){
				MultiplierValue = request.getParameterValues(nameParam);
			}else if("SSN".equals(nameParam)){
				SSNValue = request.getParameterValues(nameParam);
			}else{
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
        	session.CalculatriceLocalForEntiteLocal ref = (session.CalculatriceLocalForEntiteLocal)ctx.lookup("java:global/CalculatriceEJBEntite/CalculatriceLocalForEntite!session.CalculatriceLocalForEntiteLocal");
        	
        	request.setAttribute("result",ref.get_bonus(request.getParameter("SSN")));
        } 
        catch (NamingException ex) {
            System.out.println(ex.getMessage());
        } finally {            
        	request.getRequestDispatcher("index.jsp").forward(request, response);

        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
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
