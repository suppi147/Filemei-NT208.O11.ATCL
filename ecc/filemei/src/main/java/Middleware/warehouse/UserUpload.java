package Middleware.warehouse;


import javax.servlet.http.HttpServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import CreateUserController.CreateUserController;
import CreateUserController.LinkInteraction;
import Middleware.share.CopyFileShare;

@WebServlet(name = "UserUpload", urlPatterns = { "/UserUpload" })
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1000, // 1 GB
  maxFileSize = 1024 * 1024 * 1000,      // 1GB
  maxRequestSize = 1024 * 1024 * 1000   // 1GB
)

/**
 * Servlet implementation class FilemeiUpload
 */
public class UserUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String cookieFinal="";
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)   throws ServletException, IOException {
		String filename = req.getParameter("filename");
		req.setAttribute("filename", filename);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Receive file uploaded to the Servlet from the HTML5 form */
		Cookie[] cookies = request.getCookies();
		String cookieValue = "";

		if (cookies != null) {
		    for (Cookie cookie : cookies) {
		        String cookieName = cookie.getName();
		        if (cookieName.equals("filemeicookie")) { // Use .equals() for string comparison
		            cookieValue = cookie.getValue();
		            break; // Exit the loop once you've found the desired cookie
		        }
		    }
		}
		String fileName="";
		cookieFinal= cookieValue;
		try {
			for (Part part : request.getParts()) {
				fileName = extractFileName(part);
				// refines the fileName in case it is an absolute path
				fileName = new File(fileName).getName();
				if(!fileName.isEmpty()){
					part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
					//response.getWriter().print("upload success.");
				}
			  }
			// Assuming you have an HttpServletRequest object called "request"
			

		} catch (Exception e) {
			response.getWriter().print("upload failed.");
		}
		CreateUserController getEmail = new CreateUserController();
		String email = getEmail.GetEmailOfCookie(cookieValue);
		LinkInteraction linkinsert = new LinkInteraction();
		linkinsert.LinkAdd(email, fileName);
	  }
	  private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
		  if (s.trim().startsWith("filename")) {
			return s.substring(s.indexOf("=") + 2, s.length() - 1);
		  }
		}
		return "";
	  }
	  public File getFolderUpload() {
		  CreateUserController getEmail = new CreateUserController();
		  String email = getEmail.GetEmailOfCookie(cookieFinal);
		File folderUpload = new File("/root/upload/"+email+"/");
		if (!folderUpload.exists()) {
		  folderUpload.mkdirs();
		  
		}
		return folderUpload;
	  }
}