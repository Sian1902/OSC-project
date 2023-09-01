module com.example.osc {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires jopencage;
    //requires javafx.web;

    opens com.example.osc to javafx.fxml;
    opens Maps; // Allow access to the Maps package
    exports com.example.osc;
}