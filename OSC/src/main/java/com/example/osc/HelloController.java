/**
 * Sample Skeleton for 'hello-view.fxml' Controller Class
 */

package com.example.osc;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
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
import login.FileWriter;
import login.*;

public class HelloController {

    FileWriter file = new FileWriter();
    Hashtable <String, Passenger> customerMap = new Hashtable<>();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Name"
    private TextField Email; // Value injected by FXMLLoader

    @FXML // fx:id="Password"
    private PasswordField Password; // Value injected by FXMLLoader

    @FXML
    private Hyperlink signupLink;

    @FXML
    private void goToRegister() throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("register.fxml"));
        signupLink.getScene().setRoot(newRoot);
    }

//    private boolean authenticate(String email, String password) throws IOException {
//        customerMap = file.read();
//
//        // Iterate over the hash table and print the values
//        for (String key : customerMap.keySet()) {
//            String value1 = customerMap.get(key).getEmail();
//            String value2 = customerMap.get(key).getPassword();
//            if (value1.equals(email) && value2.equals(password)) {
//                Email.clear();
//                Password.clear();
//                return true;
//            }
//        }
//        return false;
//    }
    @FXML
    void Log(MouseEvent event) throws IOException {
        //TODO: Authenticate user

        // Move to destination page
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-locations.fxml")));
        signupLink.getScene().setRoot(newRoot);

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Email != null : "fx:id=\"Name\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert Password != null : "fx:id=\"Password\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}
