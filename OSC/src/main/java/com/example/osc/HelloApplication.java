package com.example.osc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.LoginHandler;
import login.Passenger;

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
        Passenger passenger= new Passenger();
        passenger.setName("Ahmed");
        passenger.setNumber("01122232149");
        passenger.setEmail("Ahmed@gmail.com");
        passenger.setPassword("Ahmed_2003");
        passenger.setPaymentMethod(2000);
        LoginHandler.getInstance().register(passenger);
        LoginHandler.getInstance().login("01122232149","Ahmed_2003");
        LoginHandler.getInstance().logOut();
        launch();}
}