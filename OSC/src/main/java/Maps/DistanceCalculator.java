package Maps;
import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;

public class DistanceCalculator {

    private JOpenCageGeocoder geocoder;
    private static DistanceCalculator distanceCalculator= new DistanceCalculator();

    public static DistanceCalculator getDistanceCalculator() {
        return distanceCalculator;
    }

    private DistanceCalculator() {
        geocoder = new JOpenCageGeocoder("36521598748a4f608b11011d60ff444a");
    }
     public float calculateDistance(String place1Name,String place2Name) {


        JOpenCageLatLng place1LatLng = getLatLng(place1Name);
        JOpenCageLatLng place2LatLng = getLatLng(place2Name);

        if (place1LatLng != null && place2LatLng != null) {
            double distance = calculateDistance(place1LatLng.getLat(), place1LatLng.getLng(),
                    place2LatLng.getLat(), place2LatLng.getLng());

             return  (int)distance ;
        } else {
            return -1;
        }
    }

    private JOpenCageLatLng getLatLng(String placeName) {
        try {
            JOpenCageForwardRequest request = new JOpenCageForwardRequest(placeName + ", Egypt"); // Append the country to the query
            JOpenCageResponse response = geocoder.forward(request);

            if (response != null && response.getFirstPosition() != null) {
                JOpenCageLatLng latLng = response.getFirstPosition();
                System.out.println(latLng.getLat());
                System.out.println(latLng.getLng());

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

