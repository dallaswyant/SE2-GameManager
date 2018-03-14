package edu.westga.cs3212.gamemanager.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import edu.westga.cs3212.gamemanager.Main;
import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

public class GameListViewController {

    @FXML
    private ListView<Game> inprogress_listview;

    @FXML
    private ListView<Game> completed_listview;

    @FXML
    private Button logout_btn;

    @FXML
    private Button newgame_btn;

    @FXML
    void completed_clicked(MouseEvent event) throws IOException {
    	if(this.completed_listview.getSelectionModel().getSelectedItem()!=null) {
    		Game currentGame = this.completed_listview.getSelectionModel().getSelectedItem();
    		Main.theManager.getTheUser().setCurrentGame(currentGame);
    		Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(Main.class.getResource(Main.COMPLETED_GAME_VIEW));
        	loader.load();
        	Scene gameView = new Scene(loader.getRoot());
        	currentStage.setScene(gameView);
    	}
    }

    @FXML
    void inprogress_clicked(MouseEvent event) throws IOException {
    	if(this.inprogress_listview.getSelectionModel().getSelectedItem()!=null&&event.getButton()==MouseButton.PRIMARY) {
    		Game currentGame = this.inprogress_listview.getSelectionModel().getSelectedItem();
    			Main.theManager.getTheUser().setCurrentGame(currentGame);
    			Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    			FXMLLoader loader = new FXMLLoader();
    			loader.setLocation(Main.class.getResource(Main.GAME_VIEW));
    			loader.load();
    			Scene gameView = new Scene(loader.getRoot());
    			currentStage.setScene(gameView);
    		

    	}
    }

    @FXML
    void logout_clicked(ActionEvent event) throws IOException {
    	Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource(Main.LANDING_VIEW));
    	loader.load();
    	Scene gameView = new Scene(loader.getRoot());
    	currentStage.setScene(gameView);
    }

    @FXML
    void newgame_clicked(ActionEvent event) throws IOException {
    	Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource(Main.NEW_GAME_VIEW));
    	loader.load();
    	Scene gameView = new Scene(loader.getRoot());
    	currentStage.setScene(gameView);
    }
    
    @FXML
    void initialize() {

    	this.inprogress_listview.setItems(Main.theManager.getInProgressGames());

    	this.completed_listview.setItems(Main.theManager.getCompletedGames());
    	
    	this.inprogress_listview.setCellFactory(new Callback<ListView<Game>, ListCell<Game>>() {

			@Override
			public ListCell<Game> call(ListView<Game> p) {
				final ContextMenu contextMenu = new ContextMenu();

				ListCell<Game> cell = new ListCell<Game>() {

					@Override
					protected void updateItem(Game t, boolean bln) {
						super.updateItem(t, bln);

						if(bln) return;

						if (t != null) {
							setText(t.toString());
						}
					}

				};
				MenuItem item1 = new MenuItem("Mark Game Complete");
				item1.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						if(Main.theManager.getTheUser().getInProgressGames().size()==1) {
							Main.theManager.getTheUser().getInProgressGames().remove(cell.getItem());
							Main.theManager.getTheUser().setInProgressGames(new ArrayList<Game>());
							Main.theManager.getTheUser().getCompletedGames().add(cell.getItem());
						} else {
							Main.theManager.getTheUser().getInProgressGames().remove(cell.getItem());
							Main.theManager.getTheUser().getCompletedGames().add(cell.getItem());
						}

						Main.theManager.setLastMovedGame(cell.getItem());

						GameListViewController.this.inprogress_listview.refresh();
						GameListViewController.this.completed_listview.refresh();
					}
					
				});
				contextMenu.getItems().addAll(item1);
				cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
					if (isNowEmpty) {
						cell.setText("");
						cell.setContextMenu(null);
						GameListViewController.this.inprogress_listview.getSelectionModel().clearSelection();

					} else {
						cell.setContextMenu(contextMenu);
					}
				});
				return cell;
			}
		});

    }

}