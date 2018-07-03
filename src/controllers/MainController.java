package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import views.MainView;

public class MainController{
	private MainView mainWindow;
	private BufferedImage currentImage;
	
	public MainController(Stage primaryStage) {
		mainWindow = new MainView(primaryStage, this);
	}
	
	public void loadImage() {
		File inputFile;
		
		FileChooser imageChooser = new FileChooser();
		imageChooser.setTitle("Open the image you want to edit");
		inputFile = imageChooser.showOpenDialog(mainWindow.getPrimaryStage());
		
		System.out.println(inputFile.getAbsolutePath());
		
		try {
			this.currentImage = ImageIO.read(inputFile);
		}
		catch(IOException e1){
			e1.printStackTrace();
		}
		catch(IllegalArgumentException e2) {
			e2.printStackTrace();
		}
		
		refreshViewedImage();
	}
	
	private void refreshViewedImage() {
		mainWindow.setViewedImage(currentImage);
	}
}









