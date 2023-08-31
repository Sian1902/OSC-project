package com.example.osc;


import app.Ride;
import app.SupportTickets;
import input.check.Regex;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import login.FileWriter;
import login.LoginHandler;
import login.Passenger;

import java.io.IOException;
import java.time.LocalTime;

public class Main extends Application {
    Log_Reg logReg=new Log_Reg();
    Ride_Reguest rideReguest=new Ride_Reguest();
    General_Options generalOptions=new General_Options();
    StartPage startPage=new StartPage();
    Label uberLabel;
    Pane splashPane,uber;
    private Scene uberScene;
    Passenger passenger;

    public Passenger getPassenger() {
        return passenger;
    }

    @Override
    public void start(Stage uberStage){

        // Load the logo image
        Image logoImage = new Image(getClass().getResourceAsStream("/media/ubersplashscreen.png"));

        // Create an ImageView to display the Splash logo image
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(1350);
        logoImageView.setFitHeight(629);
        logoImageView.setLayoutX(75);
        logoImageView.setLayoutY(130);

        // Create a fade transition
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1500), logoImageView);
        fadeTransition.setFromValue(1.0);

        // When Splash screen transition finished
        fadeTransition.setOnFinished(event ->{

            // Main Uber Label
            uberLabel = new Label("Uber");
            uberLabel.setPrefWidth(1600);
            uberLabel.setPrefHeight(70);
            uberLabel.setPadding(new Insets(0, 0, 0, 50));
            uberLabel.setLayoutX(0);
            uberLabel.setLayoutY(0);

            uber=new Pane();
            uber.setStyle("-fx-background-color: white;");
            uber.getChildren().addAll(uberLabel,startPage.getStartPane(),logReg.getLogInPane(),logReg.getSignUpPane(),
                    rideReguest.getRequestRidePane(),generalOptions.getFeedbackPane(),generalOptions.getMyTripsPane(),
                    generalOptions.getManageAccountPane(),generalOptions.getProfileSettingsPane());

            visibility();
            logRegConnection();
            rideRequestPageConnection();
            leftSideOptionsConnection();
            generalOptionsConnection();

            uberScene = new Scene(uber);
            uberScene.addEventHandler(MouseEvent.MOUSE_CLICKED, event2 -> {
                // Make the label visible
                rideReguest.list.setVisible(false);
            });
            uberScene.setFill(Color.WHITE);
            uberStage.setScene(uberScene);
        });

        // Play the fade transition
        fadeTransition.play();

        // set uber icon
        Image icon=new Image(getClass().getResourceAsStream("/media/logouber.png"));
        uberStage.getIcons().add(icon);

        // To hide Task bar & Title bar -- to set size maximized
        uberStage.initStyle(StageStyle.TRANSPARENT);
        uberStage.setMaximized(true);

        // Set the splash scene to the stage.
        splashPane=new Pane();
        splashPane.getChildren().add(logoImageView);
        Scene splashScene = new Scene(splashPane);
        splashScene.setFill(Color.BLACK);
        uberStage.setScene(splashScene);
        uberStage.show();
        uberStage.setOnCloseRequest(event -> {
// Close the stage.
            Platform.exit();
        });

    }
    void showPane(boolean showStart,boolean showLogIn,boolean showSignUp,boolean showRideRequest) {
        startPage.startPane.setVisible(showStart);
        logReg. logInPane.setVisible(showLogIn);
        logReg. signUpPane.setVisible(showSignUp);
        rideReguest.ridePane.setVisible(showRideRequest);

        logReg.ifPhrase.setLayoutY(395);
        logReg.signUpInLog.setLayoutY(395);
        logReg.enterDataLog.setVisible(false);
        logReg.enterDataReg.setVisible(false);
        rideReguest.enterDataRide.setVisible(false);
        rideReguest.list.setVisible(false);

        startPage.pickUpLoc.clear();
        startPage.destination.clear();
        logReg.phoneNumberLog.clear();
        logReg.passwordLog.clear();
        logReg.regNumber.clear();
        logReg.regPassword.clear();
        logReg.regName.clear();
        logReg.regMail.clear();
        logReg.city.getSelectionModel().selectFirst();
        logReg.paymentMethod.getSelectionModel().selectFirst();
        rideReguest.pickupRide.clear();
        rideReguest.destinationRide.clear();
        generalOptions.feedbackText.clear();

        generalOptions.nameEdit.setEditable(false);
        generalOptions.mailEdit.setEditable(false);
        generalOptions.numberEdit.setEditable(false);
        generalOptions.passwordEdit.setEditable(false);
        generalOptions.cityEdit.setEditable(false);
        generalOptions.paymentMethodEdit.disableProperty().setValue(true);
        generalOptions.saveEdit.disableProperty().setValue(false);

        uberLabel.setStyle("-fx-background-color: black;" +
                "-fx-text-fill: white; " +
                "-fx-font-size: 40px;");

        showPane2(false,false,false,false);
    }
    void showPane2(boolean showMyTrips,boolean showManageAccount, boolean showProfileSettings,boolean showFeedback){
        generalOptions.myTripsPane.setVisible(showMyTrips);
        generalOptions.manageAccountPane.setVisible(showManageAccount);
        generalOptions.profileSettingsPane.setVisible(showProfileSettings);
        generalOptions.feedbackPane.setVisible(showFeedback);
    }
    private void visibility()  {
        // Start Page
        showPane(true,false,false,false);
        logReg.backButtonL.setOnAction(event -> showPane(true,false,false,false));
        logReg.backButtonR.setOnAction(event -> showPane(true,false,false,false));

        // Log In Page
        startPage.logInButton.setOnAction(event -> showPane(false,true,false,false));
        startPage.requestNowButton.setOnAction(event -> showPane(false,true,false,false));
        startPage.scheduleButton.setOnAction(event -> showPane(false,true,false,false));

        // Sign Up Page
        logReg.signUpInLog.setOnAction(event -> showPane(false,false,true,false));
        startPage.signUpButton.setOnAction(event -> showPane(false,false,true,false));
    }
    private void logRegConnection(){
        // Ride Request Page
        logReg.continueButton.setOnAction(event->{
            if (logReg.phoneNumberLog.getText().isEmpty() || logReg.passwordLog.getText().isEmpty()) {
                logReg.enterDataLog.setText("Please fill in all required data");
                showWarning();
            }
            else if(!LoginHandler.getInstance().login(logReg.phoneNumberLog.getText(),logReg.passwordLog.getText())){
                logReg.enterDataLog.setText("Incorrect Phone number or password");
                showWarning();
            }
            else {
                LoginHandler.getInstance().login(logReg.phoneNumberLog.getText(),logReg.passwordLog.getText());
                showPane(false, false, false, true);

                // Adds username to profile button in the navbar
                rideReguest.userDropList.setText(LoginHandler.getInstance().getPassenger().getName());

                uberLabel.setStyle("-fx-background-color: white;" +
                        "-fx-border-color: transparent transparent #e2e2e2 transparent; " +
                        "-fx-text-fill: Black; " +
                        "-fx-border-width: 3; " +
                        "-fx-font-size: 40px;");
            }
            passenger=LoginHandler.getInstance().getPassenger();
            initialize();

        });
        logReg.registerButton.setOnAction(event->{
            Passenger temp=new Passenger();
            if (logReg.regNumber.getText().isEmpty() ||
                    logReg.regPassword.getText().isEmpty()||
                    logReg.regName.getText().isEmpty()||
                    logReg.regMail.getText().isEmpty()||
                    logReg.city.getValue().equals("--City")||
                    logReg.paymentMethod.getValue().equals("--Payment method")||
                    !logReg.agreement.isSelected()) {
                logReg.enterDataLog.setText("Please enter fill all required fields");
                logReg.enterDataReg.setVisible(true);
            }
            else if(!checkRegex(logReg.regNumber.getText(),logReg.regMail.getText(),logReg.regPassword.getText()).equals("all good")){
                logReg.enterDataReg.setText(checkRegex(logReg.regNumber.getText(),logReg.regMail.getText(),logReg.regPassword.getText()));

                logReg.enterDataReg.setVisible(true);
            }

            else{
                temp.setNumber(logReg.regNumber.getText());
                temp.setName(logReg.regName.getText());
                temp.setPassword(logReg.regPassword.getText());
                temp.setEmail(logReg.regMail.getText());
                temp.setCity(logReg.city.getValue().toLowerCase());
                if(logReg.paymentMethod.getValue().equals("PayPal")){
                    temp.setPaymentMethod('p');
                }
                else{
                    temp.setPaymentMethod('c');
                }
            }
            if(!LoginHandler.getInstance().register(temp)){
                logReg.enterDataReg.setText("Phone number in use");
                logReg.enterDataReg.setVisible(true);
            }

            else {
                showPane(false, false, false, true);
                uberLabel.setStyle("-fx-background-color: white;" +
                        "-fx-border-color: transparent transparent #e2e2e2 transparent; " +
                        "-fx-text-fill: Black; " +
                        "-fx-border-width: 3; " +
                        "-fx-font-size: 40px;");
                passenger=LoginHandler.getInstance().getPassenger();
//                initialize();
            }
        });
    }
    private void rideRequestPageConnection(){
        rideReguest.search.setOnAction(event->{
            if (rideReguest.pickupRide.getText().isEmpty() || rideReguest.destinationRide.getText().isEmpty()) {
                rideReguest.enterDataRide.setText("Please fill in all required data");
                rideReguest.enterDataRide.setVisible(true);
            } else {

                Ride ride=passenger.requestRide(rideReguest.pickupRide.getText().toLowerCase(),
                        rideReguest.destinationRide.getText().toLowerCase(),rideReguest.rideType.getValue().toLowerCase());
                if(ride.getDistance()<=0){
                    rideReguest.enterDataRide.setText("Write places with correct spelling");
                    rideReguest.enterDataRide.setVisible(true);
                }
                else
                {
                    rideReguest.openRideDetailsWindow(ride);
                }

            }
        });
        rideReguest.feedback.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(false,false,false,true);
        });
        rideReguest.userDropList.setOnAction(event->{
            rideReguest.list.setVisible(true);
        });
        rideReguest.button1.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(true,false,false,false);

        });
        rideReguest.button2.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(false,true,false,false);

        });
        rideReguest.button3.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(false,false,true,false);

        });
    }
    private void leftSideOptionsConnection(){
        generalOptions.rideNow.setOnAction(event->{
            showPane(false, false, false, true);
            showPane2(false,false,false,false);
            uberLabel.setStyle("-fx-background-color: white;" +
                    "-fx-border-color: transparent transparent #e2e2e2 transparent; " +
                    "-fx-text-fill: Black; " +
                    "-fx-border-width: 3; " +
                    "-fx-font-size: 40px;");
        });
        generalOptions.myTrips.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(true,false,false,false);
        });
        generalOptions.manageAccount.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(false,true,false,false);
            generalOptions.manageAccountPane.setVisible(true);

        });
        generalOptions.profileSettings.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(false,false,true,false);
        });
        generalOptions.rideNow2.setOnAction(event->{
            showPane(false, false, false, true);
            showPane2(false,false,false,false);
            uberLabel.setStyle("-fx-background-color: white;" +
                    "-fx-border-color: transparent transparent #e2e2e2 transparent; " +
                    "-fx-text-fill: Black; " +
                    "-fx-border-width: 3; " +
                    "-fx-font-size: 40px;");
        });
        generalOptions.myTrips2.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(true,false,false,false);
        });
        generalOptions.manageAccount2.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(false,true,false,false);
            generalOptions.manageAccountPane.setVisible(true);

        });
        generalOptions.profileSettings2.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(false,false,true,false);
        });
        generalOptions.rideNow3.setOnAction(event->{
            showPane(false, false, false, true);
            showPane2(false,false,false,false);
            uberLabel.setStyle("-fx-background-color: white;" +
                    "-fx-border-color: transparent transparent #e2e2e2 transparent; " +
                    "-fx-text-fill: Black; " +
                    "-fx-border-width: 3; " +
                    "-fx-font-size: 40px;");
        });
        generalOptions.myTrips3.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(true,false,false,false);
        });
        generalOptions.manageAccount3.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(false,true,false,false);
            generalOptions.manageAccountPane.setVisible(true);

        });
        generalOptions.profileSettings3.setOnAction(event->{
            showPane(false,false,false,false);
            showPane2(false,false,true,false);
        });
    }
    private void generalOptionsConnection(){


        generalOptions.logOut.setOnAction(event->{
            showPane(true,false,false,false);
            showPane2(false,false,false,false);
            LoginHandler.getInstance().logOut();
        });
        generalOptions.deleteAccount.setOnAction(event->{
            generalOptions.openDeletionWarning();
        });
        generalOptions.backFeedback.setOnAction(event->{
            showPane(false,false,false,true);
            showPane2(false,false,false,false);
        });
        generalOptions.sendFeedback.setOnAction(event->{
            // Take Text
            // textarea named "feedbackText"
            SupportTickets supportTicket=new SupportTickets(generalOptions.feedbackText.getText());

        });
        generalOptions.editData.setOnAction(event->{
            generalOptions.nameEdit.setEditable(true);
            generalOptions.mailEdit.setEditable(true);
           // generalOptions.numberEdit.setEditable(true);
            generalOptions.passwordEdit.setEditable(true);
            generalOptions.cityEdit.setEditable(true);
            generalOptions.paymentMethodEdit.disableProperty().setValue(false);
            generalOptions.saveEdit.disableProperty().setValue(false);
        });
        generalOptions.saveEdit.setOnAction(event->{
            if(generalOptions.nameEdit.getText().isEmpty()){
                generalOptions.nameEdit.setText(passenger.getName());
            }
            else {
                passenger.setName(generalOptions.nameEdit.getText());
            }
            passenger.setCity(generalOptions.cityEdit.getValue().toLowerCase());
            if(generalOptions.paymentMethodEdit.getValue().equals("PayPal")){
                passenger.setPaymentMethod('p');
            }
            else{
                passenger.setPaymentMethod('c');
            }
            if(checkRegex(generalOptions.numberEdit.getText(),generalOptions.mailEdit.getText()
                    ,generalOptions.passwordEdit.getText()).equals("all good")){
                passenger.setEmail(generalOptions.mailEdit.getText());
                passenger.setPassword(generalOptions.passwordEdit.getText());
            }
            else{
                //add label that displays the return value of checkregex function
            }
            generalOptions.nameEdit.setEditable(false);
            generalOptions.mailEdit.setEditable(false);
            // generalOptions.numberEdit.setEditable(true);
            generalOptions.passwordEdit.setEditable(false);
            generalOptions.cityEdit.setEditable(false);
            generalOptions.paymentMethodEdit.disableProperty().setValue(true);
            generalOptions.saveEdit.disableProperty().setValue(true);
        });
    }
    private void showWarning(){
        logReg.ifPhrase.setLayoutY(420);
        logReg.signUpInLog.setLayoutY(420);
        logReg.enterDataLog.setVisible(true);
    }

    private String checkRegex(String phone,String mail,String password){
        Regex regex=new Regex();
        if(!regex.phoneRegex(phone)){
            return "Must use egyptian phone number";

        }
        if(!regex.emailRegex(mail)){
            return "Unrecognized mail format";
        }
        if(!regex.passwordRegex(password)){
           return  "Weak password";

        }

        return "all good";

    }
    private void initialize(){
        generalOptions.nameEdit.setText(passenger.getName());
        generalOptions.mailEdit.setText(passenger.getEmail());
        generalOptions.numberEdit.setText(passenger.getNumber());
        generalOptions.passwordEdit.setText(passenger.getPassword());
        switch (passenger.getCity()) {
            case "cairo" : generalOptions.cityEdit.getSelectionModel().select("Cairo");break;
            case "alexandria" :generalOptions.cityEdit.getSelectionModel().select("Alexandria");break;
            case "giza" :generalOptions.cityEdit.getSelectionModel().select("Giza");break;
        }
        if(passenger.getPaymentMethod()=='c'){
            generalOptions.paymentMethodEdit.getSelectionModel().select("Credit Card");
        }
        else
        {
            generalOptions.paymentMethodEdit.getSelectionModel().select("PayPal");
        }

    }
    public static void main(String[] args) {
        FileWriter file=new FileWriter();
        try {
            LoginHandler.getInstance().setCustomerMap(file.read());
        } catch (IOException e) {
            System.out.println(e.getMessage() + ": No Data in file Yet");
        }

        launch(args);
    }

    @Override
    public void stop() throws Exception {
        FileWriter fileWriter=new FileWriter();
        fileWriter.write(LoginHandler.getInstance().getCustomerMap());
        System.out.println("closed");
    }
}