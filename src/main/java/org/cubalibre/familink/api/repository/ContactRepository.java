package org.cubalibre.familink.api.repository;

import org.cubalibre.familink.api.entite.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
