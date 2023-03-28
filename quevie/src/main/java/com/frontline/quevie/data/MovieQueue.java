/**
 * This implements the MovieQueue, the list of movies a viewer has saved to watch later.
 */
package com.frontline.quevie.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovieQueue implements Serializable {
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

    public void saveData() { viewer.saveData(); }

    public void removeMovie(Movie movie) { queue.remove(movie); saveData();}
}

