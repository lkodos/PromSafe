package ru.lkodos.promsafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String getHomePage() {
        return "home";
    }

    @RequestMapping("/group-4")
    public String getGroup4Page() {
        return "group-4";
    }

    @RequestMapping("/group-3")
    public String getGroup3Page() {
        return "group-3";
    }
}
