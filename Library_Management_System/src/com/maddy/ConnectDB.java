package com.maddy;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;


public class ConnectDB {

	public static void main(String[] args) {
		Connection connection = null;
		
		try {
			
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Connection");
			if(connection != null){
				System.out.println("Connected successfully!");
			}
		} catch(Exception e){
			System.out.println("Not connected to database");
		}
		
		
		
	}

}
