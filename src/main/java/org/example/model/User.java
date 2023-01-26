package org.example.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    private String email;
    private String userName;
    private String password;
}
