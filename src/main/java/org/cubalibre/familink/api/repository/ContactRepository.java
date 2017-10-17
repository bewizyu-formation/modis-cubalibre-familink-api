package org.cubalibre.familink.api.repository;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.entite.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query(value = "SELECT groupe.* FROM groupe JOIN group_contact gc ON groupe.id_group = gc.group_id WHERE contact_id = ?1" , nativeQuery = true)
    //@Query("SELECT groupe FROM Group JOIN group_contact gc ON groupe.id_group = gc.group_id WHERE contact_id = :idContact")
    List<Group> findGroups(@Param("idContact") int idContact);

//
//    @Query(value = " SELECT * FROM groupe\n" +
//            "    INNER JOIN group_contact ON groupe.id_group = group_contact.group_id\n" +
//            "    INNER JOIN user on group_contact.contact_id = user.contact_id where user.id_user = :idContact" , nativeQuery = true)
//    List<Group> findGroups(int idContact);
}
