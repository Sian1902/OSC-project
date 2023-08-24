/**
 * Sample Skeleton for 'hello-view.fxml' Controller Class
 */

package com.example.osc;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import Maps.DistanceCalculator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Name"
    private TextField Name; // Value injected by FXMLLoader

    @FXML // fx:id="Password"
    private PasswordField Password; // Value injected by FXMLLoader

    @FXML
    private Hyperlink signupLink;

    @FXML
    private void goToRegister() throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("register.fxml"));
        signupLink.getScene().setRoot(newRoot);
    }
    @FXML
    void Log(MouseEvent event) {
        System.out.println(DistanceCalculator.getDistanceCalculator().calculateDistance(Name.getText(),Password.getText()));

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Name != null : "fx:id=\"Name\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert Password != null : "fx:id=\"Password\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}
