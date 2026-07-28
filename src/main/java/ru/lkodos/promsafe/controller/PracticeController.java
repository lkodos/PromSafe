package ru.lkodos.promsafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lkodos.promsafe.config.AppProperties;
import ru.lkodos.promsafe.entity.Question;
import ru.lkodos.promsafe.service.QuestionService;

import java.util.List;

@Controller
public class PracticeController {

    private final QuestionService questionService;
    private final AppProperties appProperties;

    @Autowired
    public PracticeController(QuestionService questionService, AppProperties appProperties) {
        this.questionService = questionService;
        this.appProperties = appProperties;
    }

    @GetMapping("/select-group/{group}")
    public String selectGroup(@PathVariable int group) {
        return "redirect:/practice/" + group + "?questionNumber=1";
    }

    @GetMapping("/practice/{group}")
    public String getPracticePage(@PathVariable int group,
                                  @RequestParam(name = "questionNumber") int questionNumber,
                                  Model model) {
        int questionAmount = 0;
        if (group == 3) {
            questionAmount = appProperties.questionsAmtGroup3();
        } else if (group == 4) {
            questionAmount = appProperties.questionsAmtGroup4();
        }
        List<Question> allQuestions = questionService.getQuestions();
        model.addAttribute("currentQuestion", allQuestions.get(questionNumber - 1));
        model.addAttribute("questionAmount", questionAmount);
        model.addAttribute("questionNumber", questionNumber);
        System.out.println(questionNumber);
        System.out.println(allQuestions);
        return "practice";
    }
}
