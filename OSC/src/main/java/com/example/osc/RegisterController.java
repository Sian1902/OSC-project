package com.example.osc;

import input.check.Regex;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import login.FileWriter;
import login.*;

import java.io.IOException;

import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {

    FileWriter file = new FileWriter();

    @FXML
    private TextField regName;
    @FXML
    private TextField regEmail;
    @FXML
    private TextField regPassword;
    @FXML
    private TextField regNumber;
    @FXML
    private ToggleGroup togglePayment;
    @FXML
    private ChoiceBox<String> cty;



    private Regex regex=new Regex();

    @FXML
    private void submitUser() throws IOException {

        // Make sure no textfield is unfulfilled
        assert (regName !=null);
        assert (regEmail !=null);
        assert (regPassword !=null);
        assert (regNumber !=null);
        assert (togglePayment !=null);
        assert (cty !=null);

        // Create new passenger using input data
        Passenger p =new Passenger();
        p.setName(regName.getText());
        p.setEmail(regEmail.getText());
        p.setPassword(regPassword.getText());
        p.setNumber(regNumber.getText());
        p.setCity(cty.getValue().toLowerCase());
        String payment = ((RadioButton) togglePayment.getSelectedToggle()).getText();
        if (payment.equals("Paypal"))
            p.setPaymentMethod('p');
        else
            p.setPaymentMethod('c');

        //Add new customer to file


        // Clear Input textfields
        regName.clear();
        regEmail.clear();
        regPassword.clear();
        regNumber.clear();

        if(!regex.emailRegex(p.getEmail())){
            return;
        }

        if(!regex.passwordRegex(p.getPassword())){
            return;
        }
        if(!regex.phoneRegex(p.getNumber())){
            return;
        }
       LoginHandler.getInstance().register(p);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cty.getItems().addAll("Cairo","Alexandria","Giza");
    }
}
