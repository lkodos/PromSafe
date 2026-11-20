package ru.lkodos.promsafe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import ru.lkodos.promsafe.model.Question;
import ru.lkodos.promsafe.service.QuestionService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/mode")
@RequiredArgsConstructor
public class ModeSelectController {

    private final QuestionService questionService;
    private final Set<String> MODES = Set.of("training", "exam", "edit");

    @GetMapping
    public String modeSelect(@RequestParam(value = "action") String action, Model model) {
        if (!MODES.contains(action)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Неизвестное действие: " + action);
        }
        List<Question> allQuestions = questionService.getAllQuestions();
        model.addAttribute("questionsAmount", allQuestions.size());
        model.addAttribute("questionNumber", 1);
        model.addAttribute("question", allQuestions.getFirst().getQuestion());
        return action;
    }
}
