package com.quiz;

import java.sql.SQLException;
import java.util.Scanner;

public class TestQuizClass {

	public static void main(String[] args) throws SQLException {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the student name :- ");
		String nameOfStudent = sc1.next();
		
		InsertDataToDB insert = new InsertDataToDB();
		insert.insertData(nameOfStudent);
		
		String gradeOfStudent = "";
		RetrievalClassQuiz retrieve = new RetrievalClassQuiz();
		retrieve.retrievalOfQuiz();
		
		if(retrieve.mark >= 8 && retrieve.mark <= 10) {
			System.out.println(gradeOfStudent = "A");
		}else if(retrieve.mark >= 6 && retrieve.mark <= 8) {
			System.out.println(gradeOfStudent = "B");
		}else if(retrieve.mark == 5) {
			System.out.println(gradeOfStudent = "C");
		}else if(retrieve.mark < 5) {
			System.out.println(gradeOfStudent = "Fail");
		}
		
		insert.insertData1(nameOfStudent, retrieve.mark, gradeOfStudent);
	}

}
