package com.frontline.quevie.data;

import java.util.ArrayList;

public class Movie {
    public Movie(String title, String yearMade, String genre, String director, ArrayList<String> cast) {
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
    private ArrayList<String> cast;

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

    public ArrayList<String> getCast() {
        return cast;
    }
}
