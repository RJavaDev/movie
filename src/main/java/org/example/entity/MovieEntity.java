package org.example.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class MovieEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String releaseDate;
    private String duration;
    private String description;
    @ManyToOne
    private UserEntity userEntities;
}
