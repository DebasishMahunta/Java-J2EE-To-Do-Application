package todo.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection connection;
	
	public static Connection getCon() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","Pinku@123");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
