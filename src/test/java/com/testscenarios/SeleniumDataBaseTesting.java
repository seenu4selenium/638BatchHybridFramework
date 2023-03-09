package com.testscenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class SeleniumDataBaseTesting {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet rs;

	@BeforeClass
	public void connectingToDatabase() throws Exception {

//		Class.forName("com.mysql.cj.jdbc.Driver");
//		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/630batch", "root", "root");	

		String databaseURL = "jdbc:mysql://127.0.0.1:3306/638batch";
		String username = "root";
		String password = "admin@123";

		connection = null;
		try {

			// if your database is ORAVLE: use below command for classforname
			// Class.forName("oracle.jdbc.driver.OracleDriver");

			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("Connecting to Database...");
			connection = DriverManager.getConnection(databaseURL, username, password);
			if (connection != null) {
				System.out.println("Connected to the Database...");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void getDataFromDataBase() {
		try {
			// String query = "select * from LOCATION;";
			String query = "select * from student order by std_id";

			statement = connection.createStatement();
			// run the query
			rs = statement.executeQuery(query);
			// Run while loop n number of rows ...
			while (rs.next()) {
				// std_id, stu_name, stu_phone, stu_email
				String std_id = rs.getString(1);
				String stu_name = rs.getString(2);
				String stu_phone = rs.getString(3);
				String stu_email = rs.getString(4);

				System.out.println(std_id + "\t" + stu_name + "\t" + stu_phone + "\t" + stu_email + "\t");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@AfterClass
	public void closingDatabaseConnection() {
		if (connection != null) {
			try {
				System.out.println("Closing Database Connection...");
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}