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

    /**
     * Récupération d'un Contact par son id
     *
     * @param id
     * @return
     */
    Contact getContactById(int id);

    /**
     * Mise à jour d'un Contact
     *
     * @param contact
     */
    void update(Contact contact);

    /**
     * Suppression d'un Contact by id
     *
     * @param id
     */
    void deleteContact(final int id);


}
