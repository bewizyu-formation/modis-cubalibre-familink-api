package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.services.IContactService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class RestContactsController {

    @Autowired
    @Qualifier("contactServiceJpa")
    private IContactService contactServiceJpa;

    // ********** GET CONTACTS ********** //
    @RequestMapping(path = "/{groupId}", method = RequestMethod.GET, consumes = "application/json;charset=UTF-8", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getContacts(@PathVariable("groupId") int groupId, @RequestHeader(value = "Authorization") String token) {
        JSONObject jsonContacts = new JSONObject();
        JSONArray jsonContactsArray = new JSONArray();
        JSONObject jsonContact = new JSONObject();

        List<Contact> contacts = contactServiceJpa.getContactsByGroup(groupId);
        for (int i = 0; i < contacts.size(); i++) {
            jsonContact.put("id", contacts.get(i).getId());
            jsonContact.put("lastname", contacts.get(i).getLastName());
            jsonContact.put("firstname", contacts.get(i).getFirstName());
            jsonContact.put("phone", contacts.get(i).getPhone());

            JSONObject jsonProfil = new JSONObject();
            jsonProfil.put("id", contacts.get(i).getProfil().getId());
            jsonContact.put("profil", jsonProfil);

            jsonContact.put("address", contacts.get(i).getAddress());
            jsonContact.put("zipcode", contacts.get(i).getZipcode());
            jsonContact.put("city", contacts.get(i).getCity());
            jsonContact.put("gravatar", contacts.get(i).getGravatar());

            jsonContactsArray.put(jsonContact);
        }
        jsonContacts.put("contacts", jsonContactsArray);


        return jsonContacts.toString();
    }

}
