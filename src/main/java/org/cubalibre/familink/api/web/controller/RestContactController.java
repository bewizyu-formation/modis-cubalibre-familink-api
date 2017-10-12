package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.entite.Profil;
import org.cubalibre.familink.api.services.IContactService;
import org.cubalibre.familink.api.services.impl.ProfilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class RestContactController {

    private static final Logger LOG = LoggerFactory.getLogger(RestContactController.class.getName());

    @Autowired
    @Qualifier("contactService")
    private IContactService contactService;

    @Autowired
    @Qualifier("profilService")
    private ProfilService profilService;

    // ********** CREATE CONTACT ********** //
    @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public Contact createContact(@RequestBody Contact newContact) {

        Profil profilNewContact = profilService.getProfilById(newContact.getProfil().getId());
        if (profilNewContact != null) {
            newContact.setProfil(profilNewContact);
        }

        return contactService.create(newContact);
    }

    // ******* GET CONTACT BY ID ********** //
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Contact getContactById(@PathVariable("id") int id) {

        return contactService.getContactById(id);
    }

    // ******* DELETE CONTACT BY ID ******** //
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteContact(@PathVariable("id") int id) {

        contactService.deleteContact(id);
    }

}
