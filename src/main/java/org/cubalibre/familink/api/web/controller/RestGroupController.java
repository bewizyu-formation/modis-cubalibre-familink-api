package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Group;
import org.cubalibre.familink.api.entite.User;
import org.cubalibre.familink.api.services.IGroupService;
import org.cubalibre.familink.api.services.IUserService;
import org.cubalibre.familink.api.utils.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
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
    public Group createGroup(@RequestBody String name, @RequestHeader HttpHeaders headers) {
        String token = null;
        if (headers.containsKey("token")) {
            token = headers.get("token").get(0);
        }

        String decodedToken = null;
        try {
            decodedToken = Base64Utils.decode(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Base64Utils.isValidToken(decodedToken)) {
            String userId = decodedToken.substring(0, decodedToken.indexOf("-"));
            System.out.println(userId);

            Group groupToInsert;

            User user = userService.getUserById(Integer.parseInt(userId));
            if (user != null) {
                groupToInsert = new Group(user, name, new Date(), null);
                return groupService.create(groupToInsert);
            } else {
            throw new IllegalArgumentException("User doesn't exist !!");
        }
        } else {
            throw new IllegalArgumentException("TOKEN INVALID");
        }
    }
}
