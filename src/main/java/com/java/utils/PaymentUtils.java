package com.java.utils;

import com.java.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private static Map<String, Double> paymentMap = new HashMap<>();
    {
        paymentMap.put("acc1", 12000.0);
        paymentMap.put("acc2", 12000.0);
        paymentMap.put("acc3", 12000.0);
        paymentMap.put("acc4", 12000.0);

    }
    public static boolean validateCredentials(String accNo, double paidAmount){
        if(paidAmount > paymentMap.get(accNo)){
            throw new InsufficientAmountException("Insufficient Amount Exception..");

        }else{
            return true;
        }
    }
}
