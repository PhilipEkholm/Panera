package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class UILoader {
	public static Parent loadMainWindow() {
		final String mainWindowFilename = "main-window.fxml";
		
		try {
			return (FXMLLoader.load(UILoader.class.getResource(mainWindowFilename)));
		}
		catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("Could not load the resource: " + mainWindowFilename);
		}

		return null;
	}
}
