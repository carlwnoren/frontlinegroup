package com.frontline.quevie.userinterface;

import com.frontline.quevie.QuevieApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeScreen {
    @FXML
    private Button searchButton = new Button();

    @FXML
    private Button queueButton = new Button();

    @FXML
    protected void onQueueButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("queue-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 420);

        ((Stage)queueButton.getScene().getWindow()).getScene();
    }

    @FXML
    protected void onSearchButtonClick(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("search-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 420);

        ((Stage)searchButton.getScene().getWindow()).getScene();
    }
}