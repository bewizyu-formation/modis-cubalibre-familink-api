package org.cubalibre.familink.api.services.impl;

import org.cubalibre.familink.api.entite.User;
import org.cubalibre.familink.api.repository.UserRepository;
import org.cubalibre.familink.api.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe d'implémentation des méthodes de persistence pour la classe {@link User}  
 *
 * @author avl
 */

@Service(value = "userService")
public class UserService implements IUserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class.getName());
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User newUser) {
		return userRepository.save(newUser);
	}
}