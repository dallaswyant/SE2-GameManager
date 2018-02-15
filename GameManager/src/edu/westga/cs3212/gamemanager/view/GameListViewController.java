package edu.westga.cs3212.gamemanager.view;

import java.io.IOException;
import java.util.ArrayList;

import edu.westga.cs3212.gamemanager.Main;
import edu.westga.cs3212.gamemanager.model.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    void completed_clicked(MouseEvent event) {

    }

    @FXML
    void inprogress_clicked(MouseEvent event) {

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

    }

}