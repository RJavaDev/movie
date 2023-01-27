package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.dto.CommentRequestDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class Comment implements BaseDao<Comment, CommentRequestDto>{
    private final SessionFactory sessionFactory;
    @Override
    public Comment findById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Comment comment = session.get(Comment.class, id);
        session.getTransaction().commit();
        session.close();
        return comment;
    }

    @Override
    public List<Comment> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Comment> commentList = session.createQuery("from Comment").list();
        session.getTransaction().commit();
        session.close();
        return commentList;
    }

    @Override
    public Comment save(CommentRequestDto commentRequestDto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Comment comment = (Comment) session.save(commentRequestDto);
        session.getTransaction().commit();
        session.close();
        return comment;
    }
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Comment comment = findById(id);
        session.remove(comment);
        session.getTransaction().commit();
        session.close();
    }
}
