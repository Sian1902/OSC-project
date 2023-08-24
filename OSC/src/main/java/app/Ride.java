package app;

import Maps.DistanceCalculator;

public class Ride {
    protected String startPosition;
    protected   String distenation;
    protected float distance;
    protected float price;

    public Ride(String startPosition, String distenation) {
        this.startPosition = startPosition;
        this.distenation = distenation;
        this.distance=DistanceCalculator.getDistanceCalculator().calculateDistance(startPosition,distenation);
    }

    public String getDistenation() {
        return distenation;
    }

    public float getDistance() {
        return distance;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public float getPrice() {
        return distance*price;
    }
}
