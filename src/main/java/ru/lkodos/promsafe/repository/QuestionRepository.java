package ru.lkodos.promsafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lkodos.promsafe.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
