package com.cursed.Cursed.controllers;

import com.cursed.Cursed.models.Role;
import com.cursed.Cursed.models.User;
import com.cursed.Cursed.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute("user", new User());
        return "reg";
    }
    @PostMapping("/reg")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        User userFromDB = userService.getUser(user.getUsername());

        if (userFromDB != null) {
            model.addAttribute("error", "такой пользователь уже есть");
            return "reg";
        }

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);

        return "redirect:/index";
    }
}
