package org.cubalibre.familink.api.config.spring.jdbc;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Classe de type Spring JAVA Config permetant d’obtenir une instance de DataSource, qui pointe vers la BDD MySQL "familink"
 *
 * @author avl
 */

@Configuration
public class MySQLDataSourceConfig {

	private static final Logger LOG = LoggerFactory.getLogger(MySQLDataSourceConfig.class.getName());
	
	@Value("${spring.datasource.driver-class-name}")
	private String driver;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	/**
	 * Création de la DataSource qui pointe vers la BDD MySQL "familink"
	 *
	 * @return {@link DataSource}
	 */

	@Bean
	public DataSource datasource() {
		LOG.info("dataSource() .....");
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
}
