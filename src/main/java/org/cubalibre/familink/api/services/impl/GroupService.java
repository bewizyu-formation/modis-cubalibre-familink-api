package org.cubalibre.familink.api.services.impl;

import org.cubalibre.familink.api.entite.Group;
import org.cubalibre.familink.api.repository.GroupRepository;
import org.cubalibre.familink.api.services.IGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe d'implémentation des méthodes de persistence pour la classe {@link Group}
 *
 * @author avl
 */

@Service(value = "userService")
public class GroupService implements IGroupService {

	private static final Logger LOG = LoggerFactory.getLogger(GroupService.class.getName());

	@Autowired
	private GroupRepository groupRepository;

	@Override
	public Group create(Group newGroup) {
        return groupRepository.save(newGroup);
	}
}