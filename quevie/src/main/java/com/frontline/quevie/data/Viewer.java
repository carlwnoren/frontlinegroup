/**
 * This implements a Viewer object, this application's "user."
 * This class is the root of serialization and has a list of reviews, as well as a movie queue.
 */

package com.frontline.quevie.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Viewer implements Serializable {
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

    //Returns the queue object, to get the actual list of movies, call the object's getQueue() method
    public MovieQueue getQueue() {
        return queue;
    }

    public void addMovieToQueue(Movie movie) {
        queue.addMovie(movie);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    //Returns null if no review for the given movie or the matching review
    public Review getReview(Movie movie) {
        Review currentReview;
        for (int i = 0; i < reviews.size(); i++) {
            currentReview = reviews.get(i);
            if (currentReview.getMovie().equals(movie))
                return currentReview;
        }
        return null;
    }

    /*Serializes the data. Make sure to call after each change
    to queues, reviews, or user data.
     */
    public void saveData() {
        try {
            FileOutputStream fileOut = new FileOutputStream(username + ".ser");
            ObjectOutputStream output = new ObjectOutputStream(fileOut);
            output.writeObject(this);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
