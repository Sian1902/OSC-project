package app;

import java.util.LinkedList;
import java.util.Queue;

public class RideManager {
   Queue<Ride>rideQueue;
   public RideManager() {
       this.rideQueue = new LinkedList<Ride>();
   }

    public String requestRide(String startPosition, String endPosition, String rideType) {
        Ride ride;
        switch (rideType) {
            case "normal":
                ride = new NormalRide(new Ride(startPosition, endPosition));addRide(ride);
                return "request successful";

            case "premium":
                ride = new PremiumRide(new Ride(startPosition, endPosition));addRide(ride);
                return "request successful";

            case "scooter":
                ride = new ScooterRide(new Ride(startPosition, endPosition));addRide(ride);
                return "request successful";

            case "city":
                ride = new RideBetweenCities(new Ride(startPosition, endPosition));addRide(ride);
                return "request successful";


        }
        return "request Failed";
    }

    public Queue<Ride> getRideQueue() {
        return rideQueue;
    }
    public void addRide(Ride ride){
       rideQueue.add(ride);
    }
}