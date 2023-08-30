package login;

import java.io.IOException;
import java.util.Hashtable;

public class LoginHandler {
    private static  LoginHandler instance;

    static {
        try {
            instance = new LoginHandler();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setCustomerMap(Hashtable<String, Passenger> customerMap) {
        this.customerMap = customerMap;
    }

    private String customerKey;
    private Hashtable<String,Passenger> customerMap= new Hashtable<>();

    private LoginHandler() throws IOException {}

    public Hashtable<String, Passenger> getCustomerMap() {
        return customerMap;
    }

    public static LoginHandler getInstance() {
        return instance;
    }
    public boolean login(String phoneNumber,String password){
        if(customerMap.containsKey(phoneNumber)){
            String correctPassword=customerMap.get(phoneNumber).getPassword();
            if(correctPassword.equals(password)){
                customerKey=phoneNumber;
                System.out.println("logged in");
                return true;
            }


        }
        return false;
    }
public void logOut(){
    System.out.println(customerKey);

    customerKey="";
    System.out.println("loged Out");

}
public Passenger getPassenger(){
        return customerMap.get(customerKey);
}
 public void deleteUser(){customerMap.remove(customerKey);}
  public boolean register(Passenger passenger){
        if(customerMap.containsKey(passenger.getNumber())){
            return false;
        }
       customerMap.put(passenger.getNumber(),passenger);
      customerKey=passenger.getNumber();
      System.out.println("registered");
        return true;
  }
}
