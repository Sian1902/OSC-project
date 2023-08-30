package login;

import app.Ride;
import app.RideManager;

import java.util.Queue;

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
    public Queue<Ride> displayPastRides(){
        return rideManager.getRideQueue();
    };
    public int getRideCount(){
       return rideManager.getRideCount();
    }
    public void setRideCount(int count){
        rideManager.setRideCount(count);
    }
}
/*
* for(){
* Ride = new ride(start,dest,price);
* passenger.addride(ride)
*
* */