package edu.duke.ece651.Dukiture.controller;

import edu.duke.ece651.Dukiture.service.UserService;
import edu.duke.ece651.Dukiture.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Secured({"ROLE_USER","ROLE_ADMIN"})
public class UserRestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/users/id/", method = RequestMethod.GET)
    public Map<String, String> getUserById(HttpServletRequest request) {
        User user =  userService.findById(Long.valueOf(request.getParameter("id")));
        Map<String, String> response = new HashMap<>();
        response.put("username", user.getUsername());
        return response;
    }

    @RequestMapping(value = "/api/users/netid/", method = RequestMethod.GET)
    public Map<String, String> getUserByNetId(HttpServletRequest request) {
        User user =  userService.findByUsername(request.getParameter("netid"));
        Map<String, String> response = new HashMap<>();
        if (user != null) {
            response.put("username", user.getUsername());
        }
        return response;
    }

}
