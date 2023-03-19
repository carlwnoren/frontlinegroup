package com.frontline.quevie.userinterface;

import com.frontline.quevie.QuevieApplication;
import com.frontline.quevie.data.Movie;
import com.frontline.quevie.data.MovieDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchResultsController {
    //Observable list to use with ListView
    private ObservableList<Movie> searchResults = FXCollections.observableArrayList(MovieDatabase.getInstance().getSearchResults());
    @FXML
    private ListView results;
    Movie selectedMovie;
    @FXML
    private Button backButton;
    private Stage stage;
    private Scene scene;
    private Parent root;

    //Initialize method called for ListView functionality
    @FXML
    protected void initialize() {
        results.setItems(searchResults);
        results.setCellFactory(new Callback<ListView<Movie>, ListCell<Movie>>() {
            @Override public ListCell<Movie> call(ListView<Movie> list) {
                return new MovieFormatCell();
            }
        });
    }


    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        //Load next screen and switch over
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("search-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ((Stage)backButton.getScene().getWindow()).setScene(scene);
    }

    public void onHomeButtonClick(ActionEvent actionEvent) throws IOException{
        //Load home screen and switch over
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ((Stage)backButton.getScene().getWindow()).setScene(scene);
    }

    //Handle when list item is selected
    public void handleResultClick(MouseEvent mouseEvent) throws IOException{
        //Get the movie reference for the object selected
        selectedMovie = (Movie)results.getSelectionModel().getSelectedItem();
        //Load next screen
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("searched-movie-screen.fxml"));
        root = fxmlLoader.load();

        //Instantiate next screen's controller, load movie data into it.
        SearchedMovieController searchedMovieController = fxmlLoader.getController();
        searchedMovieController.loadMovie(selectedMovie);

        //Switch to next screen
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

//ListCell inner class for ListView functionality
class MovieFormatCell extends ListCell<Movie> {
    public MovieFormatCell() {    }

    @Override
    protected void updateItem(Movie item, boolean empty) {
        // calling super here is very important - don't skip this!
        super.updateItem(item, empty);
        //Display the title and year for each movie shown
        setText(item == null ? "" : item.getTitle() + " (" + item.getYearMade() + ")");
    }
}