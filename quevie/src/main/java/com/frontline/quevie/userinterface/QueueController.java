package com.frontline.quevie.userinterface;

import com.frontline.quevie.QuevieApplication;
import com.frontline.quevie.data.Movie;
import com.frontline.quevie.data.MovieQueue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class QueueController {
    private ObservableList<Movie> queue;
    private ListView queueItems;
    @FXML
    private Button homeButton;

    @FXML
    protected void initialize() {
        queueItems.setItems(queue);
        queueItems.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell call(ListView listView) {
                return new QueueFormatCell();
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
