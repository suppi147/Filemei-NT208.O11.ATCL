package Middleware;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBController.LoginAction;
import Middleware.CookieTrigger;

/**
 * Servlet implementation class loginware
 */
@WebServlet(name = "loginware", urlPatterns = { "/loginware" })
public class loginware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginware() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    try {
			LoginAction loginCheck = new LoginAction();
			CookieTrigger cookietrigger = new CookieTrigger();
			if(loginCheck.LoginCheck(email, password)) {
				response.addCookie(cookietrigger.GenCookieByEmail(email));
				System.out.print("wrong xxx");
				response.sendRedirect("/filemei/warehouse/");
			}
			else {
				
				response.sendRedirect("/filemei/login/");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}