package ru.lkodos.promsafe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lkodos.promsafe.service.ModeSelectService;

@Controller
@RequestMapping("/mode-select")
@RequiredArgsConstructor
public class ModeSelectController {

    private final ModeSelectService modeSelectService;

    @GetMapping
    public String modeSelect(@RequestParam("action") String value,
                             @RequestParam("section") String section,
                             Model model) {
        long questionsCount = modeSelectService.getQuestionsCount();
        model.addAttribute("questionsCount", questionsCount);
        if (value.equals("training")) {
            return "training";
        }
        return "exam";
    }
}
