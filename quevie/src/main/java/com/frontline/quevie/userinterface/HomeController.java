package com.frontline.quevie.userinterface;

import com.frontline.quevie.QuevieApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Button searchButton;

    @FXML
    private Button queueButton;

    @FXML
    protected void onQueueButtonClick(ActionEvent actionEvent) throws IOException {
        //Load the FXML doc for the queue screen
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("queue-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Move to the next screen

        ((Stage)queueButton.getScene().getWindow()).setScene(scene);
    }

    @FXML
    protected void onSearchButtonClick(ActionEvent actionEvent) throws IOException{
        //Load the FXML doc for the queue screen

        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("search-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Move to the next screen
        ((Stage)searchButton.getScene().getWindow()).setScene(scene);
    }
}