package DBController;

import java.sql.*;
import java.util.Random;

import javax.servlet.http.Cookie;
import DBController.DBController;

public class LoginAction extends DBController {
	private String fetchsql = "SELECT password FROM authtb WHERE email = ?";
	public LoginAction() {
		
	}

	public boolean LoginCheck(String email, String password) throws SQLException {
		this.Connect("authdb");
		PreparedStatement myStmt = this.connection.prepareStatement(fetchsql);
		 myStmt.setString(1, email);
		 ResultSet myRs= myStmt.executeQuery();
        if (myRs.next()) {
       	 String checkpass = myRs.getString("password");
       	 return password.equals(checkpass);
        }
        
        return false;
	}
	public String GetPassword(String email) throws SQLException {
		this.Connect("authdb");
		PreparedStatement myStmt = this.connection.prepareStatement(fetchsql);
		 myStmt.setString(1, email);
		 ResultSet myRs= myStmt.executeQuery();
        if (myRs.next()) {
       	 String checkpass = myRs.getString("password");
       	 return checkpass;
        }
        return "";
	}
}
