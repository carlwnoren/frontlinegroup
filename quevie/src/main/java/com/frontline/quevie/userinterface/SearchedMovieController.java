package com.frontline.quevie.userinterface;

import com.frontline.quevie.QuevieApplication;
import com.frontline.quevie.data.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchedMovieController {
    private Movie movie;
    @FXML
    Button backButton;
    @FXML
    Button homeButton;
    @FXML
    Label titleLabel;
    @FXML
    Label yearMadeLabel;
    @FXML
    Label genreLabel;
    @FXML
    Label directorLabel;
    @FXML
    Label castLabel;
    @FXML
    Button addToQueueButton;

    public void loadMovie(Movie movie) {
        this.movie = movie;
        titleLabel.setText(movie.getTitle());
        yearMadeLabel.setText(movie.getYearMade());
        genreLabel.setText(movie.getGenre());
        directorLabel.setText(movie.getDirector());
        StringBuilder castString = new StringBuilder();
        castString.append(movie.getCast().get(0));
        for(int i = 1; i < movie.getCast().size(); i++) {
            castString.append(", " + movie.getCast().get(i));
        }
        castLabel.setText(castString.toString());
    }

    public void onAddToQueueClick(ActionEvent actionEvent) {
        QuevieApplication.getViewer().addMovieToQueue(movie);
        addToQueueButton.setText("Movie Added to Queue");
        addToQueueButton.setOnAction(null);
        for(int i = 0; i < QuevieApplication.getViewer().getQueue().getQueue().size(); i++) {
        }
        QuevieApplication.getViewer().saveData();
    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("search-results-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ((Stage)backButton.getScene().getWindow()).setScene(scene);
    }

    public void onHomeButtonClick(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ((Stage)homeButton.getScene().getWindow()).setScene(scene);
    }
}
