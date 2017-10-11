package org.cubalibre.familink.api.repositories;

import org.cubalibre.familink.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Classe de type Repository (Spring Data)
 *
 * @author avl
 */
@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	
}
