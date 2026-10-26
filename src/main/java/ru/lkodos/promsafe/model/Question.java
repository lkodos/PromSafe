package ru.lkodos.promsafe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "question", nullable = false, unique = true, columnDefinition = "TEXT")
    @NotBlank(message = "Поле не может быть пустым")
    private String question;

    @OneToMany(mappedBy = "question")
    private List<Answer> answerList;
}
