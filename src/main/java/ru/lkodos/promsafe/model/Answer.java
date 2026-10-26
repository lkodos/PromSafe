package ru.lkodos.promsafe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "answers")
@NoArgsConstructor
@Getter
@Setter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "answer", nullable = false, unique = true, columnDefinition = "TEXT")
    @NotBlank(message = "Поле не может быть пустым")
    private String answer;

    @Column(name = "is_correct", nullable = false, unique = true, columnDefinition = "TEXT")
    @NotBlank(message = "Поле не может быть пустым")
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
