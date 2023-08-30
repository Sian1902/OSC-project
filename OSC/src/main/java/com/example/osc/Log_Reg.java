package com.example.osc;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class Log_Reg {
    private Label loginPhrase, registerLabel;
    Label enterDataLog,enterDataReg,ifPhrase;
    TextField phoneNumberLog,regNumber,regName,regMail;
    PasswordField passwordLog,regPassword;
    Button continueButton,signUpInLog,registerButton,backButtonL,backButtonR;
    CheckBox agreement;
    ComboBox<String> paymentMethod ,city;
    Pane logInPane,signUpPane;
    @FXML
    Pane getLogInPane(){

        backButtonL=new Button();
        backButtonL.setText(" ◀ ");
        backButtonL.setLayoutX(20);
        backButtonL.setLayoutY(85);
        backButtonL.setStyle("-fx-background-color: black;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 30px;"+
                "-fx-text-fill: white;"+
                "-fx-border-radius: 50px;"+
                "-fx-background-radius: 50px;");

        loginPhrase=new Label();
        loginPhrase.setText("What's your phone number?");
        loginPhrase.setWrapText(true);
        loginPhrase.setPrefHeight(150);
        loginPhrase.setPrefWidth(400);
        loginPhrase.setLayoutX(575);
        loginPhrase.setLayoutY(70);
        loginPhrase.setStyle("-fx-font-size: 30px;" +
                "-fx-text-fill: black;" );

        phoneNumberLog=new TextField();
        phoneNumberLog.setPromptText("Enter phone number");
        phoneNumberLog.setPrefHeight(55);
        phoneNumberLog.setPrefWidth(370);
        phoneNumberLog.setLayoutX(580);
        phoneNumberLog.setLayoutY(185);
        phoneNumberLog.setPadding(new Insets(0, 0, 0, 20));
        phoneNumberLog.setFocusTraversable(false);
        phoneNumberLog.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;" +
                "-fx-border-color: black;");

        passwordLog=new PasswordField();
        passwordLog.setPromptText("Enter your password");
        passwordLog.setPrefHeight(55);
        passwordLog.setPrefWidth(370);
        passwordLog.setLayoutX(580);
        passwordLog.setLayoutY(255);
        passwordLog.setPadding(new Insets(0, 0, 0, 20));
        passwordLog.setFocusTraversable(false);
        passwordLog.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;" +
                "-fx-border-color: black;");

        continueButton=new Button();
        continueButton.setText("Continue");
        continueButton.setPrefHeight(55);
        continueButton.setPrefWidth(370);
        continueButton.setLayoutX(580);
        continueButton.setLayoutY(325);
        continueButton.setStyle("-fx-background-color: black;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: white;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;" +
                "-fx-border-color: transparent;");
        continueButton.setOnMouseEntered(event -> {
            continueButton.setStyle("-fx-background-color: #333333;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-radius: 10px;"+
                    "-fx-background-radius: 10px;" +
                    "-fx-border-color: transparent;");
        });
        continueButton.setOnMouseExited(event -> {
            continueButton.setStyle("-fx-background-color: black;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-radius: 10px;"+
                    "-fx-background-radius: 10px;" +
                    "-fx-border-color: transparent;");
                }
        );

        enterDataLog=new Label();
        enterDataLog.setText("Please fill in all required data");
        enterDataLog.setLayoutX(630);
        enterDataLog.setLayoutY(375);
        enterDataLog.setPrefHeight(55);
        enterDataLog.setPrefWidth(370);
        enterDataLog.setStyle("-fx-background-color: transparent;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: red;");

        ifPhrase=new Label();
        ifPhrase.setText("If you don't have account ");
        ifPhrase.setPrefHeight(55);
        ifPhrase.setPrefWidth(370);
        ifPhrase.setLayoutX(580);
        ifPhrase.setLayoutY(395);
        ifPhrase.setStyle("-fx-background-color: transparent;" +
                "-fx-font-size: 24px;" +
                "-fx-text-fill: black;" +
                "-fx-border-color: black transparent transparent transparent;");

        signUpInLog=new Button();
        signUpInLog.setText("Sign Up");
        signUpInLog.setPrefHeight(55);
        signUpInLog.setPrefWidth(150);
        signUpInLog.setLayoutX(825);
        signUpInLog.setLayoutY(395);
        signUpInLog.setStyle("-fx-background-color: transparent;" +
                "-fx-font-size: 24px;" +
                "-fx-text-fill: #4285f4;" +
                "-fx-border-color: transparent transparent transparent transparent;");
        signUpInLog.setOnMouseEntered(event -> {
            signUpInLog.setStyle("-fx-background-color: transparent;" +
                    "-fx-font-size: 24px;" +
                    "-fx-text-fill: #4285f4;" +
                    "-fx-underline: true;"+
                    "-fx-border-color: transparent transparent transparent transparent;");
        });
        signUpInLog.setOnMouseExited(event -> {
            signUpInLog.setStyle("-fx-background-color: transparent;" +
                    "-fx-font-size: 24px;" +
                    "-fx-text-fill: #4285f4;" +
                    "-fx-underline: false;"+
                    "-fx-border-color: transparent transparent transparent transparent;");
        });

        phoneNumberLog.setOnAction(event -> passwordLog.requestFocus());

        logInPane = new Pane();
        logInPane.getChildren().addAll(backButtonL,loginPhrase,phoneNumberLog,passwordLog,continueButton,ifPhrase,signUpInLog,enterDataLog);
        return logInPane;
    }
    Pane getSignUpPane(){
        backButtonR=new Button();
        backButtonR.setText(" ◀ ");
        backButtonR.setLayoutX(20);
        backButtonR.setLayoutY(85);
        backButtonR.setStyle("-fx-background-color: black;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 30px;"+
                "-fx-text-fill: white;"+
                "-fx-border-radius: 50px;"+
                "-fx-background-radius: 50px;");

        registerLabel=new Label();
        registerLabel.setText("Register");
        registerLabel.setPrefHeight(70);
        registerLabel.setPrefWidth(150);
        registerLabel.setLayoutX(700);
        registerLabel.setLayoutY(100);
        registerLabel.setStyle("-fx-font-size: 30px;" +
                "-fx-text-fill: black;" );

        regNumber=new TextField();
        regNumber.setPromptText("Enter phone number");
        regNumber.setPrefHeight(55);
        regNumber.setPrefWidth(370);
        regNumber.setLayoutX(580);
        regNumber.setLayoutY(185);
        regNumber.setPadding(new Insets(0, 0, 0, 20));
        regNumber.setFocusTraversable(false);
        regNumber.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;" +
                "-fx-border-color: black;");

        regPassword=new PasswordField();
        regPassword.setPromptText("Enter your password");
        regPassword.setPrefHeight(55);
        regPassword.setPrefWidth(370);
        regPassword.setLayoutX(580);
        regPassword.setLayoutY(255);
        regPassword.setPadding(new Insets(0, 0, 0, 20));
        regPassword.setFocusTraversable(false);
        regPassword.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;" +
                "-fx-border-color: black;");

        regName=new TextField();
        regName.setPromptText("Enter your name");
        regName.setPrefHeight(55);
        regName.setPrefWidth(370);
        regName.setLayoutX(580);
        regName.setLayoutY(325);
        regName.setPadding(new Insets(0, 0, 0, 20));
        regName.setFocusTraversable(false);
        regName.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;" +
                "-fx-border-color: black;");

        regMail=new TextField();
        regMail.setPromptText("Enter your mail");
        regMail.setPrefHeight(55);
        regMail.setPrefWidth(370);
        regMail.setLayoutX(580);
        regMail.setLayoutY(395);
        regMail.setPadding(new Insets(0, 0, 0, 20));
        regMail.setFocusTraversable(false);
        regMail.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;" +
                "-fx-border-color: black;");

        city=new ComboBox<>();
        city.setPromptText("Choose your city");
        city.getItems().addAll("--City","Cairo", "Alexandria","Giza");
        city.getSelectionModel().selectFirst();
        city.setPrefHeight(55);
        city.setPrefWidth(370);
        city.setLayoutX(580);
        city.setLayoutY(465);
        city.setPadding(new Insets(0, 0, 0, 20));
        city.setFocusTraversable(false);
        city.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;" +
                "-fx-border-color: black;");

        paymentMethod = new ComboBox<>();
        paymentMethod.getItems().addAll("--Payment method","Credit Card", "PayPal");
        paymentMethod.getSelectionModel().selectFirst();
        paymentMethod.setPrefHeight(55);
        paymentMethod.setPrefWidth(370);
        paymentMethod.setLayoutX(580);
        paymentMethod.setLayoutY(535);
        paymentMethod.setPadding(new Insets(0, 0, 0, 20));
        paymentMethod.setFocusTraversable(false);
        paymentMethod.setStyle("-fx-background-color: #eeeeee;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: black;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;" +
                "-fx-border-color: black;");

        agreement=new CheckBox("I agree to the terms of service.");
        agreement.setLayoutX(585);
        agreement.setLayoutY(600);
        agreement.setStyle("-fx-font-size: 20px;" +
                "-fx-text-fill: black;");

        registerButton=new Button();
        registerButton.setText("Register");
        registerButton.setPrefHeight(55);
        registerButton.setPrefWidth(370);
        registerButton.setLayoutX(580);
        registerButton.setLayoutY(640);
        registerButton.setStyle("-fx-background-color: black;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: white;" +
                "-fx-border-radius: 10px;"+
                "-fx-background-radius: 10px;" +
                "-fx-border-color: transparent;");
        registerButton.setOnMouseEntered(event -> {
            registerButton.setStyle("-fx-background-color: #333333;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-radius: 10px;"+
                    "-fx-background-radius: 10px;" +
                    "-fx-border-color: transparent;");
        });
        registerButton.setOnMouseExited(event -> {
            registerButton.setStyle("-fx-background-color: black;" +
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-radius: 10px;"+
                    "-fx-background-radius: 10px;" +
                    "-fx-border-color: transparent;");
        });

        enterDataReg=new Label();
        enterDataReg.setText("Please fill in all required data");
        enterDataReg.setLayoutX(630);
        enterDataReg.setLayoutY(690);
        enterDataReg.setPrefHeight(55);
        enterDataReg.setPrefWidth(370);
        enterDataReg.setStyle("-fx-background-color: transparent;" +
                "-fx-font-size: 20px;" +
                "-fx-text-fill: red;");

        regNumber.setOnAction(event -> regPassword.requestFocus());
        regPassword.setOnAction(event -> regName.requestFocus());
        regName.setOnAction(event -> regMail.requestFocus());
        regMail.setOnAction(event -> city.requestFocus());
        city.setOnAction(event -> paymentMethod.requestFocus());

        signUpPane = new Pane();
        signUpPane.getChildren().addAll(backButtonR,registerLabel,regNumber,regPassword,regName,regMail,city,paymentMethod,agreement,registerButton,enterDataReg);
        return signUpPane;
    }

}