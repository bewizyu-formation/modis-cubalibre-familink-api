package org.cubalibre.familink.api.services.impl;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.entite.Group;
import org.cubalibre.familink.api.entite.Profil;
import org.cubalibre.familink.api.entite.User;
import org.cubalibre.familink.api.services.IContactService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service(value = "contactServiceJpa")
public class ContactServiceJpa implements IContactService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Contact> getContacts() {
        return null;
    }

    @Override
    public Contact create(Contact newContact) {
        return null;
    }

    @Override
    public Contact getContactById(int id) {
        return null;
    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Contact> getContactsByGroup(int groupId) {
        Query query = em.createNativeQuery("SELECT c.* from CONTACT c WHERE c.id_contact IN (SELECT contact_id FROM group_contact WHERE group_id = ?)").setParameter(1, groupId);

        List<Contact> contacts = getContacts(query);

        return contacts;
    }

    @Override
    public List<Group> getGroupsByUser(int userId) {
        Query queryWithUser = em.createNativeQuery("SELECT groupe.* FROM groupe\n" +
                "  INNER JOIN group_contact ON groupe.id_group = group_contact.group_id\n" +
                "  INNER JOIN user on group_contact.contact_id = user.contact_id where user.id_user = ?)").setParameter(1, userId);

        List<Group> groups = getGroups(queryWithUser);

        return groups;
    }


    private List<Group> getGroups(Query query) {
        List<Group> groups = new ArrayList<>();
        List<Object> objs = (List<Object>) query.getResultList();
        for (Object obj : objs) {
            Object[] o = (Object[]) obj;
            String groupId =  String.valueOf(o[0]);
            String ownerId =  String.valueOf(o[1]);
            String name =  String.valueOf(o[2]);
            String createDate =  String.valueOf(o[3]);

            User owner = new User(Integer.parseInt(ownerId));

            Group group = new Group(Integer.parseInt(groupId), owner, name, null);
            groups.add(group);
        }
        return groups;
    }

    private List<Contact> getContacts(Query query) {
        List<Contact> contacts = new ArrayList<>();
        List<Object> objs = (List<Object>) query.getResultList();

        for (Object obj : objs) {
            Object[] o = (Object[]) obj;
            String contactId =  String.valueOf(o[0]);
            String lastname =  String.valueOf(o[1]);
            String firstname =  String.valueOf(o[2]);
            String phone =  String.valueOf(o[3]);

            String profilId =  String.valueOf(o[4]);
            Profil profil = new Profil(Integer.parseInt(profilId));

            String address =  String.valueOf(o[5]);
            String zipcode =  String.valueOf(o[6]);
            String city =  String.valueOf(o[7]);
            String gravatar =  String.valueOf(o[8]);

            Contact contact = new Contact(Integer.parseInt(contactId), lastname, firstname, phone, profil, address, zipcode, city, gravatar);
            contacts.add(contact);
        }
        return contacts;
    }

}
