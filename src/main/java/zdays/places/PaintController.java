package zdays.places;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zdays.places.canvas.CanvasProperties;

@RestController
public class PaintController {

	private static final Logger LOG = LoggerFactory.getLogger(PaintController.class);
	@Autowired
	private CanvasProperties properties;

	@RequestMapping("/paint")
	public String paint(@RequestParam(name = "x", required = true) String x,
			@RequestParam(name = "y", required = true) String y, @RequestParam(name = "r", required = true) Integer r,
			@RequestParam(name = "g", required = true) Integer g,
			@RequestParam(name = "b", required = true) Integer b) {
		String result = MessageFormat.format("Paint [{0},{1}] with Color RGB {2},{3},{4}", x, y, r, g, b);
		LOG.info(result);
		return result;
	}
}
