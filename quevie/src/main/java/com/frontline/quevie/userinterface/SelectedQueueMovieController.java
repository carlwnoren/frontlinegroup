package com.frontline.quevie.userinterface;

import com.frontline.quevie.QuevieApplication;
import com.frontline.quevie.data.Movie;
import com.frontline.quevie.data.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectedQueueMovieController {
    private Movie movie;
    private Review review;
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
    private Button reviewButton;
    private Stage stage;
    private Scene scene;
    private Parent root;

    //Load movie from previous screen
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
        //Load review from the user for this movie
        this.review = QuevieApplication.getViewer().getReview(movie);
        //If review exists in user for this movie, change text of the button
        if (review != null) {
            reviewButton.setText("Edit Review");
        }
    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        //Load and transition to queue screen
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("queue-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ((Stage)backButton.getScene().getWindow()).setScene(scene);
    }

    public void onHomeButtonClick(ActionEvent actionEvent) throws IOException{
        //Load and transition to home screen
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ((Stage)homeButton.getScene().getWindow()).setScene(scene);
    }

    public void onReviewClick(ActionEvent actionEvent) throws IOException {
        //Load Review Screen doc
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("review-screen.fxml"));
        root = fxmlLoader.load();

        //Instantiate review screen's controller and load movie and review data into the next screen
        ReviewController reviewController = fxmlLoader.getController();
        reviewController.loadReviewScreen(movie, review);

        //Transition to review screen
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
