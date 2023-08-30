package com.example.osc;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import login.FileWriter;

public class StartPage {
    private FileWriter file=new FileWriter();
    private Label rideIconLabel,carIconLabel,requestLabelStart;
    TextField pickUpLoc,destination;
    Button logInButton, signUpButton, requestNowButton,scheduleButton;
    private Image uberPic;
    private ImageView uberPicView;
    Pane startPane;

    Pane getStartPane() {
        logInButton = new Button("Log In");
        logInButton.setLayoutX(1235);
        logInButton.setLayoutY(15);
        logInButton.setPrefWidth(100);
        logInButton.setPrefHeight(40);
        logInButton.setStyle("-fx-background-color: transparent;" +
                "-fx-text-fill: white; " +
                "-fx-border-radius: 20px;" +
                "-fx-font-size: 18px;");
        logInButton.setOnMouseEntered(event -> {
            logInButton.setStyle("-fx-background-color: #333333;" +
                    "-fx-text-fill: white; " +
                    "-fx-border-color: #333333;" +
                    "-fx-background-radius: 50px;" +
                    "-fx-border-radius: 50px;" +
                    "-fx-border-color: black;" +
                    "-fx-font-size: 18px;");
        });
        logInButton.setOnMouseExited(event -> {
            logInButton.setStyle("-fx-background-color: transparent;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-radius: 20px; " +
                    "-fx-font-size: 18px;");
        });

        signUpButton = new Button("Sign Up");
        signUpButton.setLayoutX(1350);
        signUpButton.setLayoutY(15);
        signUpButton.setPrefWidth(100);
        signUpButton.setPrefHeight(40);
        signUpButton.setStyle("-fx-background-color: white;" +
                "-fx-text-fill: black;" +
                "-fx-background-radius: 50px;" +
                "-fx-border-radius: 50px;" +
                "-fx-font-size: 18px;");
        signUpButton.setOnMouseEntered(event -> {
            signUpButton.setStyle("-fx-background-color: #e2e2e2;" +
                    "-fx-text-fill: black;" +
                    "-fx-background-radius: 50px;" +
                    "-fx-border-radius: 50px;" +
                    "-fx-font-size: 18px;");
        });
        signUpButton.setOnMouseExited(event -> {
            signUpButton.setStyle("-fx-background-color: white;" +
                    "-fx-text-fill: black;" +
                    "-fx-background-radius: 50px;" +
                    "-fx-border-radius: 50px;" +
                    "-fx-font-size: 18px;");
        });

        uberPic = new Image(getClass().getResourceAsStream("/media/uberpic.jpg"));
        uberPicView = new ImageView(uberPic);
        uberPicView.setLayoutX(0);
        uberPicView.setLayoutY(70);
        uberPicView.setFitWidth(1600);
        uberPicView.setFitHeight(900);

        requestLabelStart = new Label();
        requestLabelStart.setText("Request a ride now");
        requestLabelStart.setLayoutX(50);
        requestLabelStart.setLayoutY(220);
        requestLabelStart.setPrefWidth(650);
        requestLabelStart.setPrefHeight(500);
        requestLabelStart.setPadding(new Insets(0, 0, 350, 55));
        requestLabelStart.setStyle("-fx-background-color: white;" +
                "-fx-font-size: 58px;" +
                "-fx-text-fill:black;" +
                "-fx-border-color: transparent transparent transparent transparent;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-radius: 10px;");

        rideIconLabel = new Label("Ride");
        rideIconLabel.setFont(new Font("Verdana", 20));
        rideIconLabel.setLayoutX(50);
        rideIconLabel.setLayoutY(150);
        rideIconLabel.setPrefWidth(650);
        rideIconLabel.setPrefHeight(100);
        rideIconLabel.setPadding(new Insets(30, 0, 0, 290));
        rideIconLabel.setStyle("-fx-background-color: #fbfcfb;" +
                "-fx-font-size: 25px;" +
                "-fx-text-fill: black;" +
                "-fx-padding-top: 25px;" +
                "-fx-border-color: transparent transparent #e3e3e3 transparent;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-radius: 10px;");

        carIconLabel = new Label();
        carIconLabel.setLayoutX(343);
        carIconLabel.setLayoutY(155);
        carIconLabel.setPrefWidth(38);
        carIconLabel.setPrefHeight(37);
        carIconLabel.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/media/caricon.png"))));

        pickUpLoc = new TextField();
        pickUpLoc.setPromptText("Enter Pickup Location");
        pickUpLoc.setLayoutX(100);
        pickUpLoc.setLayoutY(400);
        pickUpLoc.setPrefWidth(520);
        pickUpLoc.setPrefHeight(60);
        pickUpLoc.setPadding(new Insets(0, 0, 0, 50));
        pickUpLoc.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-color: transparent transparent transparent transparent;");

        destination = new TextField();
        destination.setPromptText("Destination");
        destination.setLayoutX(100);
        destination.setLayoutY(480);
        destination.setPrefWidth(520);
        destination.setPrefHeight(60);
        destination.setPadding(new Insets(0, 0, 0, 50));
        destination.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-color: transparent transparent transparent transparent;");

        requestNowButton = new Button("Request Now");
        requestNowButton.setLayoutX(100);
        requestNowButton.setLayoutY(600);
        requestNowButton.setPrefHeight(60);
        requestNowButton.setPrefWidth(180);
        requestNowButton.setStyle("-fx-background-color: black;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-radius: 10px;");
        requestNowButton.setOnMouseEntered(event -> {
            requestNowButton.setStyle("-fx-background-color: #333333;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 20px;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;");
        });
        requestNowButton.setOnMouseExited(event -> {
            requestNowButton.setStyle("-fx-background-color: black;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 20px;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;");
        });


        scheduleButton = new Button("Schedule for Later");
        scheduleButton.setLayoutX(300);
        scheduleButton.setLayoutY(600);
        scheduleButton.setPrefHeight(60);
        scheduleButton.setPrefWidth(220);
        scheduleButton.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-text-fill: black;" +
                "-fx-font-size: 20px;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-radius: 10px;");
        scheduleButton.setOnMouseEntered(event -> {
            scheduleButton.setStyle("-fx-background-color: #e2e2e2;" +
                    "-fx-text-fill: black;" +
                    "-fx-font-size: 20px;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;");
        });
        scheduleButton.setOnMouseExited(event -> {
            scheduleButton.setStyle("-fx-background-color: #eeeeee;" +
                    "-fx-text-fill: black;" +
                    "-fx-font-size: 20px;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;");
        });


        pickUpLoc.setOnAction(event -> destination.requestFocus());

        startPane = new Pane();
        startPane.getChildren().addAll(logInButton, signUpButton, uberPicView, requestLabelStart, rideIconLabel, carIconLabel, pickUpLoc, destination, requestNowButton, scheduleButton);

        return startPane;
    }
}

