/**
 * This implements a Review object, tied to a viewer and movie, that
 * keeps the rating and review text set by the viewer.
 */
package com.frontline.quevie.data;

import com.frontline.quevie.QuevieApplication;

import java.io.Serializable;

public class Review implements Serializable {
    public Review(Movie movie, int rating, String reviewText) {
        this.movie = movie;
        this.rating = rating;
        this.reviewText = reviewText;
        this.viewer = QuevieApplication.getViewer();
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
