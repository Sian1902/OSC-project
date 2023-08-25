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
import input.check.Regex;
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

    private Regex regex=new Regex();
    @FXML
    private void goToRegister() throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("register.fxml"));
        signupLink.getScene().setRoot(newRoot);
    }


    @FXML
    void Log(MouseEvent event) throws IOException {
        System.out.println(LoginHandler.getInstance().login(Email.getText(), Password.getText()));
        if(!regex.phoneRegex(Email.getText())){
            System.out.println("wrong phone format");
            return;
        }
        if(!regex.passwordRegex(Password.getText())){
            System.out.println("wrong password format");

            return;
        }
        if (LoginHandler.getInstance().login(Email.getText(),Password.getText())!=null) {
            //TODO: Move to next screen
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        // when screen loads, copy customers into hashtable from file
        try {
            LoginHandler.getInstance().setCustomerMap(file.read());
        } catch (IOException e) {
            System.out.println(e.getMessage() + ": No Data in file Yet");
        }

        assert Email != null : "fx:id=\"Name\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert Password != null : "fx:id=\"Password\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}
