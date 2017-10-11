package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Profil;
import org.cubalibre.familink.api.services.IProfilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profils")
public class RestProfilController {

    private static final Logger LOG = LoggerFactory.getLogger(RestProfilController.class.getName());

    @Autowired
    @Qualifier("profilService")
    private IProfilService profilService;

    @RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Profil> getProfils() {
        LOG.info("RestProfilController.getProfils");

        return profilService.getProfils();
    }


}
