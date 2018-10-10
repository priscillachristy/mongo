package com.stackroute.movieservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
@Document(collection = "movies")
public class Movie {

    @Id
    private int id;
    private String url;
    private String comment;
    float rating;
    int yearOfRelease;
    private String name;

    public Movie(int id, String url, String comment, float rating, int yearOfRelease, String name) {
        this.id = id;
        this.url = url;
        this.comment = comment;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }


    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
