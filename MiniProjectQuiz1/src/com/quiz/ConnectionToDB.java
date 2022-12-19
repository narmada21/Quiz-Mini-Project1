package com.quiz;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToDB {
	Connection connection = null;
	public Connection getConnectionDetails() {
		try {
			//Load the driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establish connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");
		}catch(Exception e) {
			System.out.println(e);
		}
		return connection;
	}

}
