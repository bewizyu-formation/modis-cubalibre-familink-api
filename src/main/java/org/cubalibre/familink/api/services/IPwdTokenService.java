package org.cubalibre.familink.api.services;

import org.cubalibre.familink.api.entite.PwdToken;

public interface IPwdTokenService {

    /**
     * Creer un nouveau PwdToken
     *
     * @param newPwdToken nouveau Token for password
     */
    PwdToken create(PwdToken newPwdToken);

    /**
     * Récupération d'un PwdToken par son id
     *
     * @param id
     * @return
     */
    PwdToken getPwdTokenById(int id);

    /**
     * Mise à jour d'un PwdToken
     *
     * @param pwdToken
     */
    void update(PwdToken pwdToken);
}
