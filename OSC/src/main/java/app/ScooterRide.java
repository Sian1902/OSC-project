package app;

public class ScooterRide extends RideDecorator {
    public ScooterRide(Ride ride) {
        super(ride);
    }

    @Override
    public float getPrice() {
        return 1.5f *distance;
    }
}
