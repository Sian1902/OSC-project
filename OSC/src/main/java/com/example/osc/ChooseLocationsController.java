package com.example.osc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ChooseLocationsController {

    @FXML
    private TextField inputStart;

    @FXML
    private TextField inputDest;

    @FXML
    private Label lblCost;

    @FXML
    private HBox controls;

    @FXML
    private ImageView backBtn;

    @FXML
    void initialize() {
    }
}
