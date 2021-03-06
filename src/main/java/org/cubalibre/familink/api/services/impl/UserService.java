package org.cubalibre.familink.api.services.impl;

import org.cubalibre.familink.api.entite.Contact;
import org.cubalibre.familink.api.entite.User;
import org.cubalibre.familink.api.repository.UserRepository;
import org.cubalibre.familink.api.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe d'implémentation des méthodes de persistence pour la classe {@link User}  
 *
 * @author avl
 */

@Service(value = "userService")
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
    @Autowired
    private ContactService contactService;

	@Override
	public User create(User newUser) {
        Contact contactId = contactService.getContactById(newUser.getContact().getId());
        newUser.setContact(contactId);
        return userRepository.save(newUser);
	}

    @Override
    public User getUserById(int id) {

        return userRepository.findOne(id);
    }

    @Override
    public User getUserByMailAndPassword(String mail, String password) {
        return userRepository.findByMailAndPassword(mail, password);
    }
}