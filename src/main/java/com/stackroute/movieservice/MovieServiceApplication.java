package com.stackroute.movieservice;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class MovieServiceApplication implements ApplicationListener<ContextRefreshedEvent> , CommandLineRunner {

	@Autowired
	MovieRepository movieRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		Movie movie = new Movie(6,"http://google.com","adding a movie",8,2018,"movie");
		movieRepository.save(movie);

	}

	@Override

	public void run(String...args) throws Exception {
		Movie movie = new Movie(55,"http://google.com","adding ",8,2018,"movie");
		movieRepository.save(movie);

	}

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}
}
