module com.example.osc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.osc to javafx.fxml;
    exports com.example.osc;
}