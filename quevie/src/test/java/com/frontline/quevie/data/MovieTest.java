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
}