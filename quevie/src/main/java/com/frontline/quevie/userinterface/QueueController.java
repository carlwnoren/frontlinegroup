package com.frontline.quevie.userinterface;

import com.frontline.quevie.QuevieApplication;
import com.frontline.quevie.data.Movie;
import com.frontline.quevie.data.MovieQueue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class QueueController {
    private ObservableList<Movie> queue = FXCollections.observableArrayList(QuevieApplication.getViewer().getQueue().getQueue());
    @FXML
    ListView queueItems;
    @FXML
    private Button homeButton;

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
