package DBController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionAction extends DBController {
    private String updateSql = "UPDATE authtb SET session = ? WHERE code = ?";
    private String updateSqlEmail = "UPDATE authtb SET session = ? WHERE email = ?";
    private String selectEmailSql = "SELECT email FROM authtb WHERE session = ?";
    public SessionAction() {
    }
    public void SetSessionByCode(String session, int code) throws SQLException {
        this.Connect("authdb");
        PreparedStatement updateStmt = this.connection.prepareStatement(updateSql);
        updateStmt.setString(1, session);
        updateStmt.setInt(2, code);
        int rowsAffected = updateStmt.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Session updated successfully.");
        } else {
            System.out.println("No rows updated. code not found.");
        }
    }
    
    public void SetSessionByEmail(String session, String email) throws SQLException {
        this.Connect("authdb");
        PreparedStatement updateStmt = this.connection.prepareStatement(updateSqlEmail);
        updateStmt.setString(1, session);
        updateStmt.setString(2, email);
        int rowsAffected = updateStmt.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Session updated successfully.");
        } else {
            System.out.println("No rows updated. setString not found.");
        }
    }

    public String GetEmailBySession(String session) {
        try {
        	this.Connect("authdb");
            PreparedStatement selectStmt = this.connection.prepareStatement(selectEmailSql);
            selectStmt.setString(1, session);
            ResultSet resultSet = selectStmt.executeQuery();
            
            if (resultSet.next()) {
                return resultSet.getString("email");
            } else {
                return null; // Không tìm thấy email cho session đã cung cấp.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Xử lý lỗi nếu có.
        }
    }
}
