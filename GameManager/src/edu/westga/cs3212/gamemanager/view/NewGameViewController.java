package edu.westga.cs3212.gamemanager.view;

import java.io.IOException;

import edu.westga.cs3212.gamemanager.Main;
import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class NewGameViewController {

	private ToggleGroup buttons;
    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio4;

    @FXML
    private RadioButton radio5;

    @FXML
    private RadioButton radio6;

    @FXML
    private RadioButton radio7;

    @FXML
    private RadioButton radio8;

    @FXML
    private Button cancel_btn;

    @FXML
    private Button confirm_btn;
    
    @FXML
    private TextField gameName;

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
    	this.setUpNewGame();
    	Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource(Main.GAME_VIEW));
    	loader.load();
    	Scene gameView = new Scene(loader.getRoot());
    	currentStage.setScene(gameView);
    }

	private void setUpNewGame() {
		Game newGame = new Game(gameName.getText());
    	RadioButton selected = (RadioButton) this.buttons.getSelectedToggle();
    	String value = selected.getId();
    	String[] values = value.split("o");
    	int span = Integer.parseInt(values[1]);//Integer.parseInt(range);
    	for(int i=0;i<span;i++) {
    		newGame.addPlayer(new Player("Player"+i,0));//0 for placeholding
    	}
    	Main.theManager.getTheUser().setCurrentGame(newGame);
	}
    
    @FXML
    void initialize() {
    	this.buttons = new ToggleGroup();
    	this.radio1.setToggleGroup(this.buttons);
    	this.radio1.setUserData("1");
    	this.radio1.setSelected(true);
    	this.radio2.setToggleGroup(this.buttons);
    	this.radio1.setUserData("2");
    	this.radio3.setToggleGroup(this.buttons);
    	this.radio1.setUserData("3");
    	this.radio4.setToggleGroup(this.buttons);
    	this.radio1.setUserData("4");
    	this.radio5.setToggleGroup(this.buttons);
    	this.radio1.setUserData("5");
    	this.radio6.setToggleGroup(this.buttons);
    	this.radio1.setUserData("6");
    	this.radio7.setToggleGroup(this.buttons);
    	this.radio1.setUserData("7");
    	this.radio8.setToggleGroup(this.buttons);
    	this.radio1.setUserData("8");
    }

}
