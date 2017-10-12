package org.cubalibre.familink.api.services;

import org.cubalibre.familink.api.entite.Profil;

import java.util.List;

public interface IProfilService {

    /**
     * Extrait tous les profils existants
     *
     * @return
     */
    List<Profil> getProfils();

    /**
     * Creer un nouveau Profil
     *
     * @param newProfil nouveau Profil
     */
    Profil create(Profil newProfil);

    /**
     * Récupération d'un Profil par son id
     *
     * @param id
     * @return
     */
    Profil getProfilById(int id);

    /**
     * Mise à jour d'un Profil
     *
     * @param profil
     */
    void update(Profil profil);

    /**

     * Suppression d'un Profil by id

     *
     * @param id
     */
    void deleteProfil(final int id);

}
