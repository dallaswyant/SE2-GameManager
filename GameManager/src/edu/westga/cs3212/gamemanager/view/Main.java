package edu.westga.cs3212.gamemanager.view;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	public static final String GAME_LIST_VIEW = "GameListView.fxml";
	public static final String LANDING_VIEW = "LandingView.fxml";
	public static final String NEW_GAME_VIEW = "NewGameView.fxml";
	public static final String GAME_VIEW = "GameView.fxml";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			URL theUrl = getClass().getResource("LandingView.fxml");
			AnchorPane thePane = FXMLLoader.load(theUrl);
			Scene scene = new Scene(thePane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
