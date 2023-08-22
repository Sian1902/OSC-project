package Maps;

public class GeocodingResponse {
    private Result[] results;

    public boolean isValid() {
        return results != null && results.length > 0;
    }

    public Location getLatLng() {
        double latitude = results[0].geometry.location.getLatitude();
        double longitude = results[0].geometry.location.getLongitude();
        return new Location(latitude, longitude);
    }

    private class Result {
        private Geometry geometry;
    }

    private class Geometry {
        private Location location;
    }
}
