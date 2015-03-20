package com.gcit.training.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Practise {

	public static void main(String[] args) {

		try {
			
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/library", "root", "");
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from tbl_author");

			while (rs.next()) {
				System.out.println("####################");
				System.out.println("AuthorId:" + rs.getInt("authorId"));
				System.out
						.println("Author Name: " + rs.getString("authorName"));
				System.out.println("####################");
			}
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a new Author Name: ");
			
			String author = scan.next();
			
			stmt.executeUpdate("insert into tbl_author (authorName) values ('" + author + "')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
