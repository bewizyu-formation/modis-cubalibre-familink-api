package org.cubalibre.familink.api.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
        // Initialisation du contexte Spring
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebAppConfig.class);

		/*
		 * <servlet> <servlet-name>dispatcher</servlet-name>
		 * <servlet-class>org.springframework.web.servlet.DispatcherServlet</
		 * servlet-class> <load-on-startup>1</load-on-startup> </servlet>
		 */
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));

		dispatcher.setLoadOnStartup(1);

		/*
         * <servlet-mapping> <servlet-name>dispatcher</servlet-name>
		 * <url-pattern>/mvc/*</url-pattern> </servlet-mapping>
		 */
        dispatcher.addMapping("/mvc/*");

		/*
		 * <listener>
		 * 
		 * <listener-
		 * class>org.springframework.web.context.ContextLoaderListener</listener
		 * -class>
		 * 
		 * </listener>
		 */
		servletContext.addListener(new ContextLoaderListener(webContext));
	}
}
