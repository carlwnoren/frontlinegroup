package com.frontline.quevie;

import com.frontline.quevie.data.MovieDatabase;
import com.frontline.quevie.data.Viewer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class QuevieApplication extends Application {

    private static Viewer viewer;

    public static Viewer getViewer() {
        return viewer;
    }

    //Load initial screen setup
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240); //initial screen size set here
        stage.setTitle("Quevie");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        //Set up the database
        MovieDatabase database = MovieDatabase.getInstance();
        //Set the viewer
        viewer = new Viewer ("iLuvMovies99", "12345");
        //Load/deserialize viewer data, if it exists.
        if (new File(viewer.getUsername() + ".ser").isFile()) {
            try {
                FileInputStream fileIn = new FileInputStream(viewer.getUsername() + ".ser");
                ObjectInputStream input = new ObjectInputStream(fileIn);
                viewer = (Viewer) input.readObject();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
        }
        //Set up dummy movies.
        ArrayList<String> cast = new ArrayList<String>();
        cast.add("Charlize Theron");
        cast.add("Tom Hardy");
        cast.add("Nicholas Hoult");
        database.addMovie("Mad Max: Fury Road", "2015", "Action", "George Miller", cast);
        cast = new ArrayList<String>();
        cast.add("Shia LaBeouf");
        cast.add("Brad Pitt");
        cast.add("Jon Bernthal");
        database.addMovie("Fury", "2014", "Action", "David Ayer", cast);

        launch();
    }
}