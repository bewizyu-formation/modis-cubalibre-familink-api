package org.cubalibre.familink.api.services.impl;

import org.cubalibre.familink.api.entite.Profil;
import org.cubalibre.familink.api.repository.ProfilRepository;
import org.cubalibre.familink.api.services.IProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicolas Hodicq (nhodicq@sqli.com)
 */
@Service(value = "profilService")
public class ProfilService implements IProfilService {

    @Autowired
    private ProfilRepository profilRepository;

    @Override
    public List<Profil> getProfils() {

        return profilRepository.findAll();
    }
}
