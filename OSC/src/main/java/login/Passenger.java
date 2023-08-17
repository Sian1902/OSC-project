package login;
import java.util.*;


public class Passenger {
    private String name;
    private long number;
    private String email;
    private String password;
    private int paymantMethod;
    private Queue<Ride> rideHistory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
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

    public int getPaymantMethod() {
        return paymantMethod;
    }

    public void setPaymantMethod(int paymantMethod) {
        this.paymantMethod = paymantMethod;
    }

    public Queue<Ride> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory(Queue<Ride> rideHistory) {
        this.rideHistory = rideHistory;
    }


}
