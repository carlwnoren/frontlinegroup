package com.frontline.quevie.data;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    public Movie(String title, String yearMade, String genre, String director, List<String> cast) {
        this.title = title;
        this.yearMade = yearMade;
        this.genre = genre;
        this.director = director;
        this.cast = cast;
    }
    private String title;
    private String yearMade;
    private String genre;
    private String director;
    private List<String> cast;

    public String getTitle() {
        return title;
    }

    public String getYearMade() {
        return yearMade;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getCast() {
        return cast;
    }
}
