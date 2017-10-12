package org.cubalibre.familink.api.services.impl;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.entite.Profil;
import org.cubalibre.familink.api.repository.ContactRepository;
import org.cubalibre.familink.api.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "contactService")
public class ContactService implements IContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ProfilService profilService;

    @Override
    public List<Contact> getContacts() {

        return contactRepository.findAll();
    }

    @Override
    public Contact create(Contact newContact) {

        Profil profilNewContact = profilService.getProfilById(newContact.getProfil().getId());
        if (profilNewContact != null) {
            newContact.setProfil(profilNewContact);
        }
        return contactRepository.save(newContact);
    }

    @Override
    public Contact getContactById(int id) {

        return contactRepository.findOne(id);
    }

    @Override
    public void update(Contact toUpdate) {

        final Contact contactToUpdate = contactRepository.findOne(toUpdate.getId());

        if (contactToUpdate != null) {
            contactToUpdate.setLastName(toUpdate.getLastName());
            contactToUpdate.setFirstName(toUpdate.getFirstName());
            contactToUpdate.setPhone(toUpdate.getPhone());
            if (toUpdate.getProfil() != null) {
                final Profil profilToUpdate = profilService.getProfilById(toUpdate.getProfil().getId());
                if (profilToUpdate != null) {
                    contactToUpdate.setProfil(profilToUpdate);
                }
            }
            contactToUpdate.setAddress(toUpdate.getAddress());
            contactToUpdate.setZipcode(toUpdate.getZipcode());
            contactToUpdate.setCity(toUpdate.getCity());
            contactToUpdate.setGravatar(toUpdate.getGravatar());

            contactRepository.save(toUpdate);
        }
    }

    @Override
    public void deleteContact(int id) {

        contactRepository.delete(id);
    }

}
