package Middleware.warehouse;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CreateUserController.CreateUserController;
@WebServlet(name = "userDownload", urlPatterns = { "/userDownload" })
public class userDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String cookieFinal="";

	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads input file from an absolute path
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
		    for (Cookie cookie : cookies) {
		        String cookieName = cookie.getName();
		        if (cookieName.equals("filemeicookie")) { // Use .equals() for string comparison
		        	cookieFinal = cookie.getValue();
		            break; // Exit the loop once you've found the desired cookie
		        }
		    }
		}
        String filePath = request.getParameter("filename");
		if(!filePath.isEmpty()){
			CreateUserController getEmail = new CreateUserController();
			String email = getEmail.GetEmailOfCookie(cookieFinal);

			if(cookieFinal.isEmpty()) {
		        response.sendRedirect("http://localhost:8080/filemei/login/");
			}
			else {
				File downloadFile = new File("D:\\upload\\"+email+"\\"+filePath);
				FileInputStream inStream = new FileInputStream(downloadFile);
				
				// if you want to use a relative path to context root:
				String relativePath = getServletContext().getRealPath("");
				System.out.println("relativePath = " + relativePath);
				
				// obtains ServletContext
				ServletContext context = getServletContext();
				
				// gets MIME type of the file
				String mimeType = context.getMimeType(filePath);
				if (mimeType == null) {        
					// set to binary type if MIME mapping not found
					mimeType = "application/octet-stream";
				}
				System.out.println("MIME type: " + mimeType);
				
				// modifies response
				response.setContentType(mimeType);
				response.setContentLength((int) downloadFile.length());
				
				// forces download
				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename="+filePath);
				response.setHeader(headerKey, headerValue);
				
				// obtains response's output stream
				OutputStream outStream = response.getOutputStream();
				
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				while ((bytesRead = inStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
				
				inStream.close();
				outStream.close();     
				}
			}
		else {
	        response.sendRedirect("http://localhost:8080/filemei/login/");
		} 
    }
	
}