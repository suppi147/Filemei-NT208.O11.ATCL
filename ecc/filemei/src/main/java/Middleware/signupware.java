package Middleware;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBController.SignUpAction;
import Middleware.CookieTrigger;

/**
 * Servlet implementation class loginware
 */
@WebServlet(name = "signupware", urlPatterns = { "/signupware" })
public class signupware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupware() {
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
	    	SignUpAction signupInsert = new SignUpAction();
			CookieTrigger cookietrigger = new CookieTrigger();
			if(signupInsert.SignUpInsert(email, password)) {
				response.addCookie(cookietrigger.GenCookie(email));
				response.sendRedirect("/filemei/warehouse/");
			}
			else {
				response.sendRedirect("/filemei/signup/");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
