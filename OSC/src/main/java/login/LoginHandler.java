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

    private String customerKey;
    private Hashtable<String,Passenger> customerMap= new Hashtable<>();

    private LoginHandler() throws IOException {}

    public Hashtable<String, Passenger> getCustomerMap() {
        return customerMap;
    }

    public static LoginHandler getInstance() {
        return instance;
    }
    public Passenger login(String phoneNumber,String password){
        if(customerMap.containsKey(phoneNumber)){
            String correctPassword=customerMap.get(phoneNumber).getPassword();
            if(correctPassword.equals(password)){
                customerKey=phoneNumber;
                System.out.println("logged in");
                return customerMap.get(phoneNumber);
            }


        }
        return null;
    }
public void logOut(){
    System.out.println(customerKey);

    customerKey="";
    System.out.println("loged Out");

}
 public void deleteUser(){
        customerMap.remove(customerKey);
  }
  public boolean register(Passenger passenger){
        if(customerMap.containsKey(passenger.getNumber())){
            return false;
        }
       customerMap.put(passenger.getNumber(),passenger);
      System.out.println("registered");
        return true;
  }
}
