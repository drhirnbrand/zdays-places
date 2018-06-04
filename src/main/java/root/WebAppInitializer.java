package root;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import pixelmap.CanvasConfig;

/**
 * 
 * @author brin
 *
 */
public class WebAppInitializer implements WebApplicationInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(WebAppInitializer.class);

	private AnnotationConfigWebApplicationContext getContext(Class<?> configuration) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(configuration);
		return context;
	}

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		LOG.info("onStartup(); Initializing servlet context");

		WebApplicationContext context = getContext(RootConfig.class);

		container.addListener(new ContextLoaderListener(context));
		container.setInitParameter("defaultHtmlEscape", "true");

		AnnotationConfigWebApplicationContext servletContext = getContext(CanvasConfig.class);

		servletContext.setParent(context);
		servletContext.register(CanvasConfig.class);
		// container.addListener(new ContextLoaderListener(servletContext));

		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher",
				new DispatcherServlet(servletContext));

		dispatcher.setLoadOnStartup(1);
		Set<String> mappingConflicts = dispatcher.addMapping("/");

		if (!mappingConflicts.isEmpty()) {
			for (String s : mappingConflicts) {
				LOG.error("Mapping conflict: " + s);
			}
			throw new IllegalStateException("'appServlet' cannot be mapped to '/' under Tomcat versions <= 7.0.14");
		}

		// FilterRegistration.Dynamic fr =
		// servletContext.addFilter("encodingFilter", new
		// CharacterEncodingFilter());
		// fr.setInitParameter("encoding", "UTF-8");
		// fr.setInitParameter("forceEncoding", "true");
		// fr.addMappingForUrlPatterns(null, true, "/*");

	}

}
