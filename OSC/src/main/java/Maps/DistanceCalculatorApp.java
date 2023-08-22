package Maps;
import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DistanceCalculatorApp extends Application {
    private TextField place1Field;
    private TextField place2Field;
    private Label resultLabel;
    private JOpenCageGeocoder geocoder;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Distance Calculator");

        geocoder = new JOpenCageGeocoder("36521598748a4f608b11011d60ff444a");

        place1Field = new TextField();
        place1Field.setPromptText("Enter place 1");
        place2Field = new TextField();
        place2Field.setPromptText("Enter place 2");

        Button calculateButton = new Button("Calculate Distance");
        calculateButton.setOnAction(e -> calculateDistance());

        resultLabel = new Label();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(place1Field, place2Field, calculateButton, resultLabel);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateDistance() {
        String place1Name = place1Field.getText();
        String place2Name = place2Field.getText();

        JOpenCageLatLng place1LatLng = getLatLng(place1Name);
        JOpenCageLatLng place2LatLng = getLatLng(place2Name);

        if (place1LatLng != null && place2LatLng != null) {
            double distance = calculateDistance(place1LatLng.getLat(), place1LatLng.getLng(),
                    place2LatLng.getLat(), place2LatLng.getLng());

            resultLabel.setText("Distance: " + distance + " km");
        } else {
            resultLabel.setText("Invalid places");
        }
    }

    private JOpenCageLatLng getLatLng(String placeName) {
        try {
            JOpenCageForwardRequest request = new JOpenCageForwardRequest(placeName);
            JOpenCageResponse response = geocoder.forward(request);

            if (response != null && response.getFirstPosition() != null) {
                JOpenCageLatLng latLng = response.getFirstPosition();
                return latLng;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371; // Earth's radius in kilometers

        // Convert latitude and longitude from degrees to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Haversine formula
        double dlat = lat2Rad - lat1Rad;
        double dlon = lon2Rad - lon1Rad;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        return distance;
    }

    }

