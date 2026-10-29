package ru.lkodos.promsafe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lkodos.promsafe.model.Question;
import ru.lkodos.promsafe.service.QuestionService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/training")
public class TrainingController {

    private final QuestionService questionService;

    @GetMapping({"", "/{questionNumber}"})
    public String showTrainingPage(@PathVariable(required = false) Integer questionNumber, Model model) {

        if (questionNumber == null) {
            questionNumber = 1;
        }
        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        model.addAttribute("questionNumber", questionNumber);
        return "training";
    }
}
