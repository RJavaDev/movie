package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.dto.MovieRequestDto;
import org.example.entity.MovieEntity;
import org.example.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieDao implements BaseDao<MovieEntity, MovieRequestDto>{
    private final SessionFactory sessionFactory;
    @Override
    public MovieEntity findById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        MovieEntity movieEntity = session.get(MovieEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return movieEntity;
    }

    @Override
    public List<MovieEntity> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List MovieEntityList = session.createQuery("from MovieEntity ").list();
        session.getTransaction().commit();
        session.close();
        return MovieEntityList;
    }

    @Override
    public MovieEntity save(MovieRequestDto movieRequestDto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        MovieEntity save = (MovieEntity) session.save(movieRequestDto);
        session.getTransaction().commit();
        session.close();
        return save;
    }
    public void delete(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        MovieEntity movie = findById(id);
        session.remove(movie);
        session.getTransaction().commit();
        session.close();
    }

}
