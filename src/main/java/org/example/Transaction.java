package org.example;

public class Transaction {
    //attributes of a record
    private int transaction_id;
    private int user_id;
    private double amount;
    private String transaction_type;
    private double device_risk_score;
    private double ip_risk_score;

    //getters
    public int get_transaction_id(){
        return transaction_id;
    }

    public int get_user_id(){
        return user_id;
    }

    public double  get_amount(){
        return amount;
    }

    public double get_ip_risk_score(){
        return ip_risk_score;
    }

    public double get_device_risk_score(){
        return device_risk_score;
    }

    public String get_transaction_type(){
        return transaction_type;
    }

    //Setting all the infromation one taken from the file or API

    public void set_transation_data(
            int transaction_id,
            int user_id,
            double amount,
            String transaction_type,
            double device_risk_score,
            double ip_risk_score
    ){
        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.amount = amount;
        this.transaction_type = transaction_type;
        this.device_risk_score = device_risk_score;
        this.ip_risk_score = ip_risk_score;

    }



}
