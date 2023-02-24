package com.frontline.quevie.data;

import java.util.ArrayList;
import java.util.List;

public class MovieQueue {
    public MovieQueue(Viewer viewer) {
        this.viewer = viewer;
        this.queue = new ArrayList<Movie>();
    }
    private Viewer viewer;
    private List<Movie> queue;

    public Viewer getViewer() {
        return viewer;
    }

    public List<Movie> getQueue() {
        return queue;
    }

    public void addMovie(Movie movie) {
        queue.add(movie);
    }
}
