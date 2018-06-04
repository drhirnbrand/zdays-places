package zdays.places.canvas;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:canvas.properties")
public class CanvasProperties {

	@Autowired
	private Environment env;

	@Value("${canvas.width:128}")
	private Integer width;

	@Value("${canvas.height:128}")
	private Integer height;

	@Value("${request.cooldown:180}")
	private Integer cooldown;

	@Value("${canvas.directory:/var/tmp/places}")
	private File canvasDirectory;
	
	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getCooldown() {
		return cooldown;
	}

	public void setCooldown(Integer cooldown) {
		this.cooldown = cooldown;
	}

	public File getCanvasDirectory() {
		return canvasDirectory;
	}

	public void setCanvasDirectory(File canvasDirectory) {
		this.canvasDirectory = canvasDirectory;
	}

}
