package com.frontline.quevie.data;

import java.util.ArrayList;

<<<<<<< Updated upstream
public class Movie {
    public Movie(String title, String yearMade, String genre, String director, ArrayList<String> cast) {
=======
public class Movie implements Serializable {
    public Movie(String cover, String title, String yearMade, String genre, String director, List<String> cast) {
        this.cover = cover;
>>>>>>> Stashed changes
        this.title = title;
        this.yearMade = yearMade;
        this.genre = genre;
        this.director = director;
        this.cast = cast;
    }
    private String cover;
    private String title;
    private String yearMade;
    private String genre;
    private String director;
    private ArrayList<String> cast;

    public String getCover() { return cover;}
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
