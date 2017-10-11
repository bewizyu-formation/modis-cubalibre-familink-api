package org.cubalibre.familink.api.config.spring.web;

import org.cubalibre.familink.api.config.spring.data.DataJpaConfig;
import org.cubalibre.familink.api.config.spring.jdbc.MySQLDataSourceConfig;
import org.cubalibre.familink.api.config.spring.jpa.JpaConfig;
import org.cubalibre.familink.api.config.spring.service.ServicesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * Classe de type Spring JAVA Config permetant de :
 * - activer Spring MVC ( @EnableWebMvc )
 * - charger d'autre classes de config 
 * - scanner les packages pour charger les Contrôleurs REST ( @RestController )
 *
 * @author avl
 */

@CrossOrigin
@Configuration
@EnableWebMvc
@Import({ServicesConfig.class, JpaConfig.class, DataJpaConfig.class, MySQLDataSourceConfig.class})
@ComponentScan({"org.cubalibre.familink.api.spring.mvc.controller"})
public class WebAppConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(WebAppConfig.class.getName());

	/**
	 * Bean qui fourni le mécanisme de sélection des Views, selon un identifiant logique retourné par la méthode gestionnaire du controller.
	 */
	@Bean
	public ViewResolver viewResolver() {
		LOG.info("viewResolver() .....");
		
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		LOG.info("corsConfigurer() .....");
		
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
						.allowedHeaders("Content-Type");
			}
		};
	}	
}
