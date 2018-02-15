package edu.westga.cs3212.gamemanager.view_model;

import java.util.ArrayList;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.Player;
import edu.westga.cs3212.gamemanager.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

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
		this.theUser.addInProgressGame(new Game("FOOTBALL"));
		this.theUser.addInProgressGame(new Game("SOCCER"));
		this.theUser.addInProgressGame(new Game("BASEBALL"));
		this.theUser.addInProgressGame(new Game("BOWLING"));
		this.theUser.addInProgressGame(new Game("SLEEPING"));
		this.theUser.addInProgressGame(new Game("BALLROOM DANCING"));
		this.theUser.addInProgressGame(new Game("GOLF"));
		this.theUser.addInProgressGame(new Game("SKIING"));
		this.theUser.addCompletedGame(new Game("D&D"));
		this.theUser.addCompletedGame(new Game("CHESS"));
		this.theUser.addCompletedGame(new Game("CHECKERS"));
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
			System.out.println(players[i]);
			playerList.add((Player) players[i]);
		}
		String gameName = this.theUser.getCurrentGame().toString();
		Game theOldCurrentGame = new Game(gameName);
		for(Player currPlayer:playerList) {
			theOldCurrentGame.addPlayer(currPlayer);
		}
		this.theUser.addInProgressGame(theOldCurrentGame);
	}
	
	
	
	
}
