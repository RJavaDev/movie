package org.example.config;
import org.example.dao.MovieDao;
import org.example.dao.UserDao;
import org.example.model.Comment;
import org.example.model.Movie;
import org.example.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc


@org.springframework.context.annotation.Configuration
public class AppConfig implements WebMvcConfigurer {

    @Bean
    SessionFactory sessionFactory(){
        return new Configuration().configure()
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }
    @Bean
    UserDao userDao(){
        return new UserDao(sessionFactory());
    }

    @Bean
    MovieDao movieDao(){
        return new MovieDao(sessionFactory());
    }

}
