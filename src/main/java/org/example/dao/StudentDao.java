package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.dto.StudentRequestDto;
import org.example.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentDao implements BaseDao<UserEntity, StudentRequestDto>{

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
        return null;
    }

    @Override
    public void save(StudentRequestDto studentRequestDto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(studentRequestDto);
        session.getTransaction().commit();
        session.close();
    }

}
