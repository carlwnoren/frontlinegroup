package com.frontline.quevie.userinterface;

import com.frontline.quevie.QuevieApplication;
import com.frontline.quevie.data.Movie;
import com.frontline.quevie.data.MovieQueue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


import java.io.IOException;

public class QueueController {
    //Setup for the ListView
    private ObservableList<Movie> queue = FXCollections.observableArrayList(QuevieApplication.getViewer().getQueue().getQueue());
    @FXML
    ListView queueItems;
    @FXML
    private Button homeButton;
    Movie selectedQueueMovie;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void initialize() {
        // Setup for the ListView
        queueItems.setItems(queue);
        queueItems.setCellFactory(new Callback<ListView<Movie>, ListCell<Movie>>() {
            @Override public ListCell<Movie> call(ListView<Movie> list) {
                return new QueueFormatCell();
            }
        });
    }

    @FXML
    protected void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        //Load home screen
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load()); //set the scene to the home screen
        scene.getStylesheets().add(QuevieApplication.class.getResource("styles.css").toExternalForm());
        //Load the home screen
        ((Stage) homeButton.getScene().getWindow()).setScene(scene);
    }

    //Navigates to the selected queue movie screen when a list item is selected
    public void handleResultClick(MouseEvent mouseEvent) throws IOException {
        //Gets the reference for the movie that was clicked on
        selectedQueueMovie = (Movie)queueItems.getSelectionModel().getSelectedItem();
        //Load the next screen
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("selected-queue-movie-screen.fxml"));
        root = fxmlLoader.load();

        //Instantiate the next screen's controller, load the selected movie into it
        SelectedQueueMovieController selectedQueueMovieController = fxmlLoader.getController();
        selectedQueueMovieController.loadMovie(selectedQueueMovie);

        //Transition to the next screen
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Sets the data for each line of the list
    class QueueFormatCell extends ListCell<Movie> {
        private Button removeButton;
        private HBox content;
        private Text movieTitle;

        public QueueFormatCell() {
            removeButton = new Button("Remove");
            removeButton.getStyleClass().add("remove-button");
            content = new HBox();
            movieTitle = new Text();
            content.getChildren().addAll(movieTitle, removeButton);
        }

        @Override
        protected void updateItem(Movie item, boolean empty) {
            // calling the superclass
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                movieTitle.setText(item.getTitle() + " (" + item.getYearMade() + ")");
                removeButton.setOnAction(event -> {
                    getListView().getItems().remove(item);
                    QuevieApplication.getViewer().getQueue().removeMovie(item);
                });
                setGraphic(content);
            }
        }
    }

    public void removeSelectedMovie() {
        if (selectedQueueMovie != null) {
            QuevieApplication.getViewer().getQueue().removeMovie(selectedQueueMovie);
            // Refresh the queue ListView
            queue.remove(selectedQueueMovie);
        }
    }

}

