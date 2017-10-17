package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Profil;
import org.cubalibre.familink.api.services.IProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profil")
public class RestProfilController {

    @Autowired
    @Qualifier("profilService")
    private IProfilService profilService;

    // ********** CREATE PROFIL ********** //
    @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public Profil createProfil(@RequestBody Profil newProfil) {

        return profilService.create(newProfil);
    }

    // ******* GET PROFIL BY ID ********** //
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Profil getProfilById(@PathVariable("id") int id) {
        return profilService.getProfilById(id);
    }

    // ******* UPDATE PROFIL BY ID ******** //
    @RequestMapping(path = "/", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public void updateProfil(@RequestBody Profil updateProfil) {

        profilService.update(updateProfil);
    }

    // ******* DELETE PROFIL BY ID ******** //
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProfil(@PathVariable("id") int id) {

        profilService.deleteProfil(id);
    }
}
