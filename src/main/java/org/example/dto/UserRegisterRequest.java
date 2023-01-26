package org.example.dto;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String fullName;
    private String email;
    private String userName;
    private String password;
}
