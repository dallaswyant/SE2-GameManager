package edu.westga.cs3212.gamemanager.view_model;

import java.util.ArrayList;
import java.util.Random;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.Player;
import edu.westga.cs3212.gamemanager.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GameManagerManager {

	private ObservableList<Game> completedGames;
	private ObservableList<Game> inProgressGames;
	private User theUser;
	private ObservableList<Player> playersInCurrentGame;
	
	public GameManagerManager() {
		this.theUser = new User("Name");
		this.populateUserWithGames();
		this.inProgressGames = FXCollections.observableList(this.theUser.getInProgressGames());
		this.completedGames = FXCollections.observableList(this.theUser.getCompletedGames());
		this.playersInCurrentGame = FXCollections.observableList(this.theUser.getCurrentGame().getPlayers());
	}
	
	private void populateUserWithGames() {
		for(int i=0;i<10;i++) {
			Game newGame = new Game("GAME"+i);
			Random random = new Random();
			for(int j=0;j<(random.nextInt(7)+1);j++) {
				newGame.addPlayer(new Player("PLAYER"+j,random.nextInt(100)));
			}
			this.theUser.addInProgressGame(newGame);
		}
	}
	
	public ObservableList<Game> getCompletedGames() {
		this.completedGames = FXCollections.observableList(this.theUser.getCompletedGames());
		return completedGames;
	}
	
	

	public void setCompletedGames(ObservableList<Game> completedGames) {
		this.completedGames = completedGames;
	}

	public void setInProgressGames(ObservableList<Game> inProgressGames) {
		this.inProgressGames = inProgressGames;
	}

	public void setPlayersInCurrentGame(ObservableList<Player> playersInCurrentGame) {
		this.playersInCurrentGame = playersInCurrentGame;
	}

	public ObservableList<Game> getInProgressGames() {
		this.inProgressGames = FXCollections.observableList(this.theUser.getInProgressGames());
		return inProgressGames;
	}

	public User getTheUser() {
		return theUser;
	}

	public ObservableList<Player> getPlayersInCurrentGame() {
		this.playersInCurrentGame = FXCollections.observableList(this.theUser.getCurrentGame().getPlayers());
		return playersInCurrentGame;
	}

	public void SaveCurrentGame() {
		Object[] players = this.playersInCurrentGame.toArray();
		ArrayList<Player> playerList = new ArrayList<Player>();
		for(int i=0;i<players.length;i++) {
			playerList.add((Player) players[i]);
		}
		String gameName = this.theUser.getCurrentGame().toString();
		Game theOldCurrentGame = new Game(gameName);
		for(Player currPlayer:playerList) {
			theOldCurrentGame.addPlayer(currPlayer);
		}
		int removalIndex = 55;
		int counter = 0;
		for(Game currGame:this.theUser.getInProgressGames()) {
			if(currGame==this.theUser.getCurrentGame()) {
				removalIndex = counter;
			}
			counter++;
		}
		if(removalIndex!=55) {
			this.theUser.getInProgressGames().remove(removalIndex);
		} 
			this.theUser.addInProgressGame(theOldCurrentGame);

		
	}
	
	
	
	
}
