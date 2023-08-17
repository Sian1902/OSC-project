package login;

import java.util.Hashtable;

public class LoginHandler {
    private static  LoginHandler instance = new LoginHandler();
    private String customerKey;
    private Hashtable<String,Passenger> customerMap;

    private LoginHandler(){}


    public static LoginHandler getInstance() {
        return instance;
    }
    public Passenger login(String phoneNumber,String password){
        if(customerMap.containsKey(phoneNumber)){
            String correctPassword=customerMap.get(phoneNumber).getPassword();
            if(correctPassword.equals(password)){
                customerKey=phoneNumber;
                return customerMap.get(phoneNumber);
            }


        }
        return null;
    }
public void logOut(){
        customerKey="";
}
 public void deleteUser(){
        customerMap.remove(customerKey);
  }
  public boolean register(Passenger passenger){
        if(customerMap.containsKey(passenger.getNumber())){
            return false;
        }
       customerMap.put(passenger.getNumber(),passenger);
        return true;
  }
}
