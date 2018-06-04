package pixelmap.canvas;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;

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
		int height = sourceImage.getHeight();
		int width = sourceImage.getWidth();

		height = Math.min(height, targetImage.getHeight());
		width = Math.min(width, targetImage.getWidth());

		int[] buffer = new int[width * height];

		WritableRaster sourceRaster = sourceImage.getRaster();
		int[] pixels = sourceRaster.getPixels(0, 0, width, height, buffer);

		WritableRaster targetRaster = image.getRaster();
		targetRaster.setPixels(0, 0, width, height, pixels);

	}

}
