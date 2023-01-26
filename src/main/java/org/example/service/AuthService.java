package org.example.service;

import lombok.NoArgsConstructor;
import org.example.dao.UserDao;
import org.example.dto.UserLoginRequest;
import org.example.dto.UserRegisterRequest;
import org.example.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@NoArgsConstructor
@Service
public class AuthService {

    private UserDao userDao;

    @Autowired
    public AuthService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean addUser(final UserRegisterRequest userRegisterRequest) {
        UserEntity user = UserEntity.builder()
                .fullName(userRegisterRequest.getFullName())
                .email(userRegisterRequest.getEmail())
                .password(userRegisterRequest.getPassword())
                .build();
        UserEntity save = userDao.save(userRegisterRequest);
        return save != null;
    }

    public UserEntity login(final UserLoginRequest userLoginRequest) {
        return userDao.login(userLoginRequest);
    }
}
