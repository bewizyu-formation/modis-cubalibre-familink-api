package org.cubalibre.familink.api.repository;

import org.cubalibre.familink.api.entite.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe de type Repository (Spring Data)
 *
 * @author avl
 */
public interface GroupRepository extends JpaRepository<Group, Integer> {

	
}
