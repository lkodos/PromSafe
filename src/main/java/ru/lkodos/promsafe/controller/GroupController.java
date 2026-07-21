package ru.lkodos.promsafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lkodos.promsafe.config.AppProperties;
import ru.lkodos.promsafe.entity.Question;
import ru.lkodos.promsafe.service.QuestionService;

import java.util.List;

@Controller
public class GroupController {

    private final QuestionService questionService;
    private final AppProperties appProperties;

    @Autowired
    public GroupController(QuestionService questionService, AppProperties appProperties) {
        this.questionService = questionService;
        this.appProperties = appProperties;
    }

    @GetMapping("/group3")
    public String getQuestionGroup3(@RequestParam(name = "question") int questionNumber, Model model) {
        List<Question> allQuestions = questionService.getQuestions();
        model.addAttribute("currentQuestion", allQuestions.get(questionNumber - 1));
        model.addAttribute("questionsAmtGroup3", appProperties.questionsAmtGroup3());
        model.addAttribute("questionNumber", questionNumber);
        System.out.println(questionNumber);
        System.out.println(allQuestions);
        return "group-3";
    }

    @GetMapping("/group4")
    public String getQuestionGroup4(@RequestParam(name = "question") int questionNumber, Model model) {
        List<Question> allQuestions = questionService.getQuestions();
        model.addAttribute("currentQuestion", allQuestions.get(questionNumber - 1));
        model.addAttribute("questionsAmtGroup4", appProperties.questionsAmtGroup4());
        model.addAttribute("questionNumber", questionNumber);
        System.out.println(questionNumber);
        System.out.println(allQuestions);
        return "group-4";
    }
}
