package edu.westga.cs3212.gamemanager.view;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import edu.westga.cs3212.gamemanager.Main;
import edu.westga.cs3212.gamemanager.model.Player;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
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
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Add new Player");
		dialog.setHeaderText("Please input the name and the score for the new player.");

		ButtonType confirmButton = new ButtonType("Confirm", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(confirmButton, ButtonType.CANCEL);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField newPlayerName = new TextField();
		newPlayerName.setPromptText("New Player");
		TextField newPlayerPoints = new TextField();
		newPlayerPoints.setPromptText("0");

		grid.add(new Label("Player name:"), 0, 0);
		grid.add(newPlayerName, 1, 0);
		grid.add(new Label("Points:"), 0, 1);
		grid.add(newPlayerPoints, 1, 1);

		Node loginButton = dialog.getDialogPane().lookupButton(confirmButton);
		loginButton.setDisable(true);

		newPlayerName.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(grid);

		Platform.runLater(() -> newPlayerName.requestFocus());

		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == confirmButton) {
				return new Pair<>(newPlayerName.getText(), newPlayerPoints.getText());
			}
			return null;
		});

		Optional<Pair<String, String>> result = dialog.showAndWait();

		result.ifPresent(playerNamePoints -> {
			int points = 0;
			try {
				points = Integer.parseInt(playerNamePoints.getValue());
			} catch (Exception e) {

			}
			Player newPlayer = new Player(playerNamePoints.getKey(), points);
			Main.theManager.getTheUser().getCurrentGame().addPlayer(newPlayer);
			this.players
					.setItems(FXCollections.observableList(Main.theManager.getTheUser().getCurrentGame().getPlayers()));
			
		});
	}

	private void saveGame() {
		Main.theManager.saveCurrentGame();
	}

	@FXML
	void initialize() {
		this.players.setItems(FXCollections.observableList(Main.theManager.getTheUser().getCurrentGame().getPlayers()));
		this.gameNameLabel.setText(Main.theManager.getTheUser().getCurrentGame().toString());
		this.players.setCellFactory(new Callback<ListView<Player>, ListCell<Player>>() {

			@Override
			public ListCell<Player> call(ListView<Player> p) {
				final ContextMenu contextMenu = new ContextMenu();

				ListCell<Player> cell = new ListCell<Player>() {

					@Override
					protected void updateItem(Player t, boolean bln) {
						super.updateItem(t, bln);
						if (t != null) {
							setText(t.toString());
						}
					}

				};
				MenuItem item1 = new MenuItem("Edit player");
				item1.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						Player playerToEdit = cell.getItem();
						Dialog<Pair<String, String>> dialog = new Dialog<>();
						dialog.setTitle("Edit selected player");
						dialog.setHeaderText("Edit the selected player");

						ButtonType confirmButton = new ButtonType("Confirm", ButtonData.OK_DONE);
						dialog.getDialogPane().getButtonTypes().addAll(confirmButton, ButtonType.CANCEL);

						GridPane grid = new GridPane();
						grid.setHgap(10);
						grid.setVgap(10);
						grid.setPadding(new Insets(20, 150, 10, 10));

						TextField newPlayerName = new TextField();
						newPlayerName.setText(playerToEdit.getName());
						newPlayerName.setPromptText(playerToEdit.getName());
						TextField newPlayerPoints = new TextField();
						newPlayerPoints.setText(Integer.toString(playerToEdit.getPoints()));
						newPlayerPoints.setPromptText(Integer.toString(playerToEdit.getPoints()));

						grid.add(new Label("Player name:"), 0, 0);
						grid.add(newPlayerName, 1, 0);
						grid.add(new Label("Points:"), 0, 1);
						grid.add(newPlayerPoints, 1, 1);

						Node loginButton = dialog.getDialogPane().lookupButton(confirmButton);
						loginButton.setDisable(true);

						newPlayerName.textProperty().addListener((observable, oldValue, newValue) -> {
							loginButton.setDisable(newValue.trim().isEmpty());
						});

						dialog.getDialogPane().setContent(grid);

						Platform.runLater(() -> newPlayerName.requestFocus());

						dialog.setResultConverter(dialogButton -> {
							if (dialogButton == confirmButton) {
								return new Pair<>(newPlayerName.getText(), newPlayerPoints.getText());
							}
							return null;
						});

						Optional<Pair<String, String>> result = dialog.showAndWait();

						result.ifPresent(playerNamePoints -> {
							int points = 0;
							try {
								points = Integer.parseInt(playerNamePoints.getValue());
							} catch (Exception l) {

							}
							Player originalPlayer = playerToEdit;
							playerToEdit.setName(playerNamePoints.getKey());
							playerToEdit.setPoints(points);
							Main.theManager.getTheUser().getCurrentGame().removePlayer(originalPlayer);
							Main.theManager.getTheUser().getCurrentGame().addPlayer(playerToEdit);
							GameViewController.this.players.setItems(FXCollections
									.observableList(Main.theManager.getTheUser().getCurrentGame().getPlayers()));
						});
					}
				});
				contextMenu.getItems().addAll(item1);
				cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
					if (isNowEmpty) {
						cell.setContextMenu(null);
					} else {
						cell.setContextMenu(contextMenu);
					}
				});
				return cell;
			}
		});

	}

}
