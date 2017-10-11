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
    public void update(Profil profilToUpdate) {

        final Profil toUpdate = profilRepository.findOne(profilToUpdate.getId());

        if (toUpdate != null) {
            toUpdate.setType(profilToUpdate.getType());
            toUpdate.setColor(profilToUpdate.getColor());
            profilRepository.save(toUpdate);
        }
    }

    @Override
    public void deleteProfil(int id) {
        profilRepository.delete(id);
    }
}
