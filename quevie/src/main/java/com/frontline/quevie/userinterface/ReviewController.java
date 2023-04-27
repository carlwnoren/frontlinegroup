package com.frontline.quevie.userinterface;

import com.frontline.quevie.QuevieApplication;
import com.frontline.quevie.data.Movie;
import com.frontline.quevie.data.Review;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ReviewController {
    private Movie movie;
    private Review review;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label titleYear;
    @FXML
    private TextField rating;
    @FXML
    private TextField reviewText;
    @FXML
    private Label reviewCharCounter;
    @FXML
    private Button saveReviewButton;
    @FXML
    private Button cancelButton;

    //Loads in the movie from the SelectedQueueMovieScreen/Controller
    public void loadReviewScreen(Movie movie, Review review) {
        this.movie = movie;
        this.titleYear.setText(movie.getTitle() + "(" + movie.getYearMade() + ")");
        //Adds character counter
        reviewCharCounter.textProperty().bind(reviewText.textProperty().length().asString("Characters: %d"));
        rating.textProperty().addListener(new ChangeListener<String>() {
            @Override//Constrains the rating to 1-5 int value, does not allow anything else to be typed in
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (t1.matches("")) {

                }else if (t1.matches("\\d*")) {
                    int value = Integer.parseInt(t1);
                    if (value > 5 || value < 1) {
                        rating.setText(s);
                    }
                } else {
                    rating.setText(s);
                }
            }
        });
        /*
        If a review already exists for this movie,
        set the rating and review to match the existing review.
         */
        if(review != null) {
            this.review = review;
            rating.setText(Integer.toString(review.getRating()));
            reviewText.setText(review.getReviewText());
        }
    }

    public void onSaveReviewButtonClick(ActionEvent actionEvent) throws IOException {
        if (review == null) { //If no review exists for this movie, create a new one
            review = new Review(movie, Integer.parseInt(rating.getText()), reviewText.getText());
            QuevieApplication.getViewer().addReview(review);
        } else { //Otherwise, update existing review
            review.setRating(Integer.parseInt(rating.getText()));
            review.setReviewText(reviewText.getText());
        }

        //Load next screen
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("selected-queue-movie-screen.fxml"));
        root = fxmlLoader.load();

        //Instantiate next screen's controller, load the movie data into it
        SelectedQueueMovieController selectedQueueMovieController = fxmlLoader.getController();
        selectedQueueMovieController.loadMovie(movie);

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //Serialize the data
        QuevieApplication.getViewer().saveData();
    }

    public void onCancelButtonClick(ActionEvent actionEvent) throws IOException {
        //Load next screen
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("selected-queue-movie-screen.fxml"));
        root = fxmlLoader.load();

        //Instantiate next screen's controller, load the movie data into it
        SelectedQueueMovieController selectedQueueMovieController = fxmlLoader.getController();
        selectedQueueMovieController.loadMovie(movie);

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
