package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String url;
    private String releaseDate;
    private String duration;
    private String description;
    @ManyToMany(mappedBy = "movies")
    private HashSet<UserEntity> userEntities;
    @OneToMany(mappedBy="movie")
    private List<Comment> commentList;


}
