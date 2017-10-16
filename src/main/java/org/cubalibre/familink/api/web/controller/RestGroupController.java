package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Group;
import org.cubalibre.familink.api.entite.User;
import org.cubalibre.familink.api.services.IGroupService;
import org.cubalibre.familink.api.services.IUserService;
import org.cubalibre.familink.api.utils.Base64Utils;
import org.cubalibre.familink.api.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/group")
public class RestGroupController {

    @Autowired
    @Qualifier("groupService")
    private IGroupService groupService;

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public Group createGroup(@RequestBody String name, @RequestHeader(value = "Authorization") String token) {
        String decodedToken = null;
        try {
            decodedToken = Base64Utils.decode(token);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String userId = TokenUtils.getUserIdFromToken(decodedToken);

        Group groupToInsert;

        User user = userService.getUserById(Integer.parseInt(userId));
        if (user != null) {
            groupToInsert = new Group(user, name, new Date(), null);
            return groupService.create(groupToInsert);
        } else {
            throw new IllegalArgumentException("User doesn't exist !!");

        }
    }
}