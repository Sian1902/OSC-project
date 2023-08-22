package app;

public class NormalRide extends RideDecorator{
    public NormalRide(Ride ride) {
        super(ride);
    }

    @Override
    public float getPrice() {
       return 2*distance;
    }
}
