package common;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class ImageUtilities {
	public static BufferedImage copyImage(BufferedImage image) {
		ColorModel cm = image.getColorModel();
		boolean isAlphaPremultiplied = image.isAlphaPremultiplied();
		WritableRaster wr = image.copyData(null);
		
		return new BufferedImage(cm, wr, isAlphaPremultiplied, null);
	}
}
