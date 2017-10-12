package org.cubalibre.familink.api.services.impl;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.repository.ContactRepository;
import org.cubalibre.familink.api.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "contactService")
public class ContactService implements IContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getContacts() {

        return contactRepository.findAll();
    }

    @Override
    public Contact create(Contact newContact) {

        return contactRepository.save(newContact);
    }

    @Override
    public Contact getContactById(int id) {

        return contactRepository.findOne(id);
    }

}
