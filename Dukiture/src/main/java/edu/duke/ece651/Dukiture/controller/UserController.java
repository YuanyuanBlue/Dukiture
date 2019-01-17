package edu.duke.ece651.Dukiture.controller;


import edu.duke.ece651.Dukiture.model.Item;
import edu.duke.ece651.Dukiture.service.UserService;
import edu.duke.ece651.Dukiture.service.ItemService;
import edu.duke.ece651.Dukiture.model.User;
import edu.duke.ece651.Dukiture.util.JWTUtil;
import edu.duke.ece651.Dukiture.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private ItemService itemService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(Model model) {
        return "error";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userForm.setAPIToken(jwtUtil.generateToken(userForm.getUsername()));
        userService.save(userForm);
        return "redirect:/login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Invalid password.");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out.");
        }
        return "login";
    }

    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public String getProfile(HttpServletRequest request, Model model) {
        User currUser = userService.findByUsername(request.getRemoteUser());
        request.setAttribute("token", currUser.getAPIToken());
        List<Item> items = itemService.getByUsername(currUser.getUsername());
        model.addAttribute("items", items);
        return "profile";
    }

    @RequestMapping(value = {"/profile"}, method = RequestMethod.POST)
    @PreAuthorize("hasRole('READ_PRIVILEGE')")
    public String updateProfile(HttpServletRequest request, @RequestParam("password") String password) {
        User currUser = userService.findByUsername(request.getRemoteUser());
        currUser.setPassword(password);
        userService.save(currUser);
        return "redirect:/items/list";
    }
}
