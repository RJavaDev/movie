package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    private String email;
    private String username;
    private String password;
    @Cascade({
            org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.MERGE,
            org.hibernate.annotations.CascadeType.PERSIST
    })
    @JoinTable(
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "movie_id") }
    )
    @ManyToMany
    private HashSet<Movie> movies;
    @OneToMany(mappedBy="userEntity")
    private List<Comment> commentList;


}
