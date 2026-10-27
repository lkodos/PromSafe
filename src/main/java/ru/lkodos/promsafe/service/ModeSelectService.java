package ru.lkodos.promsafe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lkodos.promsafe.repository.QuestionRepository;

@Service
@RequiredArgsConstructor
public class ModeSelectService {

    private final QuestionRepository questionRepository;

    public long getQuestionsCount() {
        return questionRepository.count();
    }
}
