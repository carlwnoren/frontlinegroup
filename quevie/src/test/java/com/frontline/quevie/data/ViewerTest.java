package com.frontline.quevie.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ViewerTest {
    private static Viewer viewer;
    private static MovieQueue queue;
    @BeforeAll
    static void setup (){
        viewer = new Viewer("Eden","pass");
        queue = new MovieQueue(viewer);
    }

    @Test
    void getUsername() {
    }

    @Test
    void getQueue() {
    }

    @Test
    void addMovieToQueue() {
        Movie movie = new Movie("Fury", "2020","Action","Alex", Arrays.asList("Jeff","Sam"));
        queue.addMovie(movie);
        assertEquals(1,queue.getQueue().size());
    }

    @Test
    void addReview() {
    }

    @Test
    void getReview() {
    }

    @Test
    void saveData() {
    }
}