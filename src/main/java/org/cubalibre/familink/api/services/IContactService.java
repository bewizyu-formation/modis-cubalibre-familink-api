package org.cubalibre.familink.api.services;

import org.cubalibre.familink.api.entite.Contact;

import java.util.List;

public interface IContactService {

    /**
     * Extrait tous les Contacts existants
     *
     * @return
     */
    List<Contact> getContacts();

    /**
     * Creer un nouveau Contact
     *
     * @param newContact nouveau Contact
     */
    Contact create(Contact newContact);


}
