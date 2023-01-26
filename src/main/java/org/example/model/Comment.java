package org.example.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
//    @JoinColumn(name = "user")
    private User user;
    private String comment;
}
