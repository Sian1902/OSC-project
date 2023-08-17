package login;
import java.util.*;


public class Passenger {
    private String name;
    private String number;
    private String email;
    private String password;
    private int paymentMethod;
//    private Queue<Ride> rideHistory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /*public Queue<Ride> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory(Queue<Ride> rideHistory) {
        this.rideHistory = rideHistory;
    }*/

    public void requestRide(){};
    public void displayPastRides(){};
}
