package Middleware;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBController.CodeAction;
import Middleware.CookieTrigger;

/**
 * Servlet implementation class codeware
 */
@WebServlet(name = "codeware", urlPatterns = { "/codeware" })

public class codeware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public codeware() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		int codeI = Integer.parseInt(code);
		CodeAction authCode = new CodeAction();
		try {
			if(authCode.checkCode(codeI)) {
				CookieTrigger cookietrigger = new CookieTrigger();
				response.addCookie(cookietrigger.GenCookie(codeI));
				response.sendRedirect("/filemei/warehouse/");
				
			}
			else {
				response.sendRedirect("/filemei/signup/EmailVerification.jsp");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
