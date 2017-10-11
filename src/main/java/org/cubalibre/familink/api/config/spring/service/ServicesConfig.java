package org.cubalibre.familink.api.config.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Classe de type Spring JAVA Config permetant de scanner les packages pour charger :
 * - les Services ( @Service )
 * - les fichiers properties necessaires a la configuration de l'application
 * @author avl
 */

@Configuration
@ComponentScan(basePackages = {"org.cubalibre.familink.api.services"})
@PropertySource(value = {"classpath:application.properties"})
public class ServicesConfig {

	private static final Logger LOG = LoggerFactory.getLogger(ServicesConfig.class.getName());
	
    
	/**
	 * Bean needed to resolve ${property.name} syntax
	 */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    	LOG.info("propertyConfigInDev() .....");
    	
        return new PropertySourcesPlaceholderConfigurer();
    }
}