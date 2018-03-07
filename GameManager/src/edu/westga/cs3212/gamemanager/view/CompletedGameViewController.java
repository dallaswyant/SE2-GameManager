package edu.westga.cs3212.gamemanager.view;

import java.io.IOException;
import java.util.ArrayList;

import edu.westga.cs3212.gamemanager.Main;
import edu.westga.cs3212.gamemanager.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

	public class CompletedGameViewController {

	    @FXML
	    private Button back_btn;

	    @FXML
	    private Label gameName_lbl;

	    @FXML
	    private Label otherPlayers_txt;

	    @FXML
	    private Label winner_txt;

	    @FXML
	    void back_clicked(ActionEvent event) throws IOException {
	    	//GO BACK TO GAMELISTVIEW
	    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Main.GAME_LIST_VIEW));
			loader.load();
			Scene gameView = new Scene(loader.getRoot());
			currentStage.setScene(gameView);
		}
	    
	    @FXML
	    void initialize() {
	    	this.gameName_lbl.setText(Main.theManager.getTheUser().getCurrentGame().toString());
	    	String results = "";
	    	Main.theManager.getTheUser().getCurrentGame().getPlayers().sort(Player.PlayerComparator);
	    	for(int i = 0;i<Main.theManager.getTheUser().getCurrentGame().getNumberOfPlayers();i++) {
	    		if(i==0) {
	    			winner_txt.setText(Main.theManager.getTheUser().getCurrentGame().getPlayers().get(i).toString());
	    		} else {
	    		results += Main.theManager.getTheUser().getCurrentGame().getPlayers().get(i).toString() + System.lineSeparator();
	    		}
	    	}
	    	this.otherPlayers_txt.setText(results);
	    }
	    

	}
