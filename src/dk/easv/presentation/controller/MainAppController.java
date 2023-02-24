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

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;


public class MainAppController implements Initializable {

    @FXML
    private AnchorPane anchorControlFrame;

    @FXML
    private MFXButton forYouBtn;

    @FXML
    private ImageView forYou1,forYou2,forYou3;

    @FXML
    private Label forYouLabel1,forYouLabel2,forYouLabel3;

    @FXML
    private MFXButton homeBtn;

    @FXML
    private MFXButton latestBtn;

    private AppModel model;

    public List<Movie> forYouMovies;

    @FXML
    void getNewestMovies(ActionEvent event) {

    }

    @FXML
    void goesHome(ActionEvent event) {
        forYouLabel1.setText("Seven");
        forYouLabel2.setText("Django Unchained");
        forYouLabel3.setText("The Matrix");
        forYou1.setImage(new Image("covers/Seven.jpg"));
        forYou2.setImage(new Image("covers/Django_Unchained.jpg"));
        forYou3.setImage(new Image("covers/The_Matrix.jpg"));

    }

    @FXML
    void goesToLatest(ActionEvent event) {

    }


    @FXML
    private void goesToTopMovies(ActionEvent event) {
        Random random = new Random();

        forYouLabel1.setText(forYouMovies.get(random.nextInt(forYouMovies.size())).getTitle());
        forYouLabel2.setText(forYouMovies.get(random.nextInt(forYouMovies.size())).getTitle());
        forYouLabel3.setText(forYouMovies.get(random.nextInt(forYouMovies.size())).getTitle());


        Random random1 = new Random();

        // Set the folder containing the image files
        File folder = new File("resources/covers");

        // Get an array of files in the folder that have a .jpg or .jpeg extension
        File[] imageFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg"));

        if (imageFiles != null && imageFiles.length > 0) {
            // Create an array of Image objects from the file paths
            Image[] images = Arrays.stream(imageFiles)
                    .map(file -> new Image(file.toURI().toString()))
                    .toArray(Image[]::new);

            if (images.length > 0) {
                List<Integer> usedIndices = new ArrayList<>();

                // Get a random image for each ImageView and ensure that each image is shown only once
                forYou1.setImage(getRandomImage(images, usedIndices, random1));
                forYou2.setImage(getRandomImage(images, usedIndices, random1));
                forYou3.setImage(getRandomImage(images, usedIndices, random1));
            }
        }
    }

    // helper class for above
    private Image getRandomImage(Image[] images, List<Integer> usedIndices, Random random) {
        int index;
        do {
            index = random.nextInt(images.length);
        } while (usedIndices.contains(index));
        usedIndices.add(index);
        return images[index];
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setModel(AppModel model) {
        model.loadData(model.getObsLoggedInUser());

        forYouMovies= model.getObsTopMovieSeen();
        forYouMovies.sort(Comparator.comparing(Movie::getAverageRating));

        forYouLabel1.setText(forYouMovies.get(0).getTitle());
        forYouLabel2.setText(forYouMovies.get(1).getTitle());
        forYouLabel3.setText(forYouMovies.get(2).getTitle());

    }
}