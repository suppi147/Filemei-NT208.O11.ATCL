package CreateUserController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;

import DBController.DBController;
public class CreateUserController {
	private static String filesystem1query="CREATE TABLE filesystem_";
	private static String filesystem2query=" (id INT AUTO_INCREMENT PRIMARY KEY, link VARCHAR(255));";
	
	private static String accessfile1query="CREATE TABLE ";
	private static String accessfile2query="_access (id INT AUTO_INCREMENT PRIMARY KEY, email VARCHAR(50));";
	
	private static String getSessionQuery="CREATE TABLE ";

	private String url;
	private String user;
	private String password;
	protected Connection connection;
	
	public CreateUserController() {
		this.url = "jdbc:mysql://127.0.0.1:3306/";
		this.user = "root";
		this.password = "123";
		this.connection = null;
	}
	public void Connect(String dbname) {
		try {
			url += dbname;
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				connection = DriverManager.getConnection(url, user, password);
	            if(connection != null) {
	            	System.out.println("Success");
	            }
	        	} catch (SQLException ex) {
	                ex.printStackTrace();
	        }
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
		}
	}
	public static String extractUsername(String email) {
        int atIndex = email.indexOf('@'); // Find the position of the "@" symbol
        if (atIndex != -1) {
            return email.substring(0, atIndex); // Extract the substring before "@"
        } else {
            // Handle the case where "@" is not present in the email
            return "Invalid Email Format";
        }
	}
	public void CreateFolder(String email) {
        // Specify the path of the folder you want to create
        String folderPath = "D:\\upload\\"+email;

        // Create a File object for the folder
        File folder = new File(folderPath);

        // Check if the folder already exists
        if (!folder.exists()) {
            // If it doesn't exist, create the folder
            boolean folderCreated = folder.mkdir();

            if (folderCreated) {
                System.out.println("Folder created successfully.");
            } else {
                System.out.println("Failed to create the folder.");
            }
        } else {
            System.out.println("The folder already exists.");
        }
    }
	public String GetEmailOfCookie(String cookie) {
		String email ="";
		try {
			this.Connect("authDB");
	        // Establish a database connection (replace with your database connection logic)
			
	        // Prepare a SQL query to retrieve the email associated with the provided cookie
	        String sql = "SELECT email FROM authtb WHERE session = ?";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        stmt.setString(1, cookie);

	        // Execute the query
	        ResultSet rs = stmt.executeQuery();

	        // Check if a result was found
	        if (rs.next()) {
	            email = rs.getString("email");
	        }
	    } catch (SQLException e) {
	        // Handle any database-related exceptions here
	        e.printStackTrace();
	    }
		return email;
	}
	public void CreateFilesystem(String email) {
		String query= filesystem1query + extractUsername(email) + filesystem2query;
		this.Connect("userdb");
		PreparedStatement createTableStmt;
		System.out.print(query);
		try {
			createTableStmt = this.connection.prepareStatement(query);
			try {
		        createTableStmt.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace(); // Handle or log any SQL exceptions here
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CreateFolder(email);
	}
}
