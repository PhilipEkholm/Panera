package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {
	private VBox root;
	private MenuBar menuBar;

	public MainView(Stage primaryStage) {
		root = new VBox();
		menuBar = new MenuBar();
		Scene primaryScene = new Scene(root, 600, 400);
		
		primaryStage.setTitle("Panera");
		
		primaryStage.setScene(primaryScene);
		
		primaryStage.show();

		root.getChildren().add(menuBar);
		createMenu();
	}
	
	private void createMenu() {
		final Menu file 	= new Menu("File");
		final Menu filters 	= new Menu("Filters");
		final Menu help     = new Menu("Help");
		
		final MenuItem open    = new MenuItem("Open...");
		final MenuItem close   = new MenuItem("Close");
		final MenuItem save    = new MenuItem("Save");
		final MenuItem saveAs  = new MenuItem("Save As...");
		
		final MenuItem aboutPanera = new MenuItem("About Panera...");
		
		aboutPanera.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent e) {
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("About Panera...");
				a.setHeaderText("Panera v0.1");

				a.setContentText("Written by Philip Ekholm, Copyright");
				a.showAndWait();
			}
		});
		
		file.getItems().addAll(
			open,
			new SeparatorMenuItem(),
			close,
			save,
			saveAs
		);
		
		help.getItems().addAll(
			aboutPanera
		);
		
		menuBar.getMenus().addAll(
			file,
			filters,
			help
		);
	}
}
