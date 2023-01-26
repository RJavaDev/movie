package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String releaseDate;
    private String duration;
    private String description;
    @OneToMany(mappedBy = "comment")
    private List<Comment> commentList;
}
