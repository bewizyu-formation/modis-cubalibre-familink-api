package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Profil;
import org.cubalibre.familink.api.services.IProfilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profils")
public class RestProfilController {

    private static final Logger LOG = LoggerFactory.getLogger(RestProfilController.class.getName());

    @Autowired
    @Qualifier("profilService")
    private IProfilService profilService;


    // ********** CREATE PROFILS ********** //
    @RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Profil> getProfils() {
        return profilService.getProfils();
    }

    // ********** CREATE PROFIL ********** //
    @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public Profil createProfil(@RequestBody Profil newProfil) {
        return profilService.create(newProfil);
    }

    // ******* GET PROFIL BY ID ********** //
    @RequestMapping(path = "/{idProfil}", method = RequestMethod.GET)
    @ResponseBody
    public Profil getProfilById(@PathVariable("idProfil") String idProfil) {
        return profilService.getProfilById(Integer.parseInt(idProfil));
    }

    // ******* UPDATE PROFIL BY ID ******** //
    @RequestMapping(path = "/", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public void updateProfil(@RequestBody Profil updateProfil) {
        profilService.update(updateProfil);
    }

    // ******* DELETE PROFIL BY ID ******** //
    @RequestMapping(path = "/{idProfil}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProfil(@PathVariable("idProfil") String idProfil) {
        profilService.deleteProfil(Integer.parseInt(idProfil));

    }
}
