package com.frontline.quevie.userinterface;

import com.frontline.quevie.QuevieApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class QueueController {
    @FXML
    private Button homeButton;

    @FXML
    protected void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ((Stage) homeButton.getScene().getWindow()).setScene(scene);
    }
}
