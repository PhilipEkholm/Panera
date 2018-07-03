package filters;

import java.awt.image.BufferedImage;

import common.ImageUtilities;
import common.MathUtilities;

public class GreyScale {
	public static BufferedImage apply(BufferedImage image) {
        BufferedImage newImage = ImageUtilities.copyImage(image);
        int pixelValue,
        	a,
        	r,
        	g,
        	b,
        	avg;

        for (int y = 0; y < image.getHeight(); ++y) {
        	for (int x = 0; x < image.getWidth(); ++x) {
        		pixelValue = newImage.getRGB(x, y);
        		
        		a = (pixelValue >> 24) & 0xff;
        		r = (pixelValue >> 16) & 0xff;
        		g = (pixelValue >> 8) & 0xff;
        		b = pixelValue & 0xff;
        		
        		avg = MathUtilities.mean(new int[] {r, g, b});
        		
        		pixelValue = (a << 24) | (avg << 16) | (avg << 8) | avg;
        		newImage.setRGB(x, y, pixelValue);
        	}
        }
		
		return newImage;
	}
}
