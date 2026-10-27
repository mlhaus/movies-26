package edu.kirkwood;

import edu.kirkwood.dao.sql.SQLMovieDAO;
import edu.kirkwood.model.sql.MovieEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MyDataApplication {
    static void main(String[] args) {
        SpringApplication.run(MyDataApplication.class, args);
    }

    @Bean
    CommandLineRunner run(SQLMovieDAO movieDAO) {
        return args -> {
            String title = "Obsession";
            List<MovieEntity> movies = movieDAO.search(title);
            if(movies.isEmpty()) {
                System.out.println("No movies found matching '" + title + "'.");
            } else {
                movies.forEach(System.out::println);
            }
        };
    }
}
