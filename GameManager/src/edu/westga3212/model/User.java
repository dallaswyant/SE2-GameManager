package edu.westga3212.model;

import java.util.ArrayList;

public class User {
	private String username;
	private ArrayList<Game> completed;
	private ArrayList<Game> inProgress;
	
	public User(String username) {
		if (username == null) {
			throw new IllegalArgumentException("Invalid username");		
		}
		if (username.isEmpty()) {
			throw new IllegalArgumentException("Username not entered");
			
		}
		this.username = username;
		
	}
	
	
	

}
