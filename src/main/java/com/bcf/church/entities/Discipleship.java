package com.bcf.church.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "discipleship"
)
public class Discipleship {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private int batch_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int level;
}
