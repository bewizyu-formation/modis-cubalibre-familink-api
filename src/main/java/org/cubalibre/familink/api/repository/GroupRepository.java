package org.cubalibre.familink.api.repository;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.entite.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Classe de type Repository (Spring Data)
 *
 * @author avl
 */
public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query(value = "SELECT contact.* FROM contact JOIN group_contact gc ON contact.id_contact = gc.contact_id WHERE group_id = ?1" , nativeQuery = true)
    List<Contact> findContacts(int idGroup);
	
}
