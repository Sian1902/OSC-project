package com.example.osc;

import app.Ride;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import login.LoginHandler;

public class Ride_Reguest {

    private Label requestLabel,enjoyLabel,carTypeLabel,distanceLabel,priceLabel;
    Label enterDataRide;
    TextField pickupRide,destinationRide;
    Button search,feedback,userDropList,button1,button2,button3,acceptButton,
            closeRideDetails,cancelRideDetails;
    private Image car;
    private ImageView carView;
    Pane ridePane,rideDetailsPane;
    private Scene rideDetailsScene;
    private Stage rideDetailsStage;
    ListView<Button> list;
    ComboBox<String> rideType;
    Pane getRequestRidePane(){

        requestLabel=new Label();
        requestLabel.setText("Get a ride");
        requestLabel.setLayoutX(50);
        requestLabel.setLayoutY(120);
        requestLabel.setPrefHeight(320);
        requestLabel.setPrefWidth(400);
        requestLabel.setWrapText(true);
        requestLabel.setPadding(new Insets(0, 0, 230, 20));
        requestLabel.setStyle("-fx-background-color: white;"+
                "-fx-font-size: 25px;"+
                "-fx-font-weight: bold;"+
                "-fx-text-fill: black;"+
                "-fx-border-color: grey;"+
                "-fx-background-radius: 20px;" +
                "-fx-border-radius: 20px;");

        pickupRide=new TextField();
        pickupRide.setPromptText("Add a pickup location");
        pickupRide.setLayoutY(190);
        pickupRide.setLayoutX(70);
        pickupRide.setPrefWidth(350);
        pickupRide.setPrefHeight(50);
        pickupRide.setFocusTraversable(false);
        pickupRide.setPadding(new Insets(0, 0, 0, 25));
        pickupRide.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;");

        destinationRide=new TextField();
        destinationRide.setPromptText("Enter you destination");
        destinationRide.setLayoutX(70);
        destinationRide.setLayoutY(255);
        destinationRide.setPrefHeight(50);
        destinationRide.setPrefWidth(350);
        destinationRide.setFocusTraversable(false);
        destinationRide.setPadding(new Insets(0, 0, 0, 25));
        destinationRide.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;");

        search=new Button();
        search.setText("Search");
        search.setLayoutX(70);
        search.setLayoutY(380);
        search.setPrefWidth(350);
        search.setPrefHeight(50);
        search.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;");
        search.setOnMouseEntered(event -> {
            search.setStyle("-fx-background-color: black;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-radius: 10px;"+
                    "-fx-background-radius: 10px;");
        });
        search.setOnMouseExited(event -> {
            search.setStyle("-fx-background-color: #eeeeee;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: black;" +
                    "-fx-border-radius: 10px;"+
                    "-fx-background-radius: 10px;");
        });

        enterDataRide=new Label();
        enterDataRide.setText("Please fill in all required data");
        enterDataRide.setLayoutX(100);
        enterDataRide.setLayoutY(440); // Adjusted Y position
        enterDataRide.setPrefHeight(55);
        enterDataRide.setPrefWidth(370);
        enterDataRide.setStyle("-fx-background-color: transparent;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: red;");

        Image map=new Image(getClass().getResourceAsStream("/media/map.png"));
        ImageView mapView = new ImageView(map);
        mapView.setLayoutX(500);
        mapView.setLayoutY(120);
        mapView.setFitWidth(1000);
        mapView.setFitHeight(700);

        feedback = new Button("Feedback");
        feedback.setLayoutX(1180);
        feedback.setLayoutY(15);
        feedback.setPrefWidth(150);
        feedback.setPrefHeight(40);
        feedback.setStyle("-fx-background-color: black;" +
                "-fx-text-fill: white; " +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 50px;" +
                "-fx-font-size: 18px;");
        feedback.setOnMouseEntered(event -> {
            feedback.setStyle("-fx-background-color: #eeeeee;" +
                    "-fx-text-fill: black; " +
                    "-fx-border-radius: 20px; " +
                    "-fx-background-radius: 50px;" +
                    "-fx-border-color: black;" +
                    "-fx-font-size: 18px;");
        });
        feedback.setOnMouseExited(event -> {
            feedback.setStyle("-fx-background-color: black;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-radius: 20px; " +
                    "-fx-background-radius: 50px;" +
                    "-fx-font-size: 18px;");
        });

        userDropList = new Button();
        userDropList.setText("user name");
        userDropList.setLayoutX(1350);
        userDropList.setLayoutY(15);
        userDropList.setPrefWidth(130);
        userDropList.setPrefHeight(40);
        userDropList.setStyle("-fx-background-color: black;" +
                "-fx-text-fill: white; " +
                "-fx-border-radius: 20px; " +
                "-fx-background-radius: 50px;" +
                "-fx-font-size: 18px;");
        userDropList.setOnMouseEntered(event -> {
            userDropList.setStyle("-fx-background-color: #eeeeee;" +
                    "-fx-text-fill: black; " +
                    "-fx-border-radius: 20px; " +
                    "-fx-background-radius: 50px;" +
                    "-fx-border-color: black;" +
                    "-fx-font-size: 18px;");
        });
        userDropList.setOnMouseExited(event -> {
            userDropList.setStyle("-fx-background-color: black;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-radius: 20px; " +
                    "-fx-background-radius: 50px;" +
                    "-fx-font-size: 18px;");
        });

        button1=new Button("My trips");
        button1.setPrefWidth(180);
        button1.setAlignment(Pos.BASELINE_LEFT);
        button1.setStyle("-fx-background-color:transparent;-fx-font-size: 18px;-fx-background-radius: 20px ;");
        button1.setOnMouseEntered(event -> {
            button1.setStyle("-fx-background-color:#f6f6f6;-fx-font-size: 20px;-fx-background-radius: 20px ;");
        });
        button1.setOnMouseExited(event -> {
            button1.setStyle("-fx-background-color:transparent;-fx-font-size: 18px;-fx-background-radius: 20px ;");
        });

        button2=new Button("Manage account");
        button2.setPrefWidth(180);
        button2.setAlignment(Pos.BASELINE_LEFT);
        button2.setStyle("-fx-background-color:transparent;-fx-font-size: 18px;-fx-background-radius: 20px ;");
        button2.setOnMouseEntered(event -> {
            button2.setStyle("-fx-background-color:#f6f6f6;-fx-font-size: 20px;-fx-background-radius: 20px ;");
        });
        button2.setOnMouseExited(event -> {
            button2.setStyle("-fx-background-color:transparent;-fx-font-size: 18px;-fx-background-radius: 20px ;");
        });

        button3=new Button("Settings");
        button3.setPrefWidth(180);
        button3.setAlignment(Pos.BASELINE_LEFT);
        button3.setStyle("-fx-background-color:transparent;-fx-font-size: 18px;-fx-background-radius: 20px ;");
        button3.setOnMouseEntered(event -> {
            button3.setStyle("-fx-background-color:#f6f6f6;-fx-font-size: 20px;-fx-background-radius: 20px ;");
        });
        button3.setOnMouseExited(event -> {
            button3.setStyle("-fx-background-color:transparent;"+
                    "-fx-font-size: 18px;"+
                    "-fx-background-radius: 20px ;");
        });


        list=new ListView();
        list.getItems().addAll(button1,button2,button3);
        list.setPrefWidth(200);
        list.setPrefHeight(150);
        list.setLayoutX(1330);
        list.setLayoutY(70);
        list.setStyle("-fx-background-color: #eeeeee;"+
                "-fx-control-inner-background: transparent;"+
                "-fx-background-radius: 20px ;");
        list.setVisible(false);

        pickupRide.setOnAction(event -> destinationRide.requestFocus());

        ridePane=new Pane();
        rideType = new ComboBox<>();
        rideType.getItems().addAll("Normal", "Premium", "Scooter", "Between Cities");
        rideType.setValue("Normal");
        rideType.setLayoutX(70);
        rideType.setLayoutY(320);
        rideType.setPrefWidth(350);
        rideType.setPrefHeight(50);
        rideType.setStyle("-fx-font-size: 20px;" +
                "-fx-background-color: #eeeeee;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;" +
                "-fx-background-radius: 10px;");

        ridePane.getChildren().addAll(
                requestLabel, pickupRide, destinationRide, search, mapView,
                enterDataRide, feedback, userDropList, list, rideType
        );

        return ridePane;
    }
    void openRideDetailsWindow(Ride ride){
        enjoyLabel=new Label();
        enjoyLabel.setText("Enjoy your ride!");
        enjoyLabel.setPadding(new Insets(0, 0, 200, -40));
        enjoyLabel.setPrefWidth(380);
        enjoyLabel.setPrefHeight(300);
        enjoyLabel.setLayoutX(160);
        enjoyLabel.setStyle("-fx-font-size: 40px;"+
                "-fx-font-weight: bold;");

        carTypeLabel=new Label();
        carTypeLabel.setText("Car type:");
        carTypeLabel.setStyle("-fx-font-size:20px;");
        carTypeLabel.setLayoutX(40);
        carTypeLabel.setLayoutY(100);

        distanceLabel=new Label();
        distanceLabel.setText("Distance: "+ride.getDistance());
        distanceLabel.setLayoutX(40);
        distanceLabel.setLayoutY(140);
        distanceLabel.setStyle("-fx-font-size: 20px;");

        priceLabel=new Label();
        priceLabel.setText("Price: "+ride.getPrice());
        priceLabel.setPrefWidth(180);
        priceLabel.setPrefHeight(40);
        priceLabel.setLayoutX(40);
        priceLabel.setLayoutY(170);
        priceLabel.setStyle("-fx-font-size: 20px;");

        car=new Image(getClass().getResourceAsStream("/media/car.jpg"));
        carView=new ImageView(car);
        carView.setLayoutY(110);
        carView.setLayoutX(410);


        acceptButton=new Button();
        acceptButton.setText("Accept");
        acceptButton.setPrefWidth(180);
        acceptButton.setPrefHeight(40);
        acceptButton.setLayoutX(70);
        acceptButton.setLayoutY(230);
        acceptButton.setStyle("-fx-background-color: black;"+
                "-fx-text-fill: white;"+
                "-fx-font-size: 20px;"+
                "-fx-background-radius: 20px;"+
                "-fx-border-radius: 20px;");
        acceptButton.setOnMouseEntered(event -> {
            acceptButton.setStyle("-fx-background-color: #eeeeee;"+
                    "-fx-text-fill: black;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-border-color: black;"+
                    "-fx-border-radius: 20px;");
        });
        acceptButton.setOnMouseExited(event -> {
            acceptButton.setStyle("-fx-background-color: black;"+
                    "-fx-text-fill: white;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-border-radius: 20px;");
        });


        cancelRideDetails=new Button();
        cancelRideDetails.setText("Cancel");
        cancelRideDetails.setPrefWidth(180);
        cancelRideDetails.setPrefHeight(40);
        cancelRideDetails.setLayoutX(280);
        cancelRideDetails.setLayoutY(230);
        cancelRideDetails.setStyle("-fx-background-color: black;"+
                "-fx-text-fill: white;"+
                "-fx-font-size: 20px;"+
                "-fx-background-radius: 20px;"+
                "-fx-border-radius: 20px;");
        cancelRideDetails.setOnMouseEntered(event -> {
            cancelRideDetails.setStyle("-fx-background-color: #eeeeee;"+
                    "-fx-text-fill: black;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-border-color: black;"+
                    "-fx-border-radius: 20px;");
        });
        cancelRideDetails.setOnMouseExited(event -> {
            cancelRideDetails.setStyle("-fx-background-color: black;"+
                    "-fx-text-fill: white;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-border-radius: 20px;");
        });

        closeRideDetails=new Button();
        closeRideDetails.setText("X");
        closeRideDetails.setPrefWidth(50);
        closeRideDetails.setPrefHeight(50);
        closeRideDetails.setLayoutX(470);
        closeRideDetails.setLayoutY(20);
        closeRideDetails.setStyle("-fx-background-color: transparent;"+
                "-fx-font-size: 20px;"+
                "-fx-text-fill: black;");
        closeRideDetails.setOnMouseEntered(event -> {
            closeRideDetails.setStyle("-fx-background-color: #eeeeee;"+
                    "-fx-text-fill: black;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 50px;"+
                    "-fx-border-radius: 50px;");
        });
        closeRideDetails.setOnMouseExited(event -> {
            closeRideDetails.setStyle("-fx-background-color: transparent;"+
                    "-fx-font-size: 20px;"+
                    "-fx-text-fill: black;");
        });

        closeRideDetails.setOnAction(event->{
            rideDetailsStage.close();
        });
        cancelRideDetails.setOnAction(event->{
            rideDetailsStage.close();
        });

        acceptButton.setOnAction(event->{
            LoginHandler.getInstance().getPassenger().addRide(ride);
            rideDetailsStage.close();
        });

        rideDetailsPane=new Pane();
        rideDetailsPane.getChildren().addAll(enjoyLabel,carView,carTypeLabel,distanceLabel,priceLabel,
                closeRideDetails,acceptButton,cancelRideDetails);
        rideDetailsScene = new Scene(rideDetailsPane);

        // Cast the BorderPane object to a Region object.
        Region root = (Region) rideDetailsScene.getRoot();

        // Set the border radius of the Region object to 10px.
        root.setStyle("-fx-background-radius: 50px;"+
                "-fx-border-radius: 50px;"+
                "-fx-border-color: grey;"+
                "-fx-background-color: white;");

        rideDetailsScene.setFill(Color.TRANSPARENT);

        rideDetailsStage=new Stage();
        rideDetailsStage.initStyle(StageStyle.TRANSPARENT);
        rideDetailsStage.setX(500);
        rideDetailsStage.setY(250);
        rideDetailsStage.setScene(rideDetailsScene);
        rideDetailsStage.show();
    }
}