package eu.unicredit.fiipractic.integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "fii_practic";
	static String user = "root";
	static String password = "";

	public static Connection getConnection() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection(url + dbName, user, password);
		
		return con;
	}
}
