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
	private String imageName;
	
	public MainController(Stage primaryStage) {
		mainWindow = new MainView(primaryStage, this);
	}
	
	public void openImage() {
		File inputFile;
		
		FileChooser imageChooser = new FileChooser();
		imageChooser.setTitle("Open the image you want to edit");
		inputFile = imageChooser.showOpenDialog(mainWindow.getPrimaryStage());
		
		try {
			this.currentImage = ImageIO.read(inputFile);
		}
		catch(IOException e1){
			e1.printStackTrace();
		}
		catch(IllegalArgumentException e2) {
			e2.printStackTrace();
		}
		
		imageName = inputFile.getName();
		refreshViewedImage();
	}
	
	public void saveImageAs() {
		File outputFile;
		FileChooser imageSaver = new FileChooser();
		
		imageSaver.setTitle("Save the image to...");
		outputFile = imageSaver.showSaveDialog(mainWindow.getPrimaryStage());
		
		if (outputFile != null) {
			try {
				ImageIO.write(currentImage, MainController.getFileExtension(imageName), outputFile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private void refreshViewedImage() {
		mainWindow.setViewedImage(currentImage);
	}
	
	private static String getFileExtension(String fileName) {
		int dotPosition = fileName.lastIndexOf('.');
		
		/* Do not include the dot in the file extension and set to lowercase */
		return (fileName.substring(dotPosition + 1, fileName.length()).toLowerCase());
	}
}









