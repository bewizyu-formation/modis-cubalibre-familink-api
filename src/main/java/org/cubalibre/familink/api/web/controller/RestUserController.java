package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.User;
import org.cubalibre.familink.api.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RestUserController {


    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public User createUser(@RequestBody User newUser) {

        return userService.create(newUser);
    }


}
