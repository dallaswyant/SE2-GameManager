package edu.westga3212.model;

import java.util.ArrayList;

public class Game {
	private ArrayList<Player> players;
	private Boolean isCompleted;
	private String name;
	private String type;
	
	//TODO constructor
	public Game(String name, String type) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid game name");		
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Game name not entered");
			
		}
		if (type == null) {
			throw new IllegalArgumentException("Invalid game type");		
		}
		if (type.isEmpty()) {
			throw new IllegalArgumentException("Game type not entered");
			
		}
		
		name = this.name;
		type = this.type;
		//I have set to false so each game starts as a new
		this.isCompleted = false;
		
	}
	
	//TODO 
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	//TODO
	public void removePlayer(Player player) {
		this.players.remove(player);
	}
	
	//TODO
	public int getNumberOfPlayers() {
		return this.players.size();
	}
	
	//TODO
	public Boolean getCompletedStatus() {
		if (this.isCompleted == true) {
			return true;
		}
		else {
			return false;
		}
	}
	//TODO
	public void setCompleteStatus(Boolean status) {
		if (status == true) {
			this.isCompleted = true;
		}
		else {
			this.isCompleted = false;
		}
	}
	
	
	
	
	
	
	
}
