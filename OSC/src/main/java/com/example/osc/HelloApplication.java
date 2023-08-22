package com.example.osc;

import Maps.GoogleMapsAPIHelper;
import Maps.Location;
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
    public static double calculateDistance(Location location1, Location location2) {
        // Implement distance calculation using the Haversine formula or Google Maps Distance Matrix API
        // Return the calculated distance
        return 0;
    }
  /*  public static void main(String[] args) {
        String placeName1 = "Ain Shams University";
        String placeName2 = "Nasr City";

        Location location1 = GoogleMapsAPIHelper.getLocation(placeName1);
        Location location2 = GoogleMapsAPIHelper.getLocation(placeName2);

        if (location1 != null && location2 != null) {
            double distance = calculateDistance(location1, location2);
            System.out.println("Distance between " + placeName1 + " and " + placeName2 + " is: " + distance + " km");
        } else {
            System.out.println("Location information not found.");
        }
        launch();}*/
}