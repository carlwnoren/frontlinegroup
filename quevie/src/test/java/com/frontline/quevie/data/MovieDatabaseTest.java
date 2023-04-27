package com.frontline.quevie.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieDatabaseTest {
    private static MovieDatabase instance = new MovieDatabase();
    private List<Movie> movies = new ArrayList<Movie>();

    @Test
    void getInstance() {
         MovieDatabase instance = new MovieDatabase();
         //instance.addMovie("Red","2020","Comedy","Speilberg",Arrays.asList());

    }

    @Test
    void addMovie() {
    }

    @Test
    void searchMoviesByTitle() {
    }

    @Test
    void getSearchResults() {
    }
}