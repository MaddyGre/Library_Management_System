package com.maddy;

public class Validation {
	// validate email entered by the user
	public static boolean validateEmail(String email) {
		boolean status = false;
		String pattern = "^(.+)@(.+)$";
		
		if(pattern.matches(email)) {
			status = true;
		} else {
			System.out.println("Please enter a valid email");
			status = false;
		}
		
		return status;
		
	}
	
	public static boolean validatePassword(String password) {
		boolean status = false;
		String pattern = "[A-Za-z0-9] {9}";
		
		if(pattern.matches(password)) {
			status = true;
		} else {
			status = false;
		}
		
		return status;
		
	}

}
