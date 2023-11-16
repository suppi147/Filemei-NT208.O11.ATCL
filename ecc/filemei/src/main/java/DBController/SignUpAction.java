package DBController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpAction extends DBController {
    private String insertSql = "INSERT INTO authtb (email, password) VALUES (?, ?)";
    private String selectSql = "SELECT password FROM authtb WHERE email = ?";
    public SignUpAction() {
        this.Connect("authdb");
    }
    public boolean isEmailExist(String email) throws SQLException {
        PreparedStatement selectStmt = this.connection.prepareStatement(selectSql);
        selectStmt.setString(1, email);
        ResultSet resultSet = selectStmt.executeQuery();
        return resultSet.next(); // Returns true if the email already exists in the database.
    }

    public boolean SignUpInsert(String email, String password) throws SQLException {
        PreparedStatement myStmt = this.connection.prepareStatement(insertSql);
        myStmt.setString(1, email);
        myStmt.setString(2, password);
        if(isEmailExist(email)) {
        	return false;
        }

        int rowsAffected = myStmt.executeUpdate();
        return rowsAffected > 0;
    }
}
