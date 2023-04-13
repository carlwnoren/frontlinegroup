/**
 * This class implements a singleton MovieDatabase. It stores all available movies to search for,
 * is able to search through those movies based on the title, and can return a list of those movies.
 */
package com.frontline.quevie.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javafx.scene.image.Image;

public class MovieDatabase implements Serializable {
    MovieDatabase() { //private constructor for singleton implementation
    }
    private static MovieDatabase instance = new MovieDatabase(); //creates a new database object immediately
    public static MovieDatabase getInstance() {
        return instance;
    } //gets the singleton instance
    private List<Movie> searchResults; //List of movies to be returned on the search results screen.
    private List<Movie> movies = new ArrayList<Movie>(); //list of stored movies

    //Manually add a movie to the database (done in the main method)
    public void addMovie(String title, String yearMade, String genre, String director, ArrayList<String> cast) {
        movies.add(new Movie(title, yearMade, genre, director, cast));
    }

    //Sets the searchResults field with the movies that have the provided substring in the title
    public void searchMoviesByTitle(String search) {
        List<Movie> results = new LinkedList<>();
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getTitle().toLowerCase().contains(search.toLowerCase())) {
                results.add(movies.get(i));
            }
        }

        for (int i = 0; i < movies.size(); i++) {
            for(String actor : movies.get(i).getCast()) {
                if (actor.toLowerCase().contains(search.toLowerCase())) {
                    results.add(movies.get(i));
                    break;
                }
            }
        }
        searchResults = results;
    }

    public List<Movie> getSearchResults() {
        return searchResults;
    }
}
