package org.cubalibre.familink.api.web.controller;

import org.cubalibre.familink.api.entite.Group;
import org.cubalibre.familink.api.entite.User;
import org.cubalibre.familink.api.services.IContactService;
import org.cubalibre.familink.api.services.IUserService;
import org.cubalibre.familink.api.utils.Base64Utils;
import org.cubalibre.familink.api.utils.TokenUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "*", allowedHeaders = "authorization")
public class RestGroupsController {

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @Autowired
    @Qualifier("contactServiceJpa")
    private IContactService contactServiceJpa;

    @RequestMapping(path = "/", method = RequestMethod.GET, consumes = "application/json;charset=UTF-8", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getGroupsByUser(@RequestHeader(value = "Authorization") String token) {
        JSONObject jsonGroups = new JSONObject();
        JSONArray jsonGroupArray = new JSONArray();
        JSONObject jsonGroup = new JSONObject();

        String decodedToken = null;
        try {
            decodedToken = Base64Utils.decode(token);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String userId = TokenUtils.getUserIdFromToken(decodedToken);

        User user = userService.getUserById(Integer.parseInt(userId));
        if (user != null) {
            List<Group> groups = contactServiceJpa.getGroupsByUser(user.getId());
            for (int i = 0; i < groups.size(); i++ ) {
                jsonGroup.put("id", groups.get(i).getId());

                JSONObject jsonOwner = new JSONObject();
                jsonOwner.put("id", groups.get(i).getOwner().getId());
                jsonGroup.put("owner", jsonOwner);

                jsonGroup.put("name", groups.get(i).getName());

                jsonGroupArray.put(jsonGroup);
            }
            jsonGroups.put("groups", jsonGroupArray);
        }


        return jsonGroups.toString();
    }
}