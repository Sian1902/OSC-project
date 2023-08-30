package com.example.osc;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ChooseLocationsController {

    @FXML
    private TextField inputStart;

    @FXML
    private TextField inputDest;

    @FXML
    private Label lblCost;

    @FXML
    private HBox costCalc;

    @FXML
    private HBox controls;

    @FXML
    private ImageView backBtn;

    @FXML
    private Button pickMe;

    @FXML
    private HBox ridesBox;

    private String startPos;
    private String dest;

    public String getStartPos() {
        return startPos;
    }

    public String getDest() {
        return dest;
    }


    @FXML
    private void pickMeUp() {
        if (inputStart.getText().equals("") || inputDest.getText().equals(""))
        {
            return;
        }
        startPos = inputStart.getText();
        dest = inputDest.getText();
        inputStart.setDisable(true);
        inputDest.setDisable(true);
        pickMe.setVisible(false);
        ridesBox.setVisible(true);
    }

    @FXML
    private void calcCost(MouseEvent e) throws NoSuchFieldException {
        System.out.println(e.getTarget().hashCode());
    }

    @FXML
    void initialize() {
    }
}
