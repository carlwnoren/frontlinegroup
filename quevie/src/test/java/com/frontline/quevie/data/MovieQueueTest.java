package com.frontline.quevie.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        assertSame(viewer,queue.getViewer());
    }

    @Test
    void getQueue() {
    }

    @Test
    void addMovie() {
    }
}