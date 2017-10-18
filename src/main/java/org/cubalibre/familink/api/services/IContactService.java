package org.cubalibre.familink.api.services;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.entite.Group;

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
    void delete (int id);


    /**
     * Lister toutes les Contacts d'un USer
     *
     * @param groupId group Id
     */
    List<Contact> getContactsByGroup(int groupId);

    /**
     * Lister toutes les groups d'un Contact using User
     *
     * @param userId user Id
     */
    List<Group> getGroupsByUser(int userId);
}
