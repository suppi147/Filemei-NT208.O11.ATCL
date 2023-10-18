package DBController;

import java.sql.*;


public class LoginAction extends DBController {
	private String fetchsql = "SELECT password FROM authtb WHERE email = ?";
	public LoginAction(String username, String password) throws SQLException {
		this.Connect("authdb");
		 PreparedStatement myStmt = this.connection.prepareStatement(fetchsql);
		 myStmt.setString(1, username);
		 ResultSet myRs= myStmt.executeQuery();
         if (myRs.next()) {
        	 String checkpass = myRs.getString("password");
        	 if(password.equals(checkpass))
             {
            	 System.out.print("in");
             }
             else {
            	 System.out.print("out");
             }
         }
         
         
	}
}
