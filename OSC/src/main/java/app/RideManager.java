package app;

import java.util.Queue;

public class RideManager {
   Queue<Ride>rideQueue;

    public RideManager(Queue<Ride> rideQueue) {
        this.rideQueue = rideQueue;
    }
    public void requestRide(String startPosition,String endPosition,String rideType){
        Ride ride;
        switch (rideType){
            case "Normal": ride=new NormalRide(new Ride(startPosition,endPosition)); break;
            case "premium": ride=new PremiumRide(new Ride(startPosition,endPosition));break;
            case "scooter":ride=new ScooterRide(new Ride(startPosition,endPosition));break;
            default:ride=new Ride(startPosition,endPosition);
        }
   addRide(ride);
    }

    public Queue<Ride> getRideQueue() {
        return rideQueue;
    }
public void addRide(Ride ride){
        rideQueue.add(ride);
}

}
