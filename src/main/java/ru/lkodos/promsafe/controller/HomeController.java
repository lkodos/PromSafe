package ru.lkodos.promsafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String getHomePage() {
        return "home";
    }
}
