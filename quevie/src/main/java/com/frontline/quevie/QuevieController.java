package com.frontline.quevie;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class QuevieController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}