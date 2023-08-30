package login;

import app.Ride;
import app.RideManager;
public class Passenger {
    private String name;
    private String number;
    private String email;
    private String password;
    private String city;
    private char paymentMethod;
     RideManager rideManager= new RideManager();
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public char getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(char paymentMethod) {
        this.paymentMethod = paymentMethod;
    }



    public Ride requestRide(String start,String destination,String type){
        return rideManager.requestRide(start, destination, type);
    };
    public void addRide(Ride ride){
        rideManager.addRide(ride);
    }
    public void displayPastRides(){
        rideManager.getRideQueue();
    };
}
