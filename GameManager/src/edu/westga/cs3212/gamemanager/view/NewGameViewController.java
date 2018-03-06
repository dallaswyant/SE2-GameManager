package edu.westga.cs3212.gamemanager.view;

import java.io.IOException;

import edu.westga.cs3212.gamemanager.Main;
import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

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
    private Slider pointIncrement_slider;
    
    @FXML
    private TableView<Player> playerTable;
    @FXML
    private TableColumn<Player, String> playerNames;
    @FXML
    private TableColumn<Player, Integer> playerScores;

    @FXML
    void cancel_clicked(ActionEvent event) throws IOException {
    	Main.theManager.getPlayersInCurrentGame().clear();
    	Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource(Main.GAME_LIST_VIEW));
    	loader.load();
    	Scene gameView = new Scene(loader.getRoot());
    	currentStage.setScene(gameView);
    }

    @FXML
    void confirm_clicked(ActionEvent event) throws IOException {
    	try {
    		this.setUpNewGame();
    		Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(Main.class.getResource(Main.GAME_VIEW));
        	loader.load();
        	Scene gameView = new Scene(loader.getRoot());
        	currentStage.setScene(gameView);
    	} catch(IllegalArgumentException iae) {
    		Alert theAlert = new Alert(AlertType.ERROR,"Please enter a valid name for the game.");
    		theAlert.show();
    	}
    }

	private void setUpNewGame() {
		try {
			Game newGame = new Game(gameName.getText(),(int)this.pointIncrement_slider.getValue());
			for(int i = 0; i<this.playerTable.getItems().size();i++) {
				Player newPlayer = new Player(this.playerNames.getCellData(i),this.playerScores.getCellData(i));
				newGame.addPlayer(newPlayer);
			}
	    	Main.theManager.getTheUser().setCurrentGame(newGame);

		} catch(IllegalArgumentException iae) {
			throw iae;
		}
    	
	}

    @FXML
    void initialize() {
    	
    	this.buttons = new ToggleGroup();
    	this.radio1.setToggleGroup(this.buttons);
    	this.radio1.setUserData(1);
    	this.radio1.setSelected(true);
    	this.radio2.setToggleGroup(this.buttons);
    	this.radio2.setUserData(2);
    	this.radio3.setToggleGroup(this.buttons);
    	this.radio3.setUserData(3);
    	this.radio4.setToggleGroup(this.buttons);
    	this.radio4.setUserData(4);
    	this.radio5.setToggleGroup(this.buttons);
    	this.radio5.setUserData(5);
    	this.radio6.setToggleGroup(this.buttons);
    	this.radio6.setUserData(6);
    	this.radio7.setToggleGroup(this.buttons);
    	this.radio7.setUserData(7);
    	this.radio8.setToggleGroup(this.buttons);
    	this.radio8.setUserData(8);
    	Main.theManager.addPlayersToCurrentGame(new Player("Player 1", 0));

    	this.playerNames.setCellValueFactory(new PropertyValueFactory<Player,String>("playerName"));
    	this.playerScores.setCellValueFactory(new PropertyValueFactory<Player,Integer>("playerScore"));

    	this.playerNames.setCellFactory(TextFieldTableCell.forTableColumn());
    	this.playerScores.setCellFactory(createPlayerScoreCellFactory());
    	this.playerTable.setItems(Main.theManager.getPlayersInCurrentGame());
    	this.playerNames.setOnEditCommit(
                new EventHandler<CellEditEvent<Player, String>>() {
                    @Override
                    public void handle(CellEditEvent<Player, String> t) {
                        ((Player) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                                ).setPlayerName(t.getNewValue());
                    }
                }
            );
    	this.playerScores.setOnEditCommit(
                new EventHandler<CellEditEvent<Player, Integer>>() {
                    @Override
                    public void handle(CellEditEvent<Player, Integer> t) {
                        ((Player) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                                ).setPlayerScore(t.getNewValue());
                    }
                }
            );
    	this.playerTable.getSelectionModel().setCellSelectionEnabled(true);

    	this.buttons.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                Toggle toggle, Toggle new_toggle) {
                    if (new_toggle != null) {
                    	Main.theManager.clearPlayersInCurrentGame();
                    	NewGameViewController.this.playerTable.setItems(Main.theManager.getPlayersInCurrentGame());
                    	int number = (int) NewGameViewController.this.buttons.getSelectedToggle().getUserData();
                    	
                    	for(int i = 1; i<=number;i++) {
                    		Main.theManager.addPlayersToCurrentGame(new Player("Player "+i,0));
                    	}
                    	
                    	NewGameViewController.this.playerTable.setItems(Main.theManager.getPlayersInCurrentGame());	
                    }
                       
            }
        });
    }
    
    private Callback<TableColumn<Player, Integer>, TableCell<Player, Integer>>  createPlayerScoreCellFactory() {

        Callback<TableColumn<Player, Integer>, TableCell<Player, Integer>> factory = TextFieldTableCell.forTableColumn( new StringConverter<Integer>() {

            @Override
            public Integer fromString(String string) {
            	try {
					return Integer.parseInt(string.toString());
				} catch (Exception e){
					Alert invalidNumberAlert = new Alert(AlertType.ERROR,"Please input a valid integer.");
					invalidNumberAlert.show();
					return 0;
				}
            }


			@Override
			public String toString(Integer object) {
				try {
					int newValue = Integer.parseInt(object.toString());
					return Integer.toString(newValue);
				} catch (Exception e){
					Alert invalidNumberAlert = new Alert(AlertType.ERROR,"Please input a valid integer.");
					invalidNumberAlert.show();
					return "";
				}

			}
        });

        return factory;
    }


}
