package org.cubalibre.familink.api.services;


import org.cubalibre.familink.api.entite.Group;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link Group} que doit posséder une classe
 * d'implémentation
 *
 * @author avl
 */
public interface IGroupService {

    /**
     * Creer un nouveau Group
     *
     * @param newGroup nouveau Group
     */
    Group create(Group newGroup);

}
