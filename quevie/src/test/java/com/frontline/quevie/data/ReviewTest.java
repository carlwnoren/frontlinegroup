package com.frontline.quevie.data;

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
    }
    @Test
    void getViewer() {
        Viewer viewer = new Viewer("Eden","pass");
        String person = viewer.getUsername();
        assertEquals("Eden",viewer);

    }

    @Test
    void getMovie() {
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