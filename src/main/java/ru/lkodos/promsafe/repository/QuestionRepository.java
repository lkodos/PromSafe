package ru.lkodos.promsafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lkodos.promsafe.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
