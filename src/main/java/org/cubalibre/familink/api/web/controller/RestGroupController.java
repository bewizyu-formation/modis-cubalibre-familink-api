package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Group;
import org.cubalibre.familink.api.entite.User;
import org.cubalibre.familink.api.services.IGroupService;
import org.cubalibre.familink.api.services.IUserService;
import org.cubalibre.familink.api.utils.Base64Utils;
import org.cubalibre.familink.api.utils.TokenUtils;
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

//        @RequestHeader(value = "Authorization", required = true) String requestToken

//        @RequestHeader String Authorization

//        final String authorization = httpRequest.getHeader("Authorization");
//        if (authorization != null && authorization.startsWith("token")) {
//            // Authorization: Basic base64credentials
//            String base64Credentials = authorization.substring("Basic".length()).trim();
//            String credentials = new String(Base64.getDecoder().decode(base64Credentials),
//                    Charset.forName("UTF-8"));
//            // credentials = username:password
//            final String[] values = credentials.split("-", 2);
//        }

        String token = null;
        if (headers.containsKey("Authorization")) {
            token = headers.get("Authorization").get(0);
        } else {
            throw new IllegalArgumentException("UNAUTHORISED");
        }

        String decodedToken = null;
        try {
            decodedToken = Base64Utils.decode(token);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (TokenUtils.isValidToken(decodedToken)) {
            String userId =  TokenUtils.getUserIdFromToken(decodedToken);

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
