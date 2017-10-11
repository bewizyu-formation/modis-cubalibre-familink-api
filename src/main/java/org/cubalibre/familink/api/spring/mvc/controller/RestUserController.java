package org.cubalibre.familink.api.spring.mvc.controller;

import org.cubalibre.familink.api.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe qui sert de point d'entree pour la coordination traitements - rendu logique
 *
 * @author avl
 */

@RestController

// mapping URL - traitements
@RequestMapping("/users")
public class RestUserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(RestUserController.class.getName());

	@Autowired
	@Qualifier("userService")
	private IUserService userService;
}
