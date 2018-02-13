package edu.westga.cs3212.gamemanager.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class NewGameViewController {

    @FXML
    private RadioButton radio_one;

    @FXML
    private RadioButton radio_two;

    @FXML
    private RadioButton radio_three;

    @FXML
    private RadioButton radio_four;

    @FXML
    private RadioButton radio_five;

    @FXML
    private RadioButton radio_six;

    @FXML
    private RadioButton radio_seven;

    @FXML
    private RadioButton radio_eight;

    @FXML
    private Button cancel_btn;

    @FXML
    private Button confirm_btn;

    @FXML
    void cancel_clicked(ActionEvent event) throws IOException {
    	Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource(Main.GAME_LIST_VIEW));
    	loader.load();
    	Scene gameView = new Scene(loader.getRoot());
    	currentStage.setScene(gameView);
    }

    @FXML
    void confirm_clicked(ActionEvent event) throws IOException {
    	Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource(Main.GAME_VIEW));
    	loader.load();
    	Scene gameView = new Scene(loader.getRoot());
    	currentStage.setScene(gameView);
    }

}
