package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.services.IContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class RestContactsController {

    private static final Logger LOG = LoggerFactory.getLogger(RestContactsController.class.getName());

    @Autowired
    @Qualifier("contactService")
    private IContactService contactService;


    // ********** GET CONTACTS ********** //
    @RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Contact> getContacts() {

        return contactService.getContacts();
    }

}
