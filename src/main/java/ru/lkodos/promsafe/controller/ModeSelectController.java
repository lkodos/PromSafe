package ru.lkodos.promsafe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Controller
@RequestMapping("/mode")
public class ModeSelectController {

    private final Set<String> MODES = Set.of("training", "exam", "edit");

    @GetMapping
    public String modeSelect(@RequestParam(value = "action") String action, Model model) {
        if (!MODES.contains(action)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Неизвестное действие: " + action);
        }
        return action;
    }
}
