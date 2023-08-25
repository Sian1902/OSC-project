package input.check;

import java.util.regex.*;

public class Regex {
    public boolean emailRegex(String email){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher=pattern.matcher(email);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
    public boolean phoneRegex(String phoneNumber){
        String regex="^(011|012|010|015)\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher=pattern.matcher(phoneNumber);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
    public boolean passwordRegex(String password){
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
}
