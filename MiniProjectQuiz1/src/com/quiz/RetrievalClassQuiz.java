package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class RetrievalClassQuiz {
	int mark;
	public void retrievalOfQuiz() throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		ConnectionToDB con = new ConnectionToDB();
		connection = con.getConnectionDetails();
		ps = connection.prepareStatement("select * from questions");
		ResultSet set = ps.executeQuery();
		Scanner sc = new Scanner(System.in);
		
		LinkedHashMap<Integer, String> userAnswers = new LinkedHashMap<Integer, String>();
		LinkedHashMap<Integer, String> correctAnswers = new LinkedHashMap<Integer, String>();
		
		while (set.next()) {
			System.out.print(set.getInt(1) + ".");
			System.out.println(" " + set.getString(2));
			System.out.println("a)" + set.getString(3));
			System.out.println("b)" + set.getString(4));
			System.out.println("c)" + set.getString(5));
			System.out.println("d)" + set.getString(6));
			System.out.print("Select your option : ");
			String answer = sc.next();
			userAnswers.put(set.getInt(1), answer);
			correctAnswers.put(set.getInt(1), set.getString(7));
			if(userAnswers.equals(correctAnswers)) {
				mark = mark + 1;
			}else {
				mark = mark + 0;
			}
			System.out.println("--------------------------------------");
		}
		System.out.println(mark);
		
	}
	
}

