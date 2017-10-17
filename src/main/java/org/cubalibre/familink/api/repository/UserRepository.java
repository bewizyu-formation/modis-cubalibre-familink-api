package org.cubalibre.familink.api.repository;

import org.cubalibre.familink.api.entite.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe de type Repository (Spring Data)
 *
 * @author avl
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByMailAndPassword(String mail, String password);
}
