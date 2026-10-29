package ru.lkodos.promsafe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mode-select")
@RequiredArgsConstructor
public class ModeSelectController {

    @GetMapping
    public String modeSelect(@RequestParam("action") String value) {
        if (value.equals("training")) {
            return "redirect:/training";
        }
        return "redirect:/exam";
    }
}
