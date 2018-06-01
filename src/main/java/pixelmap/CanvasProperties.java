package pixelmap;

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
	
	@Value( "${canvas.width:128}")
	private Integer canvasWidth;

	@Value( "${canvas.height:128}")
	private Integer canvasHeight;

	@Value( "${request.cooldown:180}")
	private Integer requestCooldown;

}
