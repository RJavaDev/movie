package org.example;

import org.example.model.Movie;
import org.example.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(UserEntity.class)
                .addAnnotatedClass(Movie.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Movie());
        session.save(new UserEntity());
        session.getTransaction().commit();
        session.close();
    }
}