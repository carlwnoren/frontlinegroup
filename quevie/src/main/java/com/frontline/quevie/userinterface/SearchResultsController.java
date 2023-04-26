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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchResultsController {
    private ObservableList<Movie> searchResults = FXCollections.observableArrayList(MovieDatabase.getInstance().getSearchResults());
    @FXML
    private ListView results;
    Movie selectedMovie;
    @FXML
    private Button backButton;
    private Stage stage;
    private Scene scene;
    private Parent root;

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
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("search-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ((Stage)backButton.getScene().getWindow()).setScene(scene);
    }

    public void onHomeButtonClick(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ((Stage)backButton.getScene().getWindow()).setScene(scene);
    }

    public void handleResultClick(MouseEvent mouseEvent) throws IOException{
        selectedMovie = (Movie)results.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("searched-movie-screen.fxml"));
        root = fxmlLoader.load();

        SearchedMovieController searchedMovieController = fxmlLoader.getController();
        searchedMovieController.loadMovie(selectedMovie);

        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

class MovieFormatCell extends ListCell<Movie> {
    private ImageView imageView = new ImageView();
    public MovieFormatCell() {    }

    @Override
    protected void updateItem(Movie item, boolean empty) {
        // calling super here is very important - don't skip this!
        super.updateItem(item, empty);
<<<<<<< Updated upstream
        setText(item == null ? "" : item.getTitle() + " (" + item.getYearMade() + ")");
=======

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
//
            setText(item.getTitle() + " (" + item.getYearMade() + ")");

        }
>>>>>>> Stashed changes
    }
}