/**
 * Sample Skeleton for 'hello-view.fxml' Controller Class
 */

package com.example.osc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
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
    void Log(MouseEvent event) {
        System.out.println(Name.getText());
        System.out.println(Password.getText());

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Name != null : "fx:id=\"Name\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert Password != null : "fx:id=\"Password\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}
