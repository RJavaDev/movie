package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserLoginRequest;
import org.example.dto.UserRegisterRequest;
import org.example.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class UserDao implements BaseDao<UserEntity, UserRegisterRequest>{
    private final SessionFactory sessionFactory;

    @Override
    public UserEntity findById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserEntity userEntity = session.get(UserEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return userEntity;
    }

    @Override
    public List<UserEntity> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UserEntity> fromUserEntity = session.createQuery("from UserEntity ").list();
        session.getTransaction().commit();
        session.close();
        return fromUserEntity;
    }

    @Override
    public UserEntity save(UserRegisterRequest userRegisterRequest) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserEntity userEntity = (UserEntity)session.save(userRegisterRequest);
        session.getTransaction().commit();
        session.close();
        return userEntity;
    }
    public UserEntity login(UserLoginRequest userLoginRequest){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserEntity user = (UserEntity) session.createQuery("from UserEntity where userName = " + userLoginRequest.getUserName() + " and password = " + userLoginRequest.getPassword());
        session.getTransaction().commit();
        session.close();
        return user;
    }

}
