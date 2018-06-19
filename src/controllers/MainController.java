package controllers;

import javafx.stage.Stage;
import views.MainView;

public class MainController{
	private MainView mainWindow;
	
	public MainController(Stage primaryStage) {
		mainWindow = new MainView(primaryStage);
	}
}
