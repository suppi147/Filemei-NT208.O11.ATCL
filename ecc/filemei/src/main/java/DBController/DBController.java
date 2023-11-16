package DBController;
import java.sql.*;

public class DBController {
	private String url;
	private String user;
	private String password;
	protected Connection connection;
	
	public DBController() {
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
}

