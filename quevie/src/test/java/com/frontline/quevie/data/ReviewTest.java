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


    @BeforeAll
    static void setup () {
        viewer = new Viewer("Eden", "pass");
        movie = new Movie("Fury", "2020","Action","Alex", Arrays.asList("Jeff","Sam"));
        Review review = new Review(movie, 5, "Pretty Good");
    }

    @Test
    void getViewer() {
        }


    @Test
    void getMovie(){
    }

    @Test
    void getRating() {assertEquals(3,3);
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