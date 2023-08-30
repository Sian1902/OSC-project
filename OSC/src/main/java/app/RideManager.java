package app;

import login.LoginHandler;

import java.util.LinkedList;
import java.util.Queue;

public class RideManager {
    int rideCount;
   Queue<Ride>rideQueue;
   public RideManager() {
       this.rideQueue = new LinkedList<Ride>();
   }

    public void setRideCount(int rideCount) {
        this.rideCount = rideCount;
    }

    public Ride requestRide(String startPosition, String endPosition, String rideType) {
        Ride ride;
        if(rideType.equals("city")==false){
            startPosition+=", "+ LoginHandler.getInstance().getPassenger().getCity();
            endPosition+=", "+ LoginHandler.getInstance().getPassenger().getCity();
        }
        else{
            startPosition+=" governorate";
            endPosition+=" governorate";
        }
        switch (rideType) {
            case "normal":
                ride = new NormalRide(new Ride(startPosition, endPosition));
                return ride;

            case "premium":
                ride = new PremiumRide(new Ride(startPosition, endPosition));
                return ride;

            case "scooter":
                ride = new ScooterRide(new Ride(startPosition, endPosition));
                return ride;

            case "between cities":
                ride = new RideBetweenCities(new Ride(startPosition, endPosition));
                return ride;


        }
        return null;
    }

    public int getRideCount() {
        return rideCount;
    }

    public Queue<Ride> getRideQueue() {
        return rideQueue;
    }
    public void addRide(Ride ride){
       rideQueue.add(ride);
       rideCount=rideQueue.size();
    }
}