package app;

public class PremiumRide extends RideDecorator{
    public PremiumRide(Ride ride) {
        super(ride);
    }

    @Override
    public float getPrice() {
     return 2.5f*distance;
    }
}
