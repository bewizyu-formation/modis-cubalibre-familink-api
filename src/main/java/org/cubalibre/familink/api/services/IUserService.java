package org.cubalibre.familink.api.services;


import org.cubalibre.familink.api.entite.User;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link User} que doit posséder une classe
 * d'implémentation
 *
 * @author avl
 */
public interface IUserService {

    /**
     * Creer un nouveau User
     *
     * @param newUser nouveau User
     */
    User create(User newUser);

    /**
     * Récupération d'un User par son id
     *
     * @param id
     * @return
     */
    User getUserById(int id);

    User getUserByMailAndPassword(String mail, String password);
}
