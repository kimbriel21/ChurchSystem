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
//        name = "quiz_results"
//)
public class QuizResult {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private User user;
    private Lesson lesson;
    private int score;
}
