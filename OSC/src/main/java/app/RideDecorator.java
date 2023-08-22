package app;

public class RideDecorator extends Ride{
    Ride ride;

    public RideDecorator( Ride ride) {
        super(ride.getStartPosition(), ride.getStartPosition());
        this.ride = ride;
    }
}
