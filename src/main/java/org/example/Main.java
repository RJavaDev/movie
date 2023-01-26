package org.example;

import org.example.dao.UserDao;
import org.example.model.Comment;
import org.example.model.Movie;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        SessionFactory sessionFactory = new Configuration()
//                .configure()
//                .addAnnotatedClass(Movie.class)
//                .addAnnotatedClass(Comment.class)
//                .buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Movie avatar = Movie.builder()
//                .name("Avatar")
//                .releaseDate("2022")
//                .description("Movie 2022")
//                .duration("3 hours")
//                .commentList(List.of())
//                .build();
//        session.save(avatar);
//        User user = User.builder().fullName("hello world").userName("username").email("email.com").password("password").build();
//        session.getTransaction().commit();
//        session.close();
//        sessionFactory.close();

//        SessionFactory sf  = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
//        Session session1 = sf.openSession();
//        session1.beginTransaction();
//        List list = session1.createSQLQuery("select * from movie").list();
//        System.out.println(list.size());
//        session1.getTransaction().commit();
//        session1.close();
//        sf.close();

    }
}