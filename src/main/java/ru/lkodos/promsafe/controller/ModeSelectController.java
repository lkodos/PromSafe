package ru.lkodos.promsafe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import ru.lkodos.promsafe.service.QuestionService;

import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mode")
public class ModeSelectController {

    private final QuestionService questionService;

    private final Set<String> MODES = Set.of("training", "exam", "edit");

    @GetMapping
    public String modeSelect(@RequestParam(value = "action") String action, Model model) {
        if (!MODES.contains(action)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Неизвестное действие: " + action);
        }
        long questionCount = questionService.getQuestionCount();
        model.addAttribute("questionCount", questionCount);
        model.addAttribute("currentQuestion", 1);
        return action;
    }
}
