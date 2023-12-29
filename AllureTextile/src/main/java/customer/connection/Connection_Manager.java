package customer.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_Manager {
	static Connection con = null;
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/textileallures";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	
	public static Connection getConnection() throws SQLException{
		
		
			
			try {
				Class.forName(DB_DRIVER); // load the driver
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
				
				con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD); // connection to phpmyadmin or database
				System.out.println("Connected");
			
		
		
		return con; //return the connection
	}
	

}
