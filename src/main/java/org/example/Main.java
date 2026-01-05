package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Main {
    public static void print_Transactions(Transaction transaction){
        System.out.println("Transaction_ id: "  + transaction.get_transaction_id() +
                            " User_id: " + transaction.get_user_id() +
                            " Amount: " + transaction.get_amount() +
                            " Transaction_type: " + transaction.get_transaction_type() +
                            " Merchant_Catergory: " + transaction.get_Merchant_categorty()+
                            " device_risk_ip: " + transaction.get_device_risk_score() +
                            " ip_risk_score: " + transaction.get_ip_risk_score() );
    }
    public static void main(String[] args) throws IOException {

        
        InputStream inputStream = Main.class
            .getClassLoader()
            .getResourceAsStream("synthetic_fraud_dataset.csv");

        if (inputStream == null) {
            throw new RuntimeException("CSV file not found in resources");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        
        /* read the headers contains the headers transaction_id,user_id,amount,
        // transaction_type,merchant_category,country,hour,
        // device_risk_score,ip_risk_score */


        String headerLine = reader.readLine();
        System.out.println("=====================================");
        String line = null;
        
        ValidationStatus validationStatus = new ValidationStatus();

        while ((line = reader.readLine()) != null){
            Transaction transaction = new Transaction();
            
            String[] fields = line.split(","); // splits all the words 

            transaction.set_transaction_data(
                Integer.parseInt(fields[0]),
                Integer.parseInt(fields[1]),
                Double.parseDouble(fields[2]),
                fields[3],
                fields[4],
                Double.parseDouble(fields[7]),
                Double.parseDouble(fields[8]));

    
            ValidationStatus.Status status = validationStatus.validate(transaction);
            
            if(status == ValidationStatus.Status.REJECT){
                print_Transactions(transaction);
            }
        }
        

    }


}