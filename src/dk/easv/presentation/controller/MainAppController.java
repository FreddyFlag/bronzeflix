package dk.easv.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class MainAppController implements Initializable {

    @FXML
    private AnchorPane anchorControlFrame;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField txfSearch;

    @FXML
    void getNewestMovies(ActionEvent event) {

    }

    @FXML
    void searchMovies(KeyEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
