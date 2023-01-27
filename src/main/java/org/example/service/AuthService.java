package org.example.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.example.dao.UserDao;
import org.example.dto.UserRegisterRequest;
import org.example.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@NoArgsConstructor
@Repository
public class AuthService {
    private UserDao userDao;

    @Autowired
    public AuthService(UserDao userDao) {
        this.userDao = userDao;
    }
    public boolean addUser(final UserRegisterRequest userRegisterRequest){
        Object save = userDao.save(userRegisterRequest);
        return save != null;
    }
    public UserEntity login(HttpServletRequest httpServletRequest){
        return userDao.login(httpServletRequest);
    }
}
