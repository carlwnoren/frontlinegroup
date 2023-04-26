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
        database.addMovie("/covers/MadMaxCover.jpg", "Mad Max", "2015", "Action", "George Miller", cast);

<<<<<<< Updated upstream
=======
//        MovieDatabase database2 = MovieDatabase.getInstance();
        ArrayList<String> cast2 = new ArrayList<String>();
        cast2.add("Marlon Brando");
        cast2.add("Al Pacino");
        cast2.add("James Caan");
        database.addMovie("/covers/TheGodfatherCover.jpg", "The Godfather", "1972", "Crime/Drama", "Warren Clymer", cast2);

        ArrayList<String> cast3 = new ArrayList<>();
        cast3.add("Quentin Tarantino");
        cast3.add("Uma Thurman");
        cast3.add("Bruce Willis");
        database.addMovie("/covers/PulpFictionCover.jpg", "Pulp Fiction","1994","Crime/Drama","Quentin Tarantino",cast3);

        ArrayList<String> cast4 = new ArrayList<>();
        cast4.add("Will Arnett");
        cast4.add("Patton Oswalt");
        cast4.add("Lou Romano");
        database.addMovie("/covers/RatatouilleCover.jpg", "Ratatouille","2007","Family/Comedy","Brad Bird",cast4);

>>>>>>> Stashed changes
        launch();
    }
}