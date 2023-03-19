/**
 * This class implements a Movie object. It stores basic information on a movie
 * and checks for equality based on the matching title and year made.
 */

package com.frontline.quevie.data;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.image.Image;


public class Movie implements Serializable {
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

    //Returns equality check based on year made and title.
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Movie))
            return false;

        Movie movie = (Movie) o;

        return (movie.getTitle().equals(title) && movie.getYearMade().equals(yearMade));
    }
}
