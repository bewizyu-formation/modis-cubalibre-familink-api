package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.PwdToken;
import org.cubalibre.familink.api.services.IPwdTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pwdToken")
public class RestPwdTokenController {

    @Autowired
    @Qualifier("pwdTokenService")
    private IPwdTokenService pwdTokenService;

    // ********** CREATE PASSWORD TOKEN ********** //
    @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public PwdToken createPwdToken(@RequestBody PwdToken newPwdToken) {

        return pwdTokenService.create(newPwdToken);
    }

    // ******* GET PASSWORD TOKEN BY ID ********** //
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PwdToken getPwdTokenById(@PathVariable("id") String id) {
        return pwdTokenService.getPwdTokenById(Integer.parseInt(id));
    }

    // ******* UPDATE PASSWORD TOKEN ******** //
    @RequestMapping(path = "/", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public void updatePwdToken(@RequestBody PwdToken updatePwdToken) {

        pwdTokenService.update(updatePwdToken);
    }
}
