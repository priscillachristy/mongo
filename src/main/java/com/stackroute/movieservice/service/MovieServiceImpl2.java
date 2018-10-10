package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;





@Service("MovieServiceImpl2")

public class MovieServiceImpl2 implements MovieService{

    @Autowired

    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie) throws Exception{

        Movie savedMovie= movieRepository.save(movie);

        return savedMovie;



    }

    public List<Movie> getAllMovies(){

        return (List<Movie>)movieRepository.findAll();



    }

    public void deleteMovie(Movie movie) throws MovieNotFoundException {


        if(movieRepository.existsById(movie.getId())) {



            movieRepository.delete(movie);

        }

        else {

            throw new MovieNotFoundException("not found");

        }

    }

    public Optional<Movie> getById(int Id){
        try{
            if(movieRepository.existsById(Id)){
                Optional<Movie> movie = movieRepository.findById(Id);
                return movie;
            }else {
                throw new MovieNotFoundException("id is not present");
            }
        }catch (MovieNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }



    public Movie updateMovie(Movie movie) throws MovieNotFoundException{

        if(movieRepository.existsById(movie.getId())) {

            Movie movie1= movieRepository.findById(movie.getId()).get();

            movie1.setComment(movie.getComment());

            movieRepository.save(movie1);



        }

        else{

            throw new MovieNotFoundException("not found");

        }

        return movie;

    }



    public List<Movie> findMovieByName(String name) {

        List<Movie> moviess = new ArrayList<>();

        for(Movie m: getAllMovies()) {

            if(m.getName().compareTo(name)==0) {

                moviess.add(m);

            }

        }

        return moviess;

    }













}




