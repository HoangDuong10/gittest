package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection(){
		Connection c = null;
		 
		try {
			com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			String url ="jdbc:mySQL://localhost:3306/nhasach";
			String username ="root";
			String password ="";
			
			c=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void info(Connection c) {
		try {
			if(c!=null) {
				System.out.println(c.getMetaData().toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
