package ru.lkodos.promsafe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lkodos.promsafe.model.Question;
import ru.lkodos.promsafe.repository.QuestionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public long getQuestionCount() {
        return questionRepository.count();
    }
}
