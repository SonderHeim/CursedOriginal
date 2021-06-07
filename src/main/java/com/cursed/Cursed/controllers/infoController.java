package com.cursed.Cursed.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class infoController {
    @GetMapping("/information")
    public String MainPage2(Model model) {
        model.addAttribute("title", "Информация");
        return "information";
    }
}
