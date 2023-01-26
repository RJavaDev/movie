package org.example;

import org.example.config.AppContext;
import org.example.dao.UserDao;
import org.example.dto.UserRequestDto;
import org.example.entity.MovieEntity;
import org.example.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.xml.stream.events.Comment;

public class Main {
    public static void main(String[] args) {

//        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(UserEntity.class)
//                .addAnnotatedClass(Comment.class)
//                .addAnnotatedClass(MovieEntity.class)
//                .buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(new UserEntity(1,"Sayid","email","username","1"));
//        session.getTransaction().commit();
//        session.close();
    }
}
