package com.frontline.quevie.data;

import java.util.ArrayList;
import java.util.List;

public class Viewer {
    public Viewer(String username, String password) {
        this.username = username;
        this.password = password;
        queue = new MovieQueue(this);
        reviews = new ArrayList<Review>();
    }
    private String username;
    private String password;
    private MovieQueue queue;

    private List<Review> reviews;

    public String getUsername() {
        return username;
    }

    public MovieQueue getQueue() {
        return queue;
    }

    public void addMovieToQueue(Movie movie) {
        queue.addMovie(movie);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public Review getReview(Movie movie) {
        Review currentReview;
        for (int i = 0; i < reviews.size(); i++) {
            currentReview = reviews.get(i);
            if (currentReview.getMovie().equals(movie))
                return currentReview;
        }
        return null;
    }
}
