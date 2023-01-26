package org.example;

import org.example.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.xml.stream.events.Comment;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserEntity.class)
//                .addAnnotatedClass(MovieEntity.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
    }
}
