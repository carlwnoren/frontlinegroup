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

import java.io.IOException;

public class QueueController {
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
        queueItems.setItems(queue);
        queueItems.setCellFactory(new Callback<ListView<Movie>, ListCell<Movie>>() {
            @Override public ListCell<Movie> call(ListView<Movie> list) {
                return new MovieFormatCell();
            }
        });
    }
    @FXML
    protected void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ((Stage) homeButton.getScene().getWindow()).setScene(scene);
    }

    public void handleResultClick(MouseEvent mouseEvent) throws IOException {
        selectedQueueMovie = (Movie)queueItems.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("selected-queue-movie-screen.fxml"));
        root = fxmlLoader.load();

        SelectedQueueMovieController selectedQueueMovieController = fxmlLoader.getController();
        selectedQueueMovieController.loadMovie(selectedQueueMovie);

        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    class QueueFormatCell extends ListCell<Movie> {
        public QueueFormatCell() {   }

        @Override
        protected void updateItem(Movie item, boolean empty) {
            //calling super
            super.updateItem(item, empty);
            setText(item == null ? "" : item.getTitle() + " (" + item.getYearMade() + ")");
        }
    }
}
