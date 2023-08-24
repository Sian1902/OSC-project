package app;

public class RideDecorator extends Ride{
    Ride ride;

    public RideDecorator( Ride ride) {
        super(ride.getStartPosition(), ride.getDistenation());
        this.ride = ride;
    }
}
