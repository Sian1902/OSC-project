package app;

public class RideBetweenCities extends RideDecorator{
    public RideBetweenCities(Ride ride) {
        super(ride);
    }

    @Override
    public float getPrice() {
       return distance*4;
    }
}
