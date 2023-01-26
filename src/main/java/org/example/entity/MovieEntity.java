package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;


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
