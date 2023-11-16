package Middleware.share;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Middleware.share.CopyFileShare;
import CreateUserController.ShareInteraction;
/**
 * Servlet implementation class shareware
 */
public class shareware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shareware() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename = request.getParameter("filename");
	    String recipientEmail = request.getParameter("recipientEmail");
	    String userEmail = request.getParameter("userEmail");
	    CopyFileShare copyFileShare = new CopyFileShare();
	    copyFileShare.share(recipientEmail, userEmail, filename);
	    ShareInteraction updateShare2DB= new ShareInteraction();
	    updateShare2DB.ShareTrigger(recipientEmail, filename,userEmail);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
