package org.cubalibre.familink.api.services;

import org.cubalibre.familink.api.entite.PwdToken;

import java.util.List;

public interface IPwdTokenService {

    /**
     * Extrait tous les tokens existants
     *
     * @return
     */
    List<PwdToken> getPwdTokens();

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

    /**
     * Suppression d'un PwdToken by id
     *
     * @param id
     */
    void deletePwdToken(final int id);

}
