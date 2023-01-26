package org.example.dao;

import org.example.model.Comment;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class CommentDao implements BaseDao<Comment> {
    @Override
    public Comment getById(int id) {
        return null;
    }

    @Override
    public List<Comment> getList() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean add(Comment comment) {
        return false;
    }
}
