package dk.easv.presentation.controller;

import dk.easv.entities.Movie;
import dk.easv.presentation.model.AppModel;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;


public class MainAppController implements Initializable {

    @FXML
    private AnchorPane anchorControlFrame;

    @FXML
    private MFXButton forYou;

    @FXML
    private ImageView forYou1,forYou2,forYou3;

    @FXML
    private Label forYouLabel1,forYouLabel2,forYouLabel3;

    @FXML
    private MFXButton test1;

    @FXML
    private MFXButton test2;

    private AppModel model;

    private List<Movie> forYouMovies;



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
        model.loadData(model.getObsLoggedInUser());

        forYouMovies= model.getObsTopMovieNotSeen();
        forYouMovies.sort(Comparator.comparing(Movie::getAverageRating));

        forYouLabel1.setText("Seven");
        forYouLabel2.setText("Django Unchained");
        forYouLabel3.setText("The Matrix");


    }
}
