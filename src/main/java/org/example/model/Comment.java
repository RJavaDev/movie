package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private int id;
    private String context;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    Movie movie;
}
