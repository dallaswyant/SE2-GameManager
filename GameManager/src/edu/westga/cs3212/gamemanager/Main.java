package edu.westga.cs3212.gamemanager;
	
import java.net.URL;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.User;
import edu.westga.cs3212.gamemanager.view_model.GameManagerViewModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	public static final String GAME_LIST_VIEW = "view/GameListView.fxml";
	public static final String LANDING_VIEW = "view/LandingView.fxml";
	public static final String NEW_GAME_VIEW = "view/NewGameView.fxml";
	public static final String GAME_VIEW = "view/GameView.fxml";
	public static GameManagerViewModel theManager = new GameManagerViewModel();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			URL theUrl = getClass().getResource(LANDING_VIEW);
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
