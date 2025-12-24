package org.example;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void validString(Transaction transaction){
        System.out.println("Transaction_ id: "  + transaction.get_transaction_id() +
                            " User_id: " + transaction.get_user_id() +
                            " Amount: " + transaction.get_amount() +
                            " Transaction_type: " + transaction.get_transaction_type() +
                            " device_risk_ip: " + transaction.get_device_risk_score() +
                            " ip_risk_score: " + transaction.get_ip_risk_score() );
    }
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/org/example/synthetic_fraud_dataset.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);


        //read the headers
        String headerLine = reader.readLine();
        String line = null;

        //
        List<Transaction> transactions = new ArrayList<>();

        while ((line = reader.readLine()) != null){
            Transaction transaction = new Transaction();
            String[] fields = line.split(",");
            transaction.set_transaction_data(
                    Integer.parseInt(fields[0]),
                    Integer.parseInt(fields[1]),
                    Double.parseDouble(fields[2]),
                    fields[3],
                    fields[4],
                    fields[5],
                    Integer.parseInt(fields[6]),
                    Double.parseDouble(fields[7]),
                    Double.parseDouble(fields[8]));

            validString(transaction);
        }

    }


}