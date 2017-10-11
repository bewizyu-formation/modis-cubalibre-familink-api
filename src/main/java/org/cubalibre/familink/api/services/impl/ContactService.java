package org.cubalibre.familink.api.services.impl;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.entite.Profil;
import org.cubalibre.familink.api.repository.ContactRepository;
import org.cubalibre.familink.api.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "contactService")
public class ContactService implements IContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ProfilService profilService;

    @Override
    public Contact create(Contact newContact) {

        Profil contactProfil = profilService.getProfilById(newContact.getProfil().getId());
        newContact.setProfil(contactProfil);

        return contactRepository.save(newContact);
    }
}
