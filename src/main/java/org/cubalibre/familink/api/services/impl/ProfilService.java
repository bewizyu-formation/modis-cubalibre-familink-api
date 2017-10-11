package org.cubalibre.familink.api.services.impl;

import org.cubalibre.familink.api.entite.Profil;
import org.cubalibre.familink.api.repository.ProfilRepository;
import org.cubalibre.familink.api.services.IProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "profilService")
public class ProfilService implements IProfilService {

    @Autowired
    private ProfilRepository profilRepository;

    @Override
    public List<Profil> getProfils() {
        return profilRepository.findAll();
    }

    @Override
    public Profil create(Profil newProfil) {

        return profilRepository.save(newProfil);
    }

    @Override
    public Profil getProfilById(int id) {

        return profilRepository.findOne(id);
    }

    @Override
    public void update(Profil toUpdate) {

        final Profil profilToUpdate = profilRepository.findOne(toUpdate.getId());

        if (toUpdate != null) {
            profilToUpdate.setType(toUpdate.getType());
            profilToUpdate.setColor(toUpdate.getColor());
            profilRepository.save(profilToUpdate);
        }
    }

    @Override
    public void deleteProfil(int id) {

        profilRepository.delete(id);
    }
}
