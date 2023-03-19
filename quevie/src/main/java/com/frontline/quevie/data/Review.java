package com.frontline.quevie.data;

import java.io.Serializable;

public class Review implements Serializable {
    public Review(Movie movie, int rating, String reviewText) {
        this.movie = movie;
        this.rating = rating;
        this.reviewText = reviewText;
    }
    private Viewer viewer;
    private Movie movie;
    private int rating;
    private String reviewText;

    public Viewer getViewer() {
        return viewer;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReviewText(String text) {
        reviewText = text;
    }
}
