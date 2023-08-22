package Maps;

public class LocationApp {
    public static void main(String[] args) {
        String placeName1 = "Cairo";
        String placeName2 = "Alexandria";

        Location location1 = GoogleMapsAPIHelper.getLocation(placeName1);
        Location location2 = GoogleMapsAPIHelper.getLocation(placeName2);

        if (location1 != null && location2 != null) {
            System.out.println("Location 1: Latitude " + location1.getLatitude() + ", Longitude " + location1.getLongitude());
            System.out.println("Location 2: Latitude " + location2.getLatitude() + ", Longitude " + location2.getLongitude());

            double distance = calculateDistance(location1, location2);
            System.out.println("Distance between " + placeName1 + " and " + placeName2 + " is: " + distance + " km");
        } else {
            System.out.println("Location information not found.");
        }
    }


    public static double calculateDistance(Location location1, Location location2) {
        double earthRadius = 6371.0; // Earth's radius in kilometers
        double lat1 = Math.toRadians(location1.getLatitude());
        double lon1 = Math.toRadians(location1.getLongitude());
        double lat2 = Math.toRadians(location2.getLatitude());
        double lon2 = Math.toRadians(location2.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = earthRadius * c;
        return distance;
    }
}
