/**
 * 
 */
package edu.westga.cs3212.gamemanager.communitcations;

import java.util.ArrayList;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.User;

/**
 * @author Group 2
 * @version Spring 2018
 *
 */
public class ServComm {
	private final String SEPERATOR = ",";

	/**
	 * Sends the data to the server of the current user to save
	 * 
	 * @precondition none
	 * @postcondition Data sent
	 * 
	 * @param user
	 *            User data to send
	 */
	public void sendUserData(User user) {
		StringBuilder sb = new StringBuilder();
		String data = "";
		ArrayList<Game> listData = new ArrayList<Game>();

		sb.append("Username" + SEPERATOR + user.getUserName() + SEPERATOR);
		data = user.getCurrentGame().toString();
		sb.append("Current game" + SEPERATOR + data + SEPERATOR);
		listData = user.getInProgressGames();
		sb.append("InProgress Games" + SEPERATOR);
		for (Game current : listData) {
			sb.append(current.toString() + SEPERATOR);
		}
		listData = user.getCompletedGames();
		sb.append("Completed Games" + SEPERATOR);
		for (Game current : listData) {
			sb.append(current.toString() + SEPERATOR);
		}
	}

	/**
	 * Receives the incoming data from the server to load a user profile.
	 * 
	 * @param dataFile
	 *            The incoming data file.
	 * @return The data split into an array on ","
	 */
	public String[] recieveIncomingData(String dataFile) {
		String[] inData = dataFile.split(SEPERATOR);

		return inData;
	}

}
