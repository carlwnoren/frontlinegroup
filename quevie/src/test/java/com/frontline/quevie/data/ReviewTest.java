package com.frontline.quevie.data;

import org.controlsfx.control.Rating;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.frontline.quevie.QuevieApplication.getViewer;
import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {
    private static Viewer viewer;
    private static Movie movie;
    private static Rating  rating;
    private static Review review;



    @BeforeAll
    static void setup () {
        viewer = new Viewer("Eden", "pass");
        rating = new Rating(5, 3);
        movie = new Movie("Fury", "2020","Action","Alex", Arrays.asList("Jeff","Sam"));
    }

    @Test
    void getViewer() {
        Viewer viewer = new Viewer("Eden","pass");
        assertEquals("Eden",viewer);
        }


    @Test
    void getMovie() {assertSame(movie,movie);
    }

    @Test
    void getRating() {
    }

    @Test
    void getReviewText() {
    }

    @Test
    void setRating() {
    }

    @Test
    void setReviewText() {
    }
}