package controllers;

import java.awt.image.BufferedImage;

import filters.Filter;
import filters.GreyScale;

public class ImageController {
	private final MainController mainController;
	private BufferedImage updatedImage;

	public ImageController(MainController controller) {
		mainController = controller;
	}
	
	public void applyFilter(Filter f) {
		switch(f) {
			case GREYSCALE:
				updatedImage = GreyScale.apply(mainController.getImage());
			break;
		}
		
		mainController.setImage(updatedImage);
	}
}
