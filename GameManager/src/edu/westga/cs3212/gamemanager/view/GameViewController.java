package edu.westga.cs3212.gamemanager.view;

import java.io.IOException;
import java.util.Optional;

import edu.westga.cs3212.gamemanager.Main;
import edu.westga.cs3212.gamemanager.model.Player;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Pair;

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
    private Button addPlayer_btn;

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
	

    @FXML
    void addPlayer_clicked(ActionEvent event) {
    	// Create the custom dialog.
    	Dialog<Pair<String, String>> dialog = new Dialog<>();
    	dialog.setTitle("Login Dialog");
    	dialog.setHeaderText("Look, a Custom Login Dialog");


    	// Set the button types.
    	ButtonType loginButtonType = new ButtonType("Confirm", ButtonData.OK_DONE);
    	dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

    	// Create the username and password labels and fields.
    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	grid.setPadding(new Insets(20, 150, 10, 10));

    	TextField username = new TextField();
    	username.setPromptText("New Player");
    	TextField points = new TextField();
    	points.setPromptText("0");

    	grid.add(new Label("Player name:"), 0, 0);
    	grid.add(username, 1, 0);
    	grid.add(new Label("Points:"), 0, 1);
    	grid.add(points, 1, 1);

    	// Enable/Disable login button depending on whether a username was entered.
    	Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
    	loginButton.setDisable(true);

    	// Do some validation (using the Java 8 lambda syntax).
    	username.textProperty().addListener((observable, oldValue, newValue) -> {
    	    loginButton.setDisable(newValue.trim().isEmpty());
    	});

    	dialog.getDialogPane().setContent(grid);

    	// Request focus on the username field by default.
    	Platform.runLater(() -> username.requestFocus());

    	// Convert the result to a username-password-pair when the login button is clicked.
    	dialog.setResultConverter(dialogButton -> {
    	    if (dialogButton == loginButtonType) {
    	        return new Pair<>(username.getText(), points.getText());
    	    }
    	    return null;
    	});

    	Optional<Pair<String, String>> result = dialog.showAndWait();

    	result.ifPresent(usernamePassword -> {
    	    System.out.println("Name=" + usernamePassword.getKey() + ", Points=" + usernamePassword.getValue());
    	});
    }

	private void saveGame() {
		Main.theManager.saveCurrentGame();
	}

	@FXML
	void initialize() {
		this.players.setItems(FXCollections.observableList(Main.theManager.getTheUser().getCurrentGame().getPlayers()));
		this.gameNameLabel.setText(Main.theManager.getTheUser().getCurrentGame().toString());
	}

}
