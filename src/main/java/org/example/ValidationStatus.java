package org.example;

import java.util.Arrays;
import java.util.HashSet;

public class ValidationStatus {

    public enum Status{
        ACCEPT, FLAG, REJECT 

    };
    
    HashSet<String> transaction_types = new HashSet<>(Arrays.asList("ATM", "QR", "Online","POS"));
 

    // structual fields validation of each row
    public boolean isInvalidStructure(Transaction tr){
        return tr.get_transaction_id() <= 0 
        || tr.get_user_id() <= 0 
        || tr.get_transaction_type() == null
        || tr.get_Merchant_categorty() == null 
        || tr.get_ip_risk_score() <= 0 
        || tr.get_device_risk_score()<= 0 
        || !transaction_types.contains(tr.get_transaction_type());
    }

    public boolean isFlagged(Transaction tr){
        return tr.get_amount() == 0.0;
    }

    public Status validate(Transaction tr){
        if(isInvalidStructure(tr)){
            return Status.REJECT;
        }
        else if(isFlagged(tr)){
            return Status.FLAG;
        }
        return Status.ACCEPT;
    }

}
