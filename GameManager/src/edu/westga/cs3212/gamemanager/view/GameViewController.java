package edu.westga.cs3212.gamemanager.view;

import java.io.IOException;

import edu.westga.cs3212.gamemanager.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameViewController {

    @FXML
    private Button return_btn;

    @FXML
    private Label gameNameLabel;
    
    @FXML
    void return_clicked(ActionEvent event) throws IOException {
    	Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource(Main.GAME_LIST_VIEW));
    	loader.load();
    	Scene gameView = new Scene(loader.getRoot());
    	currentStage.setScene(gameView);
    }


}
