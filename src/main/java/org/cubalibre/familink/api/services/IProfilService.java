package org.cubalibre.familink.api.services;

import org.cubalibre.familink.api.entite.Profil;

import java.util.List;

public interface IProfilService {

    List<Profil> getProfils();

    Profil getProfilById(int id);

}
