package org.cubalibre.familink.api.services;

import org.cubalibre.familink.api.entite.Contact;

public interface IContactService {
    /**
     * Creer un nouveau Contact
     *
     * @param newContact nouveau Contact
     */
    Contact create(Contact newContact);

    Contact getContactById(int id);
}
