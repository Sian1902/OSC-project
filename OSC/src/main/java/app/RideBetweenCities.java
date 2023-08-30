package app;

public class RideBetweenCities extends RideDecorator{
    public RideBetweenCities(Ride ride) {
        super(ride);
    }

    @Override
    public float getPrice() {
        price=4*distance;
        return price;
    }
}
