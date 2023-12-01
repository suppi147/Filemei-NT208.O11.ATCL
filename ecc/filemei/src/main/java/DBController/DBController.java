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
		this.password = "";
		this.connection = null;
	}
	public void Connect(String dbname) {
		try {
			this.url += dbname;
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				this.connection = DriverManager.getConnection(this.url, this.user, this.password);
	            if(this.connection != null) {
	            	System.out.println("Success");
	            }
	        	} catch (SQLException ex) {
	        		System.out.println("Failed");
	                ex.printStackTrace();
	        }
	        
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
		}
	}
}

