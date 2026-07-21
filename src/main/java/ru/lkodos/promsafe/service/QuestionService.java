package ru.lkodos.promsafe.service;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lkodos.promsafe.entity.Question;
import ru.lkodos.promsafe.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Getter
    private List<Question> questions;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @PostConstruct
    public void init() {
        questions = questionRepository.findAll();
    }
}
