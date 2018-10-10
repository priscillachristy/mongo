package com.stackroute.movieservice.exceptions;

public class MovieNotFoundException extends Exception{
        public MovieNotFoundException(String message){
            super(message);
        }
}
