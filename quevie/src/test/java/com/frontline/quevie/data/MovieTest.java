package com.frontline.quevie.data;

import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void getTitle() {
        Movie movie = new Movie("Fury", "2020","Action","Alex", Arrays.asList("Jeff","Sam"));
        String title = movie.getTitle();
        assertEquals("Fury",title);
    }

    @Test
    void getYearMade() {
        Movie movie = new Movie("Fury", "2020","Action","Alex", Arrays.asList("Jeff","Sam"));
        String yearMade=movie.getYearMade();
        assertEquals("2020",yearMade);
    }

    @Test
    void getGenre() {
        Movie movie = new Movie("Fury", "2020","Action","Alex", Arrays.asList("Jeff","Sam"));
        String genre = movie.getGenre();
        assertEquals("Action",genre);
    }

    @Test
    void getDirector() {
        Movie movie = new Movie("Fury", "2020","Action","Alex", Arrays.asList("Jeff","Sam"));
        String director= movie.getDirector();
        assertEquals("Alex",director);
    }

    @Test
    void getCast() {
        Movie movie = new Movie("Fury", "2020","Action","Alex", Arrays.asList("Jeff","Sam"));
        Arrays.asList();
        assertEquals("jeff","jeff");
    }

    @Test
    void testEquals() {
    }
}