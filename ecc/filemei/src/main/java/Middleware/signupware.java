package Middleware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBController.SignUpAction;

import DBController.CodeAction;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import CreateUserController.CreateUserController;
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
    public static int generateRandomSixDigitNumber() {
        Random random = new Random();
        int min = 100000; // Số nhỏ nhất có 6 chữ số (100000)
        int max = 999998; // Số lớn nhất có 6 chữ số (999999)
        
        
        int randomSixDigitNumber = random.nextInt((max - min) + 1) + min;
        
        return randomSixDigitNumber;
    }
    public static void SendCode(int code, String email) {
        try {
            String url = "http://ec2-18-142-228-207.ap-southeast-1.compute.amazonaws.com/codegen.php?code="+code+"&email="+email;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                System.out.println(response.toString());
            } else {
                System.out.println("HTTP Request failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    try {
	    	SignUpAction signupInsert = new SignUpAction();
			if(signupInsert.SignUpInsert(email, password)) {
				int code = generateRandomSixDigitNumber();
				CodeAction authCode = new CodeAction(email,code);
				SendCode(code,email);
				CreateUserController sendEmail2UserController = new CreateUserController();
				sendEmail2UserController.CreateFilesystem(email);
				sendEmail2UserController.ShareFilesystem(email);
				response.sendRedirect("/filemei/signup/EmailVerification.jsp");
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
