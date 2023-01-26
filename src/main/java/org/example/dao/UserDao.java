package org.example.dao;

import lombok.NoArgsConstructor;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;
@NoArgsConstructor

public class UserDao implements BaseDao<User>{

    SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    //    SessionFactory sessionFactory = new Configuration()
//            .configure()
//            .addAnnotatedClass(User.class)
//            .buildSessionFactory();

    @Override
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.beginTransaction().commit();
        session.close();
        sessionFactory.close();
        return user;
    }

    @Override
    public List<User> getList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List userList = session.createSQLQuery("select * from movie").list();
        session.beginTransaction().commit();
        session.close();
        sessionFactory.close();
        return userList;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean add(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Serializable save = session.save(user);
        session.beginTransaction().commit();
        session.close();
        sessionFactory.close();
        return save != null;
    }
}
