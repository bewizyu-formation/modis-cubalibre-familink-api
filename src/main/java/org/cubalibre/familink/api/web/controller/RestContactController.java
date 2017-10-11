package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.services.IContactService;
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

    // ********** CREATE CONTACT ********** //
    @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public Contact createContact(@RequestBody Contact newContact) {

        return contactService.create(newContact);
    }

    // ******* GET CONTACT BY ID ********** //
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Contact getContactById(@PathVariable("id") String id) {
        return contactService.getContactById(Integer.parseInt(id));
    }

    // ******* UPDATE CONTACT  ******** //
    @RequestMapping(path = "/", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public void updateContact(@RequestBody Contact updateContact) {

        contactService.update(updateContact);
    }
}
