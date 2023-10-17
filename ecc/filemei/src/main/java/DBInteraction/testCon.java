package DBInteraction;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;



/**
 * Servlet implementation class testCon
 */
@WebServlet(name = "DBInteraction", urlPatterns = { "/DBInteraction" })
public class testCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
	            // connection	        	
	            String url = "jdbc:mysql://127.0.0.1:3306/test";
	            String user = "root";
	            String password = "123";
	            Connection conn = DriverManager.getConnection(url, user, password);
	            if (conn != null) {
	            	response.getWriter().write("success");
	            }
	        	} catch (SQLException ex) {
	        		response.getWriter().write("xxx");
	                ex.printStackTrace();
	        }
		} catch (ClassNotFoundException e) {
            
            e.printStackTrace();
		}		
	}

}
