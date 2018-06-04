package pixelmap.canvas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pixelmap.CanvasProperties;

@Component
public class CanvasManager {

	private static final Logger LOG = LoggerFactory.getLogger(CanvasManager.class);

	private static final String NAME = "canvas";
	private static final String SUFFIX = ".png";

	private Canvas canvas;

	@Autowired
	private CanvasProperties canvasProperties;

	public CanvasManager() {
	}

	@PostConstruct
	public void init() {
		Integer w = canvasProperties.getWidth();
		Integer h = canvasProperties.getHeight();
		canvas = new Canvas(w, h);
		LOG.info("created new {} x {} canvas", w, h);

		try {
			restore();
		} catch (CanvasManagerException e) {
			throw new RuntimeException("Crash and give up!", e);
		}
	}

	public void restore() throws CanvasManagerException {
		File directory = canvasProperties.getCanvasDirectory().getAbsoluteFile();
		LOG.info("restoring old image from {}", directory.getAbsolutePath());

		File file = new File(directory, NAME + SUFFIX);

		if (file.exists()) {
			restoreFromFile(file);
			return;
		}

		saveCurrent(file);
	}

	private void saveCurrent(File file) throws CanvasManagerException {
		LOG.info("saving current image to {}", file);

		try (OutputStream os = new FileOutputStream(file)) {
			ImageIO.write(canvas.getImage(), "png", file);
		} catch (IOException e) {
			throw new CanvasManagerException("Saving image to " + file.getAbsolutePath() + " failed!", e);
		}
	}

	private void restoreFromFile(File file) throws CanvasManagerException {
		LOG.info("loading current image from {}", file);
		try (InputStream is = new FileInputStream(file)) {
			BufferedImage image = ImageIO.read(file);
			canvas.replaceAtOrigin(image);
		} catch (IOException e) {
			throw new CanvasManagerException("Loading image from " + file.getAbsolutePath() + " failed!", e);
		}
	}
}
