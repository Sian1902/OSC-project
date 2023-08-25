package login;

import java.io.*;
import java.util.Hashtable;

public class FileWriter {
    public void write(Hashtable<String,Passenger>CustomerMap)throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("CustomerData.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        for (String phonenumber : CustomerMap.keySet()) {
            Passenger passenger = CustomerMap.get(phonenumber);
            bufferedWriter.write(phonenumber + " " + passenger.getName() + " " + passenger.getEmail() + " " + passenger.getPassword() + " " + passenger.getPaymentMethod() + " "+passenger.getCity() +"\n");
        }

        bufferedWriter.close();
        fileOutputStream.close();
    }

    public Hashtable<String,Passenger> read() throws IOException {
        Hashtable<String,Passenger>customerMap=new Hashtable<>();
        FileReader fileReader = new FileReader("CustomerData.txt");

        // Create a BufferedReader object to read the file line by line
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready())
        {
            // Read the first line of the file
            String line = bufferedReader.readLine();

            // Split the line by the space delimiter
            String[] data = line.split(" ");

            // Declare the string variables
            Passenger passenger=new Passenger();
            String phoneNumber = data[0];
            passenger.setName(data[1]);
            passenger.setEmail(data[2]);
            passenger.setPassword(data[3]);
            passenger.setNumber(phoneNumber);
            passenger.setPaymentMethod(data[4].charAt(0));
            passenger.setCity(data[5]);
            customerMap.put(phoneNumber,passenger);
            System.out.println(passenger.getNumber() + " " + passenger.getName() + " " + passenger.getEmail() + " " + passenger.getPassword() + " " + passenger.getPaymentMethod()+" "+passenger.getCity());

        }


        // Close the file reader
        bufferedReader.close();

        return customerMap;    }
}
