package project.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	static Connection con;
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/textileallures";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
		
	public static Connection getConnection() {
		try {
			//load driver
			Class.forName(DB_DRIVER);
			try {
				//create connection
				con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
				System.out.println("Connected");
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
