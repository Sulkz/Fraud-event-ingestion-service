package org.example;

import java.util.Arrays;
import java.util.HashSet;

public class Transaction {
    //attributes of a record
    private int transaction_id;
    private int user_id;
    private double  amount;
    private String transaction_type;
    private String merchant_category;
    private double device_risk_score;
    private double ip_risk_score;
    private enum Status{
        ACCEPT, FLAG, REJECT 

    };

    Status status;
    
    HashSet<String> transaction_types = new HashSet<>(Arrays.asList("ATM", "QR", "Online","POS"));

    // structual fields validation of each row
    Status validationStructure(){
        if (transaction_id <= 0 || user_id <= 0 || transaction_type == null
             || merchant_category == null || ip_risk_score <= 0 || device_risk_score <= 0 
             || !transaction_types.contains(transaction_type)){
            return Status.REJECT;
        }else if (amount == 0.0){
            return Status.FLAG;
        }else{ 
            return Status.ACCEPT;
        
        }

    }


    //getters
    public int get_transaction_id(){ return transaction_id;}
    public int get_user_id(){ return user_id;}
    public double get_amount(){ return amount;}
    public String get_transaction_type(){ return transaction_type;}
    public double get_ip_risk_score(){ return ip_risk_score;}
    public double get_device_risk_score(){ return device_risk_score; }
    public String get_Merchant_categorty() { return merchant_category; }
    
    

//Setting all the infromation one taken from the file or API

    public void set_transaction_data(
            int transaction_id,
            int user_id,
            double amount,
            String transaction_type,
            String merchant_category,
            double device_risk_score,
            double ip_risk_score
    ){
        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.amount = amount;
        this.transaction_type = transaction_type;
        this.merchant_category = merchant_category;
        this.device_risk_score = device_risk_score;
        this.ip_risk_score = ip_risk_score;
        

       

    }


}
