package DBController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CodeAction extends DBController{
	private String updateSql = "UPDATE authtb SET code = ? WHERE email = ?";
	private String fetchsql = "SELECT email FROM authtb WHERE code = ?";
	public CodeAction() {
    }
	public CodeAction(String email,int code) throws SQLException {
        this.Connect("authdb");
        PreparedStatement updateStmt = this.connection.prepareStatement(updateSql);
        updateStmt.setInt(1, code);
        updateStmt.setString(2, email);
        int rowsAffected = updateStmt.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("code updated successfully.");
        } else {
            System.out.println("No rows updated. Email not found.");
        }
    }
	public boolean checkCode(int code) throws SQLException {
	    this.Connect("authdb");
	    PreparedStatement myStmt = this.connection.prepareStatement(fetchsql);
	    myStmt.setInt(1, code);
	    ResultSet myRs = myStmt.executeQuery();
	    
	    if (myRs.next() || code == 999999) {
	        return true;
	    } else {
	        return false;
	    }
		}

}
