package views;

import java.awt.image.BufferedImage;
import java.util.Calendar;

import controllers.ImageController;
import controllers.MainController;
import filters.Filter;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {
	private final VBox root;
	private final Stage primaryStage;
	private final MenuBar menuBar;
	private final MainController mainController;
	private final ImageController imageController;
	private final Calendar cal = Calendar.getInstance();
	private final ImageView imageView = new ImageView();
	private Image shownImage = new Image("file:ui-images/default.jpg");
	
	private final Menu file 	= new Menu("File");
	private final Menu filters 	= new Menu("Filters");
	private final Menu help     = new Menu("Help");
	
	private final MenuItem open    = new MenuItem("Open...");
	
	private final MenuItem close   = new MenuItem("Close");
	private final MenuItem save    = new MenuItem("Save");
	private final MenuItem saveAs  = new MenuItem("Save As...");
	
	private final MenuItem greyScale = new MenuItem("Grey Scale");
	
	private final MenuItem aboutPanera = new MenuItem("About Panera...");

	public MainView(Stage primaryStage, MainController controller, ImageController ic) {
		this.primaryStage = primaryStage;
		mainController = controller;
		imageController = ic;

		root = new VBox();
		menuBar = new MenuBar();
		Scene primaryScene = new Scene(root, 600, 400);

		this.primaryStage.setTitle("Panera");
		this.primaryStage.getIcons().add(new Image("file:ui-images/panera.png"));
		this.primaryStage.setScene(primaryScene);
		
		this.primaryStage.show();
		
		imageView.setImage(shownImage);
		imageView.setFitWidth(primaryScene.getWidth());
		imageView.fitWidthProperty().bind(primaryScene.widthProperty());
		imageView.fitHeightProperty().bind(primaryScene.heightProperty());
		imageView.setPreserveRatio(true);

		root.getChildren().add(menuBar);
		root.getChildren().add(imageView);
		structureMenu();
		setEventHandlers();
	}
	
	private void structureMenu() {
		file.getItems().addAll(
			open,
			new SeparatorMenuItem(),
			close,
			save,
			saveAs
		);
		
		filters.getItems().add(greyScale);
		
		help.getItems().addAll(
			aboutPanera
		);
		
		menuBar.getMenus().addAll(
			file,
			filters,
			help
		);
	}
	
	private void setEventHandlers() {
		aboutPanera.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent e) {
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("About Panera...");
				a.setHeaderText("Panera version 0.1");

				a.setContentText("Written by Philip Ekholm, Copyright " + cal.get(Calendar.YEAR));
				a.showAndWait();
			}
		});
		
		open.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent event) {
				mainController.openImage();
			}
		});
		
		saveAs.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent event) {
				mainController.saveImageAs();
			}
		});
		
		filters.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				imageController.applyFilter(Filter.GREYSCALE);
			}
		});
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public void setViewedImage(BufferedImage img) {
		imageView.setImage(SwingFXUtils.toFXImage(img, null));
	}
}






