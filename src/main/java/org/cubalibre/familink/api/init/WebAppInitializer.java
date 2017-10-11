package org.cubalibre.familink.api.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.cubalibre.familink.api.config.spring.web.WebAppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Classe d'implementation de l'interface fournit par Spring MVC, permetant de:
 * - charger le context Spring ( Beans )
 * - charger le context de Servlet Spring
 *
 * @author avl
 */
public class WebAppInitializer implements WebApplicationInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(WebAppInitializer.class.getName());
	
	/**
	 * Exécutée au démarrage de l’application (Tomcat)
	 */	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		LOG.info("WebAppInitializer - Demarrage Serveur .....");

		// Chargement du context Spring avec des Beans, a partir d'une Configuration 
		// (Beans - @Component : @Controller / @Service / @Repository / @Configuration)
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebAppConfig.class);

		// Servlet Spring qui officie comme Front controller (SPRING MVC)
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);
		
		dispatcher.addMapping("/api/*");

		// Creation de contexte de Servlet (context general de Spring) ajouté par "listener" de type ServletContextListener”
		servletContext.addListener(new ContextLoaderListener(webContext));
	}
}
