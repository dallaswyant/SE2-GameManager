package edu.westga.cs3212.gamemanager.view;

import java.io.IOException;

import edu.westga.cs3212.gamemanager.Main;
import edu.westga.cs3212.gamemanager.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class GameViewController {

	@FXML
	private Button return_btn;

	@FXML
	private Label gameNameLabel;

	@FXML
	private ListView<Player> players;

	@FXML
	private Button minus_btn;

	@FXML
	private Button plus_btn;

	@FXML
	void minus_clicked(ActionEvent event) {
		if (this.players.getSelectionModel().getSelectedItem() != null) {
			this.players.getSelectionModel().getSelectedItem()
					.removePoints(Main.theManager.getTheUser().getCurrentGame().getPointIncrementValue());
			this.players.refresh();
		}
	}

	@FXML
	void plus_clicked(ActionEvent event) {
		if (this.players.getSelectionModel().getSelectedItem() != null) {
			this.players.getSelectionModel().getSelectedItem()
					.addPoints(Main.theManager.getTheUser().getCurrentGame().getPointIncrementValue());
			this.players.refresh();
		}

	}

	@FXML
	void return_clicked(ActionEvent event) throws IOException {
		this.saveGame();
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Main.GAME_LIST_VIEW));
		loader.load();
		Scene gameView = new Scene(loader.getRoot());
		currentStage.setScene(gameView);
	}

	private void saveGame() {
		Main.theManager.saveCurrentGame();
	}

	@FXML
	void initialize() {
		this.players.setItems(Main.theManager.getPlayersInCurrentGame());
		this.gameNameLabel.setText(Main.theManager.getTheUser().getCurrentGame().toString());
	}

}
