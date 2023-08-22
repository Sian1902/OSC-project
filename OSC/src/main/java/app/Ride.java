package app;

public class Ride {
    protected String startPosition;
    protected   String distenation;
    protected float distance;
    protected float price;

    public Ride(String startPosition, String distenation) {
        this.startPosition = startPosition;
        this.distenation = distenation;
    }

    public String getDistenation() {
        return distenation;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public float getPrice() {
        return price;
    }
}
