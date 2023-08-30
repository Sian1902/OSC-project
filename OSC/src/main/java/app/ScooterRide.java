package app;

public class ScooterRide extends RideDecorator {
    public ScooterRide(Ride ride) {
        super(ride);
    }

    @Override
    public float getPrice() {
        price=1.5f*distance;
        return price;
    }
}
