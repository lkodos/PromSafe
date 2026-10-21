package ru.lkodos.promsafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/training")
public class TopicSelectorController {

    @GetMapping
    public String showGroup3Page() {
        return "training/group-3";
    }
}
