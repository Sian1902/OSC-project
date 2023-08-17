package login;

import java.io.*;
import java.util.Hashtable;

public class FileWriter {
    Passenger passenger=new Passenger();
    public void write(Hashtable<String,Passenger>CustomerMap)throws IOException {
        Hashtable<String, Passenger> customerMap = new Hashtable<>();

        FileOutputStream fileOutputStream = new FileOutputStream("CustomerData.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        for (String phonenumber : customerMap.keySet()) {
            Passenger passenger = customerMap.get(phonenumber);
            bufferedWriter.write(phonenumber + " " + passenger.getName() + " " + passenger.getEmail() + " " + passenger.getPassword() + "\n");
        }

        bufferedWriter.close();
        fileOutputStream.close();
    }

    public Hashtable<String,Passenger> read() throws IOException {
        Hashtable<String,Passenger>customerMap=new Hashtable<>();
        FileReader fileReader = new FileReader("CustomerData.txt");

        // Create a BufferedReader object to read the file line by line
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Read the first line of the file
        String line = bufferedReader.readLine();

        // Split the line by the space delimiter
        String[] data = line.split(" ");

        // Declare the string variables
        String phoneNumber = data[0];
        passenger.setName(data[1]);
        passenger.setEmail(data[2]);
        passenger.setPassword(data[3]);
        customerMap.put(phoneNumber,passenger);
        // Close the file reader
        bufferedReader.close();

        return customerMap;
    }
}
