package com.frontline.quevie.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MovieQueueTest {
    private static Viewer viewer;
    private static MovieQueue queue;
    @BeforeAll
    static void setup (){
        viewer = new Viewer("Eden","pass");
        queue = new MovieQueue(viewer);
    }

    @Test
    void getViewer() {
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
//need some help with this one
    void saveDataToQueue() {

        Movie movie = new Movie("Fury", "2020","Action","Alex", Arrays.asList("Jeff","Sam"));
    }

    @Test
    void removeMovieFromQueue() {
        Movie movie = new Movie("Fury","2020","Action","Alex",Arrays.asList("Jeff","Sam"));
        queue.removeMovie(movie);
        assertEquals(0,queue.getQueue().size());
    }
}