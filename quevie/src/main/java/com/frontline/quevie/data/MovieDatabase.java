package com.frontline.quevie.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MovieDatabase {
    private MovieDatabase() {
    }
    private List<Movie> searchResults;
    private static MovieDatabase instance = new MovieDatabase();
    private List<Movie> movies = new ArrayList<Movie>();

    public static MovieDatabase getInstance() {
        return instance;
    }

    public void addMovie(String title, String yearMade, String genre, String director, ArrayList<String> cast) {
        movies.add(new Movie(title, yearMade, genre, director, cast));
    }
    public void searchMoviesByTitle(String search) {
        List<Movie> results = new LinkedList<>();
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getTitle().toLowerCase().contains(search)) {
                results.add(movies.get(i));
            }
        }
        searchResults = results;
    }

    public List<Movie> getSearchResults() {
        return searchResults;
    }
}
