package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataToDB {
	Connection connection = null;
	PreparedStatement ps = null;
    public void insertData(String name) throws SQLException {
    	try {
    	ConnectionToDB con = new ConnectionToDB();
    	connection = con.getConnectionDetails();
    	ps = connection.prepareStatement("insert into student (studentName) values (?)");
    	ps.setString(1, name);
    	int i = ps.executeUpdate();
    	
    	System.out.println("Record is inserted..." + i);
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    public void insertData1(String name, int score, String grade) throws SQLException {
    	try {
    	ConnectionToDB con = new ConnectionToDB();
    	connection = con.getConnectionDetails();
    	ps = connection.prepareStatement("update student set studentScore = ? , grade = ? where studentName = ?");    	
    	ps.setInt(1, score);
    	ps.setString(2, grade);
    	ps.setString(3, name);
    	
    	int j = ps.executeUpdate();
    	
    	System.out.println("Record is inserted..." + j);
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
}

