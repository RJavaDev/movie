package org.example.dao;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.dto.UserRegisterRequest;
import org.example.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDao implements BaseDao<UserEntity, UserRegisterRequest> {
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
        List<UserEntity> fromUserEntity =
                session.createQuery("from UserEntity ").list();
        session.getTransaction().commit();
        session.close();
        return fromUserEntity;
    }

    @Override
    public UserEntity save(UserRegisterRequest userRegisterRequest) {
        UserEntity user = UserEntity.builder()
                .id(1)
                .fullName(userRegisterRequest.getFullName())
                .email(userRegisterRequest.getEmail())
                .username(userRegisterRequest.getUserName())
                .password(userRegisterRequest.getPassword()).build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Object userEntity = session.save(user);
        session.getTransaction().commit();
        session.close();
        if (userEntity.equals(1)){
            return user;
        }
        return null;
    }

    public UserEntity login(HttpServletRequest request) {
        Session session = sessionFactory.openSession();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        session.beginTransaction();
        Query query = session.createQuery("from UserEntity u where u.username=:user_name and u.password=:password");
        query.setParameter("user_name", userName);
        query.setParameter("password", password);
        Object userEntity = query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return userEntity.equals(1)? (UserEntity) userEntity : null;
    }

}
