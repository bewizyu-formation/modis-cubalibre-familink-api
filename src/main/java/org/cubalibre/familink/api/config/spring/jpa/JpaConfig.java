package org.cubalibre.familink.api.config.spring.jpa;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Classe de type Spring JAVA Config permetant de :
 * - activer la gestion des transations ( @EnableTransactionManagement )
 * - obtenir une instance de JpaTransactionManager
 * - obtenir une instance d’EntityManagerFactory
 *
 * @author avl
 */

@Configuration
@EnableTransactionManagement
//@ComponentScan(basePackages = { "org.cubalibre.familink.api.entities" })
public class JpaConfig {

	private static final Logger LOG = LoggerFactory.getLogger(JpaConfig.class.getName());
	
	/**
	 * Cette configuration nécessite un Transaction Manager pour la gestion des transactions locales.
	 * 
	 * L'implementation JpaTransactionManager met en place un nouveau Transaction Manager
	 * car Spring n’implémente pas de Transaction Manager, mais delegue des appels aux gestionnaire de transactions.
	 */
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		LOG.info("transactionManager() .....");
		
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}

	/**
	 * Cette configuration nécessite une source de données configurée.
	 * Elle s'utilise donc en association avec un autre fichier de configuration (MySQLDataSourceConfig) définissant un bean DataSource.
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		LOG.info("entityManagerFactory() .....");
		
		// Classe qui génère les tables SQL à partir des entités détectées
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		
		// Activer les logs SQL
		vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		
		// Indique les packages ou se trouve les Entities
		factory.setPackagesToScan("org.cubalibre.familink.api.entites");
		factory.setDataSource(dataSource);

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");
		factory.setJpaProperties(jpaProperties);

		factory.afterPropertiesSet();
		return factory.getObject();
	}
}