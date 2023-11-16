package Middleware;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class logoutware
 */
public class logoutware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logoutware() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		    for (Cookie cookie : cookies) {
		        if (cookie.getName().equals("filemeicookie")) { // Replace "filemeicookie" with the name of your cookie
		            // Set the maximum age of the cookie to 0 to expire it
		            cookie.setMaxAge(0);

		            // Add the updated cookie to the response to remove it from the browser
		            response.addCookie(cookie);
		        }
		    }
		}
		response.sendRedirect("/filemei/home/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
