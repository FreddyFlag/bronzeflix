package dk.easv.presentation.controller;

import dk.easv.presentation.model.AppModel;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class MainAppController implements Initializable {

    @FXML
    private AnchorPane anchorControlFrame;

    @FXML
    private MFXButton forYou;

    @FXML
    private ImageView forYouMov1;

    @FXML
    private ImageView forYouMov2;

    @FXML
    private MFXButton test1;

    @FXML
    private MFXButton test2;

    private AppModel model;



    public void displayImage(){

    }

    @FXML
    void getNewestMovies(ActionEvent event) {

    }

    @FXML
    void searchMovies(KeyEvent event) {

    }

    @FXML
    void displayImage(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setModel(AppModel model) {
        this.model = model;

    }
}
