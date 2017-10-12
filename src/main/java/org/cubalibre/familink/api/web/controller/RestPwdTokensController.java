package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.PwdToken;
import org.cubalibre.familink.api.services.IPwdTokenService;
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
@RequestMapping("/pwdTokens")
public class RestPwdTokensController {

    private static final Logger LOG = LoggerFactory.getLogger(RestPwdTokensController.class.getName());

    @Autowired
    @Qualifier("pwdTokenService")
    private IPwdTokenService pwdTokenService;


    // ********** GET PASSWORD TOKENS ********** //
    @RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<PwdToken> getPwdTokens() {

        return pwdTokenService.getPwdTokens();
    }

}
