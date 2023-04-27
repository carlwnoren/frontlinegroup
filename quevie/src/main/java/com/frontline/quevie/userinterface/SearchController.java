package com.frontline.quevie.userinterface;

import com.frontline.quevie.QuevieApplication;
import com.frontline.quevie.data.Movie;
import com.frontline.quevie.data.MovieDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SearchController {
    @FXML
    private Button homeButton;
    @FXML
    private Button performSearchButton;
    @FXML
    private TextField titleSearch;

    @FXML
    protected void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        //Load then transition to next screen
        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ((Stage) homeButton.getScene().getWindow()).setScene(scene);


    }

    public void onPerformSearchClick(ActionEvent actionEvent) throws IOException{
        //Get the text field info, search the database with that
        MovieDatabase.getInstance().searchMoviesByTitle(titleSearch.getText());

        //Load then transition to next screen

        FXMLLoader fxmlLoader = new FXMLLoader(QuevieApplication.class.getResource("search-results-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ((Stage)performSearchButton.getScene().getWindow()).setScene(scene);
    }


}
