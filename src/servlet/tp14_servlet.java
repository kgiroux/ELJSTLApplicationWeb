package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculateBonus9")
public class tp14_servlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@EJB
	session.CalculatriceLocalForEntiteLocal Ejb;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public tp14_servlet() {
		super();
	}
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		InitialContext ctx = null;
		
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
