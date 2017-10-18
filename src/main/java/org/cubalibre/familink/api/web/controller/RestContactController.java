package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.entite.Profil;
import org.cubalibre.familink.api.services.IContactService;
import org.cubalibre.familink.api.services.impl.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class RestContactController {

    @Autowired
    @Qualifier("contactService")
    private IContactService contactService;

    @Autowired
    @Qualifier("contactServiceJpa")
    private IContactService contactServiceJpa;

    @Autowired
    @Qualifier("profilService")
    private ProfilService profilService;

    // ********** CREATE CONTACT ********** //
    @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public Contact createContact(@RequestBody Contact newContact) {

        Profil existingProfil = profilService.getProfilById(newContact.getProfil().getId());
        if (existingProfil != null) {
            newContact.setProfil(existingProfil);
        }

        return contactService.create(newContact);
    }

    // ******* GET CONTACT BY ID ********** //
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Contact getContactById(@PathVariable("id") int id, @RequestHeader(value = "Authorization") String token) {

        return contactService.getContactById(id);
    }

    // ******* UPDATE CONTACT BY ID ******** //
    @RequestMapping(path = "/", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public void updateContact(@RequestBody Contact contactToUpdate, @RequestHeader(value = "Authorization") String token) {
        final Profil existingProfil = profilService.getProfilById(contactToUpdate.getProfil().getId());
        if (existingProfil != null) {
            contactToUpdate.setProfil(existingProfil);
        }

        contactService.update(contactToUpdate);
    }

    // ******* DELETE CONTACT BY ID ******** //
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteContact(@PathVariable("id") int id, @RequestHeader(value = "Authorization") String token) {

        contactService.delete(id);
    }
}
