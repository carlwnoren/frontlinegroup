package com.frontline.quevie.data;

public class Review {
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
}
