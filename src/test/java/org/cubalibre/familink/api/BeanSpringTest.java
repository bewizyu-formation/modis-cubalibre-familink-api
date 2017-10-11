package org.cubalibre.familink.api;
import javax.sql.DataSource;

import org.cubalibre.familink.api.config.spring.data.DataJpaConfig;
import org.cubalibre.familink.api.config.spring.jdbc.MySQLDataSourceConfig;
import org.cubalibre.familink.api.config.spring.jpa.JpaConfig;
import org.cubalibre.familink.api.config.spring.service.ServicesConfig;
import org.cubalibre.familink.api.repositories.UserRepository;
import org.cubalibre.familink.api.services.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {ServicesConfig.class, JpaConfig.class, DataJpaConfig.class, MySQLDataSourceConfig.class})
@RunWith (SpringRunner.class)
public class BeanSpringTest {
	
	@Test
	public void creationBeanSpring() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		// Retrieve "dataSource" bean
		DataSource dataSource = context.getBean(DataSource.class);
		
		// Retrieve a service bean
		UserService userService = context.getBean(UserService.class);
		
		// Retrieve a repository bean
		UserRepository userRepository = context.getBean(UserRepository.class);
		
	//	assertNotNull(userService);
		
	}
}
