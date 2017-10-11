package org.cubalibre.familink.api.config.spring.data;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Classe de type Spring JAVA Config pour :
 * - activer Spring Data JPA ( @EnableJpaRepositories )
 * - indiquer les packages ou se trouvent les interfaces ( @Repository ) a charger pour Spring Data JPA 
 *
 * @author avl
 */

@Configuration
//@EnableJpaRepositories("org.cubalibre.familink.api.repositories")
public class DataJpaConfig {

}
