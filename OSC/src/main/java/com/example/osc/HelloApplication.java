package com.example.osc;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.*;

import java.io.IOException;
import java.util.Hashtable;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Passenger passenger=new Passenger();
        passenger.setName("Ahmed");
        passenger.setCity("Cairo");
        passenger.setEmail("ahmed");
        passenger.setPaymentMethod('P');
        passenger.setPassword("Ahmed123");
        passenger.setNumber("01122232149");
        LoginHandler.getInstance().register(passenger);
        LoginHandler.getInstance().login("01122232149","Ahmed123");
    passenger.requestRide("nasr city","abbaseya","city");


        launch();
    }
}