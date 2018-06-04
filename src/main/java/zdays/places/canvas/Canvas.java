package zdays.places.canvas;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Canvas {

	private static final Logger LOG = LoggerFactory.getLogger(Canvas.class);

	private final BufferedImage image;

	private final Graphics2D g2d;

	public Canvas(Integer w, Integer h) {
		image = new BufferedImage(w.intValue(), h.intValue(), BufferedImage.TYPE_INT_RGB);
		g2d = image.createGraphics();
	}

	public RenderedImage getImage() {
		return image;
	}

	public void replaceAtOrigin(BufferedImage newImage) {
		LOG.info("replacing canvas content at 0,0 with new content from {} x {} image", //
				newImage.getWidth(), newImage.getHeight());

		dumbCopy(newImage, image);
	}

	/**
	 * really dumb pixel-by-pixel copy. Optimizing later...
	 * 
	 * @param newImage
	 * @param image
	 */
	private void dumbCopy(BufferedImage sourceImage, BufferedImage targetImage) {
		int width = sourceImage.getWidth();
		int height = sourceImage.getHeight();

		LOG.info("Source image is {} x {}", width, height);
		height = Math.min(height, targetImage.getHeight());
		width = Math.min(width, targetImage.getWidth());

		LOG.info("Copy size is {} x {}", width, height);

		// int[] buffer = new int[(width * height) + 1];
		//
		// WritableRaster sourceRaster = sourceImage.getRaster();
		// int[] pixels = sourceRaster.getPixels(0, 0, width, height, buffer);
		//
		// WritableRaster targetRaster = image.getRaster();
		// targetRaster.setPixels(0, 0, width, height, pixels);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int rgb = sourceImage.getRGB(x, y);
				targetImage.setRGB(x, y, rgb);
			}
		}
	}

}
