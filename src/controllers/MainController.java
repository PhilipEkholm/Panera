package controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.UILoader;

public class MainController{
	public MainController(Stage primaryStage) {
		Parent root = UILoader.loadMainWindow();
		
		Scene primaryScene = new Scene(root, 600, 400);
		
		primaryStage.setTitle("Panera");
		primaryStage.setScene(primaryScene);
		primaryStage.show();
	}
}
