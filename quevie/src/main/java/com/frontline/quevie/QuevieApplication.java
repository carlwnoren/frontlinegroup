package com.frontline.quevie;

import com.frontline.quevie.data.MovieDatabase;
import com.frontline.quevie.data.Viewer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class QuevieApplication extends Application {
    private static Viewer viewer;

    public static Viewer getViewer() {
        return viewer;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Quevie");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {

        MovieDatabase database = MovieDatabase.getInstance();
        ArrayList<String> cast = new ArrayList<String>();
        viewer = new Viewer ("iLuvMovies99", "12345");
        cast.add("Charlize Theron");
        cast.add("Tom Hardy");
        cast.add("Nicholas Hoult");
        database.addMovie("Mad Max: Fury Road", "2015", "Action", "George Miller", cast);

        launch();
    }
}