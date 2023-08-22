package Maps;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GoogleMapsAPIHelper {
    private static final String API_KEY = "AIzaSyCaHoOZhdhTLiVWTEyLuRmhIEXHW8-TPJE";
    private static final String GEOCODING_URL = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String DISTANCE_MATRIX_URL = "https://maps.googleapis.com/maps/api/distancematrix/json";

    private static String buildRequestUrl(String baseUrl, String params) {
        return baseUrl + "?" + params + "&key=" + API_KEY;
    }

    public static Location getLocation(String placeName) {
        try {
            String params = "address=" + placeName.replace(" ", "+");
            URL url = new URL(buildRequestUrl(GEOCODING_URL, params));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream response = connection.getInputStream();
            String jsonResponse = new Scanner(response).useDelimiter("\\A").next();
            response.close();

            // Parse JSON response using Gson and return location
            // Make sure to define Location class with latitude and longitude fields
            Gson gson = new Gson();
            GeocodingResponse geocodingResponse = gson.fromJson(jsonResponse, GeocodingResponse.class);

            if (geocodingResponse != null && geocodingResponse.isValid()) {
                return geocodingResponse.getLatLng();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Similar logic for distance calculation API
}