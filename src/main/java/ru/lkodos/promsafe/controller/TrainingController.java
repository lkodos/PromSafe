package ru.lkodos.promsafe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lkodos.promsafe.model.Question;
import ru.lkodos.promsafe.service.QuestionService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/training")
public class TrainingController {

    private final QuestionService questionService;

//    @GetMapping({"", "/{questionNumber}"})
    @GetMapping
    public String showQuestion(Model model) {

        List<Question> allQuestions = questionService.getAllQuestions();
        System.out.println(allQuestions.size());
        model.addAttribute("allQuestions", allQuestions);
        return "training";
    }
}
