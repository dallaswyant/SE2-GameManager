package edu.westga3212.model;

public class Player {
	
	private int points;
	private String name;
	
	//TODO Player constructor specification
	
	public Player(String name, int points) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid name");		
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name not entered");
			
		}
		//I added this just in case if we are not using negative ints
		if(points < 0) {
			throw new IllegalArgumentException("Points may not be negative");
		}
		
		
		name = this.name;
		points = this.points;
		
	}
	
	//TODO
	public int getPoints() {
		return points;
	}
	
	//TODO
	public void setPoints(int points) {
		this.points = points;
	}
	
	//TODO
	public String getName() {
		return name;
	}
	
	//TODO
	public void setName(String name) {
		this.name = name;
	}
	
	public void addPoints(int amount) {
		this.points = this.getPoints() + points;
	}
	

}
