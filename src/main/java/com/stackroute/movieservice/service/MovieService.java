package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;

import java.util.List;

public interface MovieService {
    public Movie addMovie(Movie movie)throws Exception;
    public void deleteMovie(Movie movie) throws MovieNotFoundException;
    public Movie updateMovie(Movie movie) throws MovieNotFoundException;
    public List<Movie> getAllMovies();

    List<Movie> findMovieByName(String name);
}
