package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.User;
import org.cubalibre.familink.api.services.IUserService;
import org.cubalibre.familink.api.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class RestAuthController {

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public String getConnection(@RequestBody User user) {
        User existingUser = userService.getUserByMailAndPassword(user.getMail(), user.getPassword());
        String token = "";
        if (existingUser != null) {
            try {
                token = TokenUtils.generateToken(existingUser.getId());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return token;
    }
}
