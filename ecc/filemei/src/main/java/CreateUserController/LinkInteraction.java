package CreateUserController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LinkInteraction extends CreateUserController {
	private String updateFilepathSQl;
	private String getFilepathSQl;
	private String filepath;
	public LinkInteraction() {
		updateFilepathSQl="";
		filepath="";
	}
	public void LinkAdd(String email, String filename) {
		this.filepath = "http://localhost:8080/filemei/userDownload?filename="+filename;
		this.Connect("userdb");
		this.updateFilepathSQl = "INSERT INTO filesystem_"+this.extractUsername(email)+"(link) VALUES(?)";
		try {
			PreparedStatement updateStmt = this.connection.prepareStatement(updateFilepathSQl);
	        updateStmt.setString(1, filepath); // Set the parameter value

	        // Use executeUpdate for INSERT, UPDATE, DELETE queries
	        int rowsAffected = updateStmt.executeUpdate();
			if(rowsAffected>0) {
				System.out.print("update success");
			}
			else {
				System.out.print("update failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
	}
	public String GetLinkById(String email,int id) throws SQLException {
		this.Connect("userdb");
		this.getFilepathSQl= "SELECT link FROM filesystem_"+this.extractUsername(email)+ " WHERE id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(this.getFilepathSQl)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String link = resultSet.getString("link");
                    return link;
                }
            }
		}
		return "";
	}
	public int getNumberofId(String email) throws SQLException {
        String tableName = "filesystem_" + this.extractUsername(email);
        String idColumnName = "id";
        this.Connect("userdb");
        
            String query = "SELECT COUNT(" + idColumnName + ") AS idCount FROM " + tableName;
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    int idCount = resultSet.getInt("idCount");
                    return idCount;
                }
            }
           return 0;
    }
}
