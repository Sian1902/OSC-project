package com.example.osc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class General_Options {
    LoginHandler loginHandler;
    private Label myTripLabel,noTripLabel,authorizedLabel,location,language,egypt,english,warningLabel,warningDescription;
    Label enterPassword,savingStatus;
    TextField nameEdit,mailEdit,numberEdit;
    TextArea feedbackText;
    PasswordField passwordEdit,currentPassword;
    Button rideNow,myTrips,manageAccount,profileSettings,rideNow2,myTrips2,manageAccount2,profileSettings2,rideNow3,myTrips3,
            manageAccount3,profileSettings3,logOut,deleteAccount,sendFeedback,backFeedback,
            editData,saveEdit,yesDeleteButton,cancelDeletion,closeWarning,closeEnteringPass,cancelEnteringPass,editContinue;
    CheckBox yesDeleteCheckbox;
    private Image feedbackIcon,user;
    private ImageView feedbackIconView,userView;
    ComboBox<String> paymentMethodEdit,cityEdit;
    Pane  myTripsPane,manageAccountPane,profileSettingsPane,feedbackPane,deleteWarningPane,enterPassPane;
    private Scene deleteWarningScene,enterPassScene;
    private Stage deleteWarningStage,enterPassStage;
    Pane getFeedbackPane(){
        feedbackIcon=new Image(getClass().getResourceAsStream("/media/feedbackicon.jpg"));
        feedbackIconView=new ImageView(feedbackIcon);
        feedbackIconView.setFitWidth(70);
        feedbackIconView.setFitHeight(70);
        feedbackIconView.setLayoutX(750);
        feedbackIconView.setLayoutY(130);

        feedbackText=new TextArea();
        feedbackText.setPromptText("Enter your feedback");
        feedbackText.setLayoutX(450);
        feedbackText.setLayoutY(240);
        feedbackText.setPrefHeight(350);
        feedbackText.setPrefColumnCount(35);
        feedbackText.setPadding(new Insets(20, 20, 20, 20));
        feedbackText.setStyle("-fx-background-color: #eeeeee;"+
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 30px;"+
                "-fx-background-radius: 30px;");

        sendFeedback=new Button();
        sendFeedback.setText("Send feedback");
        sendFeedback.setPrefWidth(200);
        sendFeedback.setPrefHeight(40);
        sendFeedback.setLayoutX(930);
        sendFeedback.setLayoutY(630);
        sendFeedback.setStyle("-fx-background-color: black;" +
                "-fx-text-fill: white; " +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 50px;" +
                "-fx-font-size: 18px;");
        sendFeedback.setOnMouseEntered(event -> {
            sendFeedback.setStyle("-fx-background-color: #eeeeee;" +
                    "-fx-text-fill: black; " +
                    "-fx-border-radius: 20px; " +
                    "-fx-background-radius: 50px;" +
                    "-fx-border-color: black;" +
                    "-fx-font-size: 18px;");
        });
        sendFeedback.setOnMouseExited(event -> {
            sendFeedback.setStyle("-fx-background-color: black;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-radius: 20px; " +
                    "-fx-background-radius: 50px;" +
                    "-fx-font-size: 18px;");
        });
        backFeedback=new Button();
        backFeedback.setText("");
        backFeedback.setText(" ◀ ");
        backFeedback.setLayoutX(20);
        backFeedback.setLayoutY(85);
        backFeedback.setStyle("-fx-background-color: black;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 30px;"+
                "-fx-text-fill: white;"+
                "-fx-border-radius: 50px;"+
                "-fx-background-radius: 50px;");

        feedbackPane=new Pane();
        feedbackPane.getChildren().addAll(backFeedback,feedbackIconView,feedbackText,sendFeedback);
        return feedbackPane;
    }
    Pane getMyTripsPane(){
        rideNow=new Button();
        rideNow.setLayoutX(0);
        rideNow.setLayoutY(120);
        rideNow.setPrefWidth(250);
        rideNow.setPrefHeight(50);
        rideNow.setText("Ride now");
        rideNow.setAlignment(Pos.BASELINE_LEFT);
        rideNow.setPadding(new Insets(0, 0, 0, 30));
        rideNow.setStyle("-fx-background-color: white;" +
                "-fx-font-size: 20px;"+
                "-fx-text-fill: black;");
        rideNow.setOnMouseEntered(event -> {
            rideNow.setStyle("-fx-background-color: #f6f6f6;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: black;");
        });
        rideNow.setOnMouseExited(event -> {
            rideNow.setStyle("-fx-background-color: white;" +
                    "-fx-font-size: 20px;"+
                    "-fx-text-fill: black;");
        });

        myTrips=new Button();
        myTrips.setLayoutX(0);
        myTrips.setLayoutY(170);
        myTrips.setPrefWidth(250);
        myTrips.setPrefHeight(50);
        myTrips.setText("My trips");
        myTrips.setAlignment(Pos.BASELINE_LEFT);
        myTrips.setPadding(new Insets(0, 0, 0, 30));

        manageAccount=new Button();
        manageAccount.setLayoutX(0);
        manageAccount.setLayoutY(220);
        manageAccount.setPrefWidth(250);
        manageAccount.setPrefHeight(50);
        manageAccount.setText("Manage account");
        manageAccount.setAlignment(Pos.BASELINE_LEFT);
        manageAccount.setPadding(new Insets(0, 0, 0, 30));

        profileSettings=new Button();
        profileSettings.setLayoutX(0);
        profileSettings.setLayoutY(270);
        profileSettings.setPrefWidth(250);
        profileSettings.setPrefHeight(50);
        profileSettings.setText("Profile settings");
        profileSettings.setAlignment(Pos.BASELINE_LEFT);
        profileSettings.setPadding(new Insets(0, 0, 0, 30));

        myTrips.setStyle("-fx-background-color: #ebebee;" +
                "-fx-font-size: 20px;"+
                "-fx-border-width: 3px;"+
                "-fx-border-color: transparent transparent transparent black;"+
                "-fx-text-fill: black;");

        manageAccount.setStyle("-fx-background-color: white;" +
                "-fx-font-size: 20px;"+
                "-fx-text-fill: black;");
        manageAccount.setOnMouseEntered(event -> {
            manageAccount.setStyle("-fx-background-color: #f6f6f6;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: black;");
        });
        manageAccount.setOnMouseExited(event -> {
            manageAccount.setStyle("-fx-background-color: white;" +
                    "-fx-font-size: 20px;"+
                    "-fx-text-fill: black;");
        });
        profileSettings.setStyle("-fx-background-color: white;" +
                "-fx-font-size: 20px;"+
                "-fx-text-fill: black;");
        profileSettings.setOnMouseEntered(event -> {
            profileSettings.setStyle("-fx-background-color: #f6f6f6;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: black;");
        });
        profileSettings.setOnMouseExited(event -> {
            profileSettings.setStyle("-fx-background-color: white;" +
                    "-fx-font-size: 20px;"+
                    "-fx-text-fill: black;");
        });

        myTripLabel=new Label();
        myTripLabel.setText("My trips");
        myTripLabel.setLayoutX(280);
        myTripLabel.setLayoutY(120);
        myTripLabel.setStyle("-fx-background-color: transparent;"+
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;");
        if(true){
            noTripLabel=new Label();
            noTripLabel.setText("Looks like you haven't taken a trip yet.");
            noTripLabel.setLayoutX(380);
            noTripLabel.setLayoutY(230);
            noTripLabel.setStyle("-fx-background-color: transparent;"+
                    "-fx-font-size: 25px;" +
                    "-fx-font-weight: bold;");
        }
        else{
            // Trips code Here
        }
        myTripsPane=new Pane();
        myTripsPane.getChildren().addAll(rideNow,myTrips,manageAccount,profileSettings,myTripLabel,noTripLabel);
        return myTripsPane;
    }
    Pane getManageAccountPane(){

        rideNow2=new Button();
        rideNow2.setLayoutX(0);
        rideNow2.setLayoutY(120);
        rideNow2.setPrefWidth(250);
        rideNow2.setPrefHeight(50);
        rideNow2.setText("Ride now");
        rideNow2.setAlignment(Pos.BASELINE_LEFT);
        rideNow2.setPadding(new Insets(0, 0, 0, 30));
        rideNow2.setStyle("-fx-background-color: white;" +
                "-fx-font-size: 20px;"+
                "-fx-text-fill: black;");
        rideNow2.setOnMouseEntered(event -> {
            rideNow2.setStyle("-fx-background-color: #f6f6f6;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: black;");
        });
        rideNow2.setOnMouseExited(event -> {
            rideNow2.setStyle("-fx-background-color: white;" +
                    "-fx-font-size: 20px;"+
                    "-fx-text-fill: black;");
        });

        myTrips2=new Button();
        myTrips2.setLayoutX(0);
        myTrips2.setLayoutY(170);
        myTrips2.setPrefWidth(250);
        myTrips2.setPrefHeight(50);
        myTrips2.setText("My trips");
        myTrips2.setAlignment(Pos.BASELINE_LEFT);
        myTrips2.setPadding(new Insets(0, 0, 0, 30));

        manageAccount2=new Button();
        manageAccount2.setLayoutX(0);
        manageAccount2.setLayoutY(220);
        manageAccount2.setPrefWidth(250);
        manageAccount2.setPrefHeight(50);
        manageAccount2.setText("Manage account");
        manageAccount2.setAlignment(Pos.BASELINE_LEFT);
        manageAccount2.setPadding(new Insets(0, 0, 0, 30));

        profileSettings2=new Button();
        profileSettings2.setLayoutX(0);
        profileSettings2.setLayoutY(270);
        profileSettings2.setPrefWidth(250);
        profileSettings2.setPrefHeight(50);
        profileSettings2.setText("Profile settings");
        profileSettings2.setAlignment(Pos.BASELINE_LEFT);
        profileSettings2.setPadding(new Insets(0, 0, 0, 30));

        myTrips2.setStyle("-fx-background-color: white;" +
                "-fx-font-size: 20px;"+
                "-fx-text-fill: black;");
        myTrips2.setOnMouseEntered(event -> {
            myTrips2.setStyle("-fx-background-color: #f6f6f6;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: black;");
        });
        myTrips2.setOnMouseExited(event -> {
            myTrips2.setStyle("-fx-background-color: white;" +
                    "-fx-font-size: 20px;"+
                    "-fx-text-fill: black;");
        });
        manageAccount2.setStyle("-fx-background-color: #ebebee;" +
                "-fx-font-size: 20px;"+
                "-fx-border-width: 3px;"+
                "-fx-border-color: transparent transparent transparent black;"+
                "-fx-text-fill: black;");

        profileSettings2.setStyle("-fx-background-color: white;" +
                "-fx-font-size: 20px;"+
                "-fx-text-fill: black;");
        profileSettings2.setOnMouseEntered(event -> {
            profileSettings2.setStyle("-fx-background-color: #f6f6f6;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: black;");
        });
        profileSettings2.setOnMouseExited(event -> {
            profileSettings2.setStyle("-fx-background-color: white;" +
                    "-fx-font-size: 20px;"+
                    "-fx-text-fill: black;");
        });

        user=new Image(getClass().getResourceAsStream("/media/user.jpg"));
        userView=new ImageView(user);
        userView.setLayoutX(320);
        userView.setLayoutY(100);

        nameEdit=new TextField();
        nameEdit.setText("name");
        nameEdit.setLayoutX(280);
        nameEdit.setLayoutY(220);
        nameEdit.setPrefWidth(600);
        nameEdit.setPrefHeight(50);
        nameEdit.setAlignment(Pos.BASELINE_LEFT);
        nameEdit.setPadding(new Insets(0, 0, 8, 30));
        nameEdit.setStyle("-fx-background-color: #eeeeee;"+
                "-fx-font-size: 25px;" +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 20px;");

        mailEdit=new TextField();
        mailEdit.setText("mail");
        mailEdit.setLayoutX(280);
        mailEdit.setLayoutY(290);
        mailEdit.setPrefWidth(600);
        mailEdit.setPrefHeight(50);
        mailEdit.setAlignment(Pos.BASELINE_LEFT);
        mailEdit.setPadding(new Insets(0, 0, 8, 30));
        mailEdit.setStyle("-fx-background-color: #eeeeee;"+
                "-fx-font-size: 25px;" +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 20px;");

        numberEdit=new TextField();
        numberEdit.setText("0123");
        numberEdit.setLayoutX(280);
        numberEdit.setLayoutY(360);
        numberEdit.setPrefWidth(600);
        numberEdit.setPrefHeight(50);
        numberEdit.setAlignment(Pos.BASELINE_LEFT);
        numberEdit.setPadding(new Insets(0, 0, 8, 30));
        numberEdit.setStyle("-fx-background-color: #eeeeee;"+
                "-fx-font-size: 25px;" +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 20px;");

        passwordEdit=new PasswordField();
        passwordEdit.setText("password");
        passwordEdit.setLayoutX(280);
        passwordEdit.setLayoutY(430);
        passwordEdit.setPrefWidth(600);
        passwordEdit.setPrefHeight(50);
        passwordEdit.setAlignment(Pos.BASELINE_LEFT);
        passwordEdit.setPadding(new Insets(0, 0, 8, 30));
        passwordEdit.setStyle("-fx-background-color: #eeeeee;"+
                "-fx-font-size: 25px;" +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 20px;");

        cityEdit=new ComboBox<>();
        cityEdit.setValue("Cairo");
        cityEdit.getItems().addAll("--City--","Cairo","Giza","Alexandria");
        cityEdit.setLayoutX(280);
        cityEdit.setLayoutY(500);
        cityEdit.setPrefWidth(600);
        cityEdit.setPrefHeight(45);
        cityEdit.setFocusTraversable(false);
        cityEdit.setPadding(new Insets(0, 0, 0, 30));
        cityEdit.setStyle("-fx-background-color: #eeeeee;"+
                "-fx-font-size: 25px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 20px;");

        paymentMethodEdit = new ComboBox<>();
        paymentMethodEdit.getItems().addAll("--Payment method","Credit Card", "PayPal");
        paymentMethodEdit.setValue("PayPal");
        paymentMethodEdit.setPrefHeight(45);
        paymentMethodEdit.setPrefWidth(600);
        paymentMethodEdit.setLayoutX(280);
        paymentMethodEdit.setLayoutY(570);
        paymentMethodEdit.setPadding(new Insets(0, 0, 0, 30));
        paymentMethodEdit.setFocusTraversable(false);
        paymentMethodEdit.setStyle("-fx-background-color: #eeeeee;"+
                "-fx-font-size: 25px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 20px;");

        editData=new Button();
        editData.setText("Edit data");
        editData.setPrefWidth(200);
        editData.setPrefHeight(40);
        editData.setLayoutX(280);
        editData.setLayoutY(650);
        editData.setStyle("-fx-background-color: black;" +
                "-fx-text-fill: white; " +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 50px;" +
                "-fx-font-size: 18px;");
        editData.setOnMouseEntered(event -> {
            editData.setStyle("-fx-background-color: #eeeeee;" +
                    "-fx-text-fill: black; " +
                    "-fx-border-radius: 20px; " +
                    "-fx-background-radius: 50px;" +
                    "-fx-border-color: black;" +
                    "-fx-font-size: 18px;");
        });
        editData.setOnMouseExited(event -> {
            editData.setStyle("-fx-background-color: black;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-radius: 20px; " +
                    "-fx-background-radius: 50px;" +
                    "-fx-font-size: 18px;");
        });

        saveEdit=new Button();
        saveEdit.setText("Save modification");
        saveEdit.disableProperty().setValue(true);
        saveEdit.setPrefWidth(200);
        saveEdit.setPrefHeight(40);
        saveEdit.setLayoutX(500);
        saveEdit.setLayoutY(650);
        saveEdit.setStyle("-fx-background-color: black;" +
                "-fx-text-fill: white; " +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 50px;" +
                "-fx-font-size: 18px;");
        saveEdit.setOnMouseEntered(event -> {
            saveEdit.setStyle("-fx-background-color: #eeeeee;" +
                    "-fx-text-fill: black; " +
                    "-fx-border-radius: 20px; " +
                    "-fx-background-radius: 50px;" +
                    "-fx-border-color: black;" +
                    "-fx-font-size: 18px;");
        });
        saveEdit.setOnMouseExited(event -> {
            saveEdit.setStyle("-fx-background-color: black;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-radius: 20px; " +
                    "-fx-background-radius: 50px;" +
                    "-fx-font-size: 18px;");
        });
        savingStatus=new Label();
        savingStatus.setText("Data saved successfully");
        savingStatus.setLayoutX(280);
        savingStatus.setLayoutY(690);
        savingStatus.setPrefHeight(55);
        savingStatus.setPrefWidth(370);
        savingStatus.setStyle("-fx-background-color: transparent;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: red;");

        manageAccountPane=new Pane();
        manageAccountPane.getChildren().addAll(rideNow2,myTrips2,manageAccount2,profileSettings2,userView,nameEdit,
                mailEdit,numberEdit,passwordEdit,paymentMethodEdit,cityEdit,editData,saveEdit,savingStatus);
        return manageAccountPane;
    }
    Pane getProfileSettingsPane(){
        rideNow3=new Button();
        rideNow3.setLayoutX(0);
        rideNow3.setLayoutY(120);
        rideNow3.setPrefWidth(250);
        rideNow3.setPrefHeight(50);
        rideNow3.setText("Ride now");
        rideNow3.setAlignment(Pos.BASELINE_LEFT);
        rideNow3.setPadding(new Insets(0, 0, 0, 30));
        rideNow3.setStyle("-fx-background-color: white;" +
                "-fx-font-size: 20px;"+
                "-fx-text-fill: black;");
        rideNow3.setOnMouseEntered(event -> {
            rideNow3.setStyle("-fx-background-color: #f6f6f6;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: black;");
        });
        rideNow3.setOnMouseExited(event -> {
            rideNow3.setStyle("-fx-background-color: white;" +
                    "-fx-font-size: 20px;"+
                    "-fx-text-fill: black;");
        });

        myTrips3=new Button();
        myTrips3.setLayoutX(0);
        myTrips3.setLayoutY(170);
        myTrips3.setPrefWidth(250);
        myTrips3.setPrefHeight(50);
        myTrips3.setText("My trips");
        myTrips3.setAlignment(Pos.BASELINE_LEFT);
        myTrips3.setPadding(new Insets(0, 0, 0, 30));

        manageAccount3=new Button();
        manageAccount3.setLayoutX(0);
        manageAccount3.setLayoutY(220);
        manageAccount3.setPrefWidth(250);
        manageAccount3.setPrefHeight(50);
        manageAccount3.setText("Manage account");
        manageAccount3.setAlignment(Pos.BASELINE_LEFT);
        manageAccount3.setPadding(new Insets(0, 0, 0, 30));

        profileSettings3=new Button();
        profileSettings3.setLayoutX(0);
        profileSettings3.setLayoutY(270);
        profileSettings3.setPrefWidth(250);
        profileSettings3.setPrefHeight(50);
        profileSettings3.setText("Profile settings");
        profileSettings3.setAlignment(Pos.BASELINE_LEFT);
        profileSettings3.setPadding(new Insets(0, 0, 0, 30));

        myTrips3.setStyle("-fx-background-color: white;" +
                "-fx-font-size: 20px;"+
                "-fx-text-fill: black;");
        myTrips3.setOnMouseEntered(event -> {
            myTrips3.setStyle("-fx-background-color: #f6f6f6;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: black;");
        });
        myTrips3.setOnMouseExited(event -> {
            myTrips3.setStyle("-fx-background-color: white;" +
                    "-fx-font-size: 20px;"+
                    "-fx-text-fill: black;");
        });
        manageAccount3.setStyle("-fx-background-color: white;" +
                "-fx-font-size: 20px;"+
                "-fx-text-fill: black;");
        manageAccount3.setOnMouseEntered(event -> {
            manageAccount3.setStyle("-fx-background-color: #f6f6f6;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: black;");
        });
        manageAccount3.setOnMouseExited(event -> {
            manageAccount3.setStyle("-fx-background-color: white;" +
                    "-fx-font-size: 20px;"+
                    "-fx-text-fill: black;");
        });
        profileSettings3.setStyle("-fx-background-color: #ebebee;" +
                "-fx-font-size: 20px;"+
                "-fx-border-width: 3px;"+
                "-fx-border-color: transparent transparent transparent black;"+
                "-fx-text-fill: black;");


        location=new Label();
        location.setText("Location");
        location.setLayoutX(280);
        location.setLayoutY(110);
        location.setStyle("-fx-background-color: transparent;"+
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;");

        egypt=new Label();
        egypt.setText("Egypt");
        egypt.setLayoutX(280);
        egypt.setLayoutY(160);
        egypt.setPrefWidth(600);
        egypt.setPrefHeight(50);
        egypt.setAlignment(Pos.BASELINE_LEFT);
        egypt.setPadding(new Insets(0, 0, 0, 30));
        egypt.setStyle("-fx-background-color: #eeeeee;"+
                "-fx-font-size: 25px;" +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 20px;");

        language=new Label();
        language.setText("Language");
        language.setLayoutX(280);
        language.setLayoutY(250);
        language.setStyle("-fx-background-color: transparent;"+
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;");

        english=new Label();
        english.setText("English");
        english.setLayoutX(280);
        english.setLayoutY(300);
        english.setPrefWidth(600);
        english.setPrefHeight(50);
        english.setAlignment(Pos.BASELINE_LEFT);
        english.setPadding(new Insets(0, 0, 0, 30));
        english.setStyle("-fx-background-color: #eeeeee;"+
                "-fx-font-size: 25px;" +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 20px;");

        authorizedLabel=new Label();
        authorizedLabel.setText("Authorized applications\n" +
                "You do not have any authorized applications");
        authorizedLabel.setLayoutX(280);
        authorizedLabel.setLayoutY(420);
        authorizedLabel.setPrefWidth(1000);
        authorizedLabel.setAlignment(Pos.BASELINE_LEFT);
        authorizedLabel.setPadding(new Insets(30, 0, 0, 0));
        authorizedLabel.setStyle("-fx-background-color: transparent;"+
                "-fx-font-size: 25px;" +
                "-fx-border-color: grey transparent transparent transparent;");

        logOut=new Button();
        logOut.setText("Logout");
        logOut.setLayoutX(280);
        logOut.setLayoutY(550);
        logOut.setStyle("-fx-background-color: #eeeeee;"+
                "-fx-font-size: 19px;" +
                "-fx-text-fill: red;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: transparent;" +
                "-fx-background-radius: 20px;");
        logOut.setOnMouseEntered(event -> {
            logOut.setStyle("-fx-background-color: #e2e2e2;" +
                    "-fx-font-size: 19px;" +
                    "-fx-text-fill: red;" +
                    "-fx-border-radius: 20px;" +
                    "-fx-border-color: transparent;" +
                    "-fx-background-radius: 20px;");
        });
        logOut.setOnMouseExited(event -> {
            logOut.setStyle("-fx-background-color: #eeeeee;" +
                    "-fx-font-size: 19px;" +
                    "-fx-text-fill: red;" +
                    "-fx-border-radius: 20px;" +
                    "-fx-border-color: transparent;" +
                    "-fx-background-radius: 20px;");
        });

        deleteAccount=new Button();
        deleteAccount.setText("Delete account");
        deleteAccount.setLayoutX(500);
        deleteAccount.setLayoutY(550);
        deleteAccount.setStyle("-fx-background-color: #eeeeee;"+
                "-fx-font-size: 19px;" +
                "-fx-text-fill: red;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: transparent;" +
                "-fx-background-radius: 20px;");
        deleteAccount.setOnMouseEntered(event -> {
            deleteAccount.setStyle("-fx-background-color: #e2e2e2;" +
                    "-fx-font-size: 19px;" +
                    "-fx-text-fill: red;" +
                    "-fx-border-radius: 20px;" +
                    "-fx-border-color: transparent;" +
                    "-fx-background-radius: 20px;");
        });
        deleteAccount.setOnMouseExited(event -> {
            deleteAccount.setStyle("-fx-background-color: #eeeeee;" +
                    "-fx-font-size: 19px;" +
                    "-fx-text-fill: red;" +
                    "-fx-border-radius: 20px;" +
                    "-fx-border-color: transparent;" +
                    "-fx-background-radius: 20px;");
        });
        yesDeleteCheckbox=new CheckBox();
        yesDeleteCheckbox.setStyle("-fx-opacity: 0");

        profileSettingsPane=new Pane();
        profileSettingsPane.getChildren().addAll(rideNow3,myTrips3,manageAccount3,profileSettings3,location,egypt,language,english,authorizedLabel,logOut,deleteAccount,yesDeleteCheckbox);
        return profileSettingsPane;
    }
    void openDeletionWarning(){
        warningDescription=new Label();
        warningDescription.setText("You will not be able to recover your account.\n"+
                "Are you sure you want to delete your account?");
        warningDescription.setPadding(new Insets(0, 40, 0, 40));
        warningDescription.setWrapText(true);
        warningDescription.setPrefWidth(500);
        warningDescription.setPrefHeight(250);
        warningDescription.setLayoutX(0);
        warningDescription.setLayoutY(0);
        warningDescription.setStyle("-fx-font-size: 20px;");

        warningLabel=new Label();
        warningLabel.setText("WARNING!");
        warningLabel.setStyle("-fx-text-fill: red;-fx-font-size:30px;");
        warningLabel.setLayoutX(160);
        warningLabel.setLayoutY(30);

        yesDeleteButton=new Button();
        yesDeleteButton.setText("Yes, Delete");
        yesDeleteButton.setPrefWidth(180);
        yesDeleteButton.setPrefHeight(40);
        yesDeleteButton.setLayoutX(50);
        yesDeleteButton.setLayoutY(180);
        yesDeleteButton.setStyle("-fx-background-color: black;"+
                "-fx-text-fill: white;"+
                "-fx-font-size: 20px;"+
                "-fx-background-radius: 20px;"+
                "-fx-border-radius: 20px;");
        yesDeleteButton.setOnMouseEntered(event -> {
            yesDeleteButton.setStyle("-fx-background-color: #eeeeee;"+
                    "-fx-text-fill: black;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-font-size: 20px;"+
                    "-fx-border-color: black;"+
                    "-fx-border-radius: 20px;");
        });
        yesDeleteButton.setOnMouseExited(event -> {
            yesDeleteButton.setStyle("-fx-background-color: black;"+
                    "-fx-text-fill: white;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-border-radius: 20px;");
        });

        cancelDeletion=new Button();
        cancelDeletion.setText("Cancel");
        cancelDeletion.setPrefWidth(180);
        cancelDeletion.setPrefHeight(40);
        cancelDeletion.setLayoutX(250);
        cancelDeletion.setLayoutY(180);
        cancelDeletion.setStyle("-fx-background-color: black;"+
                "-fx-text-fill: white;"+
                "-fx-font-size: 20px;"+
                "-fx-background-radius: 20px;"+
                "-fx-border-radius: 20px;");
        cancelDeletion.setOnMouseEntered(event -> {
            cancelDeletion.setStyle("-fx-background-color: #eeeeee;"+
                    "-fx-text-fill: black;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-border-color: black;"+
                    "-fx-border-radius: 20px;");
        });
        cancelDeletion.setOnMouseExited(event -> {
            cancelDeletion.setStyle("-fx-background-color: black;"+
                    "-fx-text-fill: white;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-border-radius: 20px;");
        });

        closeWarning=new Button();
        closeWarning.setText("X");
        closeWarning.setPrefWidth(50);
        closeWarning.setPrefHeight(50);
        closeWarning.setLayoutX(400);
        closeWarning.setLayoutY(20);
        closeWarning.setStyle("-fx-background-color: transparent;"+
                "-fx-font-size: 20px;"+
                "-fx-text-fill: black;");
        closeWarning.setOnMouseEntered(event -> {
            closeWarning.setStyle("-fx-background-color: #eeeeee;"+
                    "-fx-text-fill: black;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 50px;"+
                    "-fx-border-radius: 50px;");
        });
        closeWarning.setOnMouseExited(event -> {
            closeWarning.setStyle("-fx-background-color: transparent;"+
                    "-fx-font-size: 20px;"+
                    "-fx-text-fill: black;");
        });

        deleteWarningStage=new Stage();

        cancelDeletion.setOnAction(event->{
            deleteWarningStage.close();
        });
        closeWarning.setOnAction(event->{
            deleteWarningStage.close();
        });
        yesDeleteButton.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                deleteWarningStage.close();
                yesDeleteCheckbox.setSelected(true);
                LoginHandler.getInstance().deleteUser();

            }

        }

        );

        deleteWarningPane=new Pane();
        deleteWarningPane.getChildren().addAll(warningLabel,warningDescription,yesDeleteButton,cancelDeletion,closeWarning);
        deleteWarningScene = new Scene(deleteWarningPane);

        // Cast the BorderPane object to a Region object.
        Region root = (Region) deleteWarningScene.getRoot();

        // Set the border radius of the Region object to 10px.
        root.setStyle("-fx-background-radius: 50px;"+
                "-fx-border-radius: 50px;"+
                "-fx-border-color: red;"+
                "-fx-border-width: 2px;"+
                "-fx-background-color: white;");
        deleteWarningScene.setFill(Color.TRANSPARENT);


        deleteWarningStage.initStyle(StageStyle.TRANSPARENT);
        deleteWarningStage.setX(500);
        deleteWarningStage.setY(250);

        deleteWarningStage.setScene(deleteWarningScene);

        // Show the Stage object.
        deleteWarningStage.show();
    }
    void openEnteringPasswordWindow(){
        enterPassword=new Label();
        enterPassword.setText("Enter your password!");
        enterPassword.setPadding(new Insets(0, 0, 150, 90));
        enterPassword.setWrapText(true);
        enterPassword.setPrefWidth(485);
        enterPassword.setPrefHeight(250);
        enterPassword.setLayoutX(0);
        enterPassword.setLayoutY(0);
        enterPassword.setStyle("-fx-font-size: 30px;");

        currentPassword=new PasswordField();
        currentPassword.setPromptText("password");
        currentPassword.setLayoutX(50);
        currentPassword.setLayoutY(100);
        currentPassword.setPrefHeight(50);
        currentPassword.setPrefWidth(380);
        currentPassword.setFocusTraversable(false);
        currentPassword.setPadding(new Insets(0, 0, 0, 25));
        currentPassword.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;");

        editContinue=new Button();
        editContinue.setText("Continue");
        editContinue.setPrefWidth(180);
        editContinue.setPrefHeight(40);
        editContinue.setLayoutX(50);
        editContinue.setLayoutY(180);
        editContinue.setStyle("-fx-background-color: black;"+
                "-fx-text-fill: white;"+
                "-fx-font-size: 20px;"+
                "-fx-background-radius: 20px;"+
                "-fx-border-radius: 20px;");
        editContinue.setOnMouseEntered(event -> {
            editContinue.setStyle("-fx-background-color: #eeeeee;"+
                    "-fx-text-fill: black;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-font-size: 20px;"+
                    "-fx-border-color: black;"+
                    "-fx-border-radius: 20px;");
        });
        editContinue.setOnMouseExited(event -> {
            editContinue.setStyle("-fx-background-color: black;"+
                    "-fx-text-fill: white;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-border-radius: 20px;");
        });

        cancelEnteringPass=new Button();
        cancelEnteringPass.setText("Cancel");
        cancelEnteringPass.setPrefWidth(180);
        cancelEnteringPass.setPrefHeight(40);
        cancelEnteringPass.setLayoutX(250);
        cancelEnteringPass.setLayoutY(180);
        cancelEnteringPass.setStyle("-fx-background-color: black;"+
                "-fx-text-fill: white;"+
                "-fx-font-size: 20px;"+
                "-fx-background-radius: 20px;"+
                "-fx-border-radius: 20px;");
        cancelEnteringPass.setOnMouseEntered(event -> {
            cancelEnteringPass.setStyle("-fx-background-color: #eeeeee;"+
                    "-fx-text-fill: black;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-border-color: black;"+
                    "-fx-border-radius: 20px;");
        });
        cancelEnteringPass.setOnMouseExited(event -> {
            cancelEnteringPass.setStyle("-fx-background-color: black;"+
                    "-fx-text-fill: white;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-border-radius: 20px;");
        });

        closeEnteringPass=new Button();
        closeEnteringPass.setText("X");
        closeEnteringPass.setPrefWidth(50);
        closeEnteringPass.setPrefHeight(50);
        closeEnteringPass.setLayoutX(400);
        closeEnteringPass.setLayoutY(20);
        closeEnteringPass.setStyle("-fx-background-color: transparent;"+
                "-fx-font-size: 20px;"+
                "-fx-text-fill: black;");
        closeEnteringPass.setOnMouseEntered(event -> {
            closeEnteringPass.setStyle("-fx-background-color: #eeeeee;"+
                    "-fx-text-fill: black;"+
                    "-fx-font-size: 20px;"+
                    "-fx-background-radius: 50px;"+
                    "-fx-border-radius: 50px;");
        });
        closeEnteringPass.setOnMouseExited(event -> {
            closeEnteringPass.setStyle("-fx-background-color: transparent;"+
                    "-fx-font-size: 20px;"+
                    "-fx-text-fill: black;");
        });

        enterPassStage=new Stage();

        cancelEnteringPass.setOnAction(event->{
            enterPassStage.close();
        });
        closeEnteringPass.setOnAction(event->{
            enterPassStage.close();
        });
        editContinue.setOnAction(event->{
            if(currentPassword.getText().isEmpty()){
                enterPassword.setStyle("-fx-font-size: 30px;-fx-text-fill: red;");
                enterPassword.setText("Enter your password!");
                enterPassword.setPadding(new Insets(0, 0, 150, 90));
            } else if (!LoginHandler.getInstance().getPassenger().getPassword().equals(currentPassword.getText())) {
                enterPassword.setText("Wrong Password!");
                enterPassword.setPadding(new Insets(0, 0, 150, 130));
                enterPassword.setStyle("-fx-font-size: 30px;-fx-text-fill: red;");
            } else{
                nameEdit.setEditable(true);
                mailEdit.setEditable(true);
                passwordEdit.setEditable(true);
                paymentMethodEdit.disableProperty().setValue(false);
                cityEdit.disableProperty().setValue(false);
                saveEdit.disableProperty().setValue(false);
                enterPassStage.close();
                // code
            }
        });

        enterPassPane=new Pane();
        enterPassPane.getChildren().addAll(enterPassword,currentPassword,editContinue,cancelEnteringPass,closeEnteringPass);
        enterPassScene = new Scene(enterPassPane);

        // Cast the BorderPane object to a Region object.
        Region root = (Region) enterPassScene.getRoot();

        // Set the border radius of the Region object to 10px.
        root.setStyle("-fx-background-radius: 50px;"+
                "-fx-border-radius: 50px;"+
                "-fx-border-color: red;"+
                "-fx-border-width: 2px;"+
                "-fx-background-color: white;");
        enterPassScene.setFill(Color.TRANSPARENT);


        enterPassStage.initStyle(StageStyle.TRANSPARENT);
        enterPassStage.setX(500);
        enterPassStage.setY(250);

        enterPassStage.setScene(enterPassScene);

        // Show the Stage object.
        enterPassStage.show();
    }

}