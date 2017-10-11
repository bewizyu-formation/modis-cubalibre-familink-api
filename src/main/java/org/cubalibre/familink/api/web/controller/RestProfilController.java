package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Profil;
import org.cubalibre.familink.api.services.IProfilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profil")
public class RestProfilController {

    private static final Logger LOG = LoggerFactory.getLogger(RestProfilController.class.getName());

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
    public Profil getProfilById(@PathVariable("id") String id) {
        return profilService.getProfilById(Integer.parseInt(id));
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
    public void deleteProfil(@PathVariable("id") String id) {
        profilService.deleteProfil(Integer.parseInt(id));

    }
}
