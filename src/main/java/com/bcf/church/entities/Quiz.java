package com.bcf.church.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(
//        name = "quizzes"
//)
public class Quiz {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @Column(name = "correct_answer", nullable = false)
    private int correctAnswer;
}
