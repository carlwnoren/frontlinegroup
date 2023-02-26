package com.frontline.quevie.data;

public class Viewer {
    public Viewer(String username, String password) {
        this.username = username;
        this.password = password;
        queue = new MovieQueue(this);
    }
    private String username;
    private String password;
    private MovieQueue queue;

    public String getUsername() {
        return username;
    }

    public MovieQueue getQueue() {
        return queue;
    }

    public void addMovieToQueue(Movie movie) {
        queue.addMovie(movie);
    }
}
