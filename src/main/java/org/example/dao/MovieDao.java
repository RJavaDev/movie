package org.example.dao;

import org.example.model.Movie;
import org.hibernate.SessionFactory;

import java.util.List;

public class MovieDao implements BaseDao<Movie> {
    private SessionFactory sessionFactory;

    public MovieDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Movie getById(int id) {
        return null;
    }

    @Override
    public List<Movie> getList() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean add(Movie movie) {
        return false;
    }
}
