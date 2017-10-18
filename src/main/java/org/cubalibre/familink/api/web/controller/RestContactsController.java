package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class RestContactsController {

    @Autowired
    @Qualifier("contactService")
    private IContactService contactService;


    // ********** GET CONTACTS ********** //
    @RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Contact> getContacts(@RequestHeader(value = "Authorization") String token) {

        return contactService.getContacts();
    }

}
