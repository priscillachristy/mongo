package com.stackroute.movieservice.controllers;

import com.stackroute.movieservice.service.MovieService;

import com.stackroute.movieservice.domain.Movie;

import com.stackroute.movieservice.exceptions.MovieNotFoundException;

import com.stackroute.movieservice.service.MovieServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



import java.util.List;



@RestController

@RequestMapping("api/v1")

public class MovieController {



    private MovieService movieService;



//@Autowired

    public void setMovieService(MovieService movieService) {

        this.movieService= movieService;

    }



    @Autowired


    public MovieController(@Qualifier("MovieServiceImpl2") MovieService movieService) {

        this.movieService= movieService;

    }







    @PostMapping("movie")

    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){

        ResponseEntity responseEntity;

        try {



            Movie savedMovie = movieService.addMovie(movie);

            responseEntity= new ResponseEntity<Movie>(savedMovie, HttpStatus.OK);

        }catch(Exception exception){

            responseEntity=new ResponseEntity<String>("Unsuccessful creation",HttpStatus.CONFLICT);



        }



        return responseEntity;







    }

    @GetMapping("movies")

    public ResponseEntity<?> getAllMovie(){

        List<Movie> movieList;

        movieList=movieService.getAllMovies();

        ResponseEntity responseEntity=new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);

        return responseEntity;





    }



    @DeleteMapping("movie")

    public ResponseEntity<?> deleteMovie(@RequestBody Movie movie){



        ResponseEntity responseEntity;

        try {



            movieService.deleteMovie(movie);

            responseEntity = new ResponseEntity(movie, HttpStatus.OK);

            return responseEntity;

        }catch(MovieNotFoundException ex){

            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

            return  responseEntity;

        }





    }



    @PutMapping("movie")

    public ResponseEntity<?> updateMovie(@RequestBody Movie movie){



        ResponseEntity responseEntity;

        try {

            movieService.updateMovie(movie);

            responseEntity = new ResponseEntity(movie, HttpStatus.OK);

            return responseEntity;

        }catch(MovieNotFoundException ex){

            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

            return  responseEntity;



        }







    }

    @GetMapping("movie/{name}")

    public ResponseEntity<?> searchMovie(@PathVariable String name){

        List<Movie> movieList;

        movieList=movieService.findMovieByName(name);

        ResponseEntity responseEntity=new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);

        return responseEntity;





    }



}


