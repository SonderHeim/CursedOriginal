package com.cursed.Cursed.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class WRController {
    @GetMapping("/WR")
    public String WRMain(Model model) {
        return "WR";
    }
}
