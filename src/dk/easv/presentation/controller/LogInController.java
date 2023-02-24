package dk.easv.presentation.controller;

import dk.easv.presentation.model.AppModel;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class LogInController implements Initializable {
    @FXML private MFXPasswordField passwordField;
    @FXML private MFXTextField userId;

    private AppModel model;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new AppModel();
    }



    public void logIn(ActionEvent actionEvent) {
        model.loadUsers();
        model.loginUserFromUsername(userId.getText());
        if(model.getObsLoggedInUser()!=null){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/dk/easv/presentation/view/MainApp.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("BronzeFlix 0.3 Beta");
                stage.show();
                MainAppController controller = loader.getController();
                controller.setModel(model);

                // Display pop-up message
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Welcome to the bronze tier of netflix without the ability to watch movies... Enjoy!");
                alert.setResizable(true);
                alert.setTitle("BronzeFlix 0.3 Beta");
                alert.setHeaderText("Welcome!");
                alert.getDialogPane().setMinWidth(400);
                alert.getDialogPane().setMinHeight(200);
                alert.show();

               // Close the dialog after 8 seconds
                PauseTransition delay = new PauseTransition(Duration.seconds(8));
                delay.setOnFinished(event -> alert.close());
                delay.play();

            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Could not load App.fxml");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong username or password");
            alert.showAndWait();
        }
    }}

