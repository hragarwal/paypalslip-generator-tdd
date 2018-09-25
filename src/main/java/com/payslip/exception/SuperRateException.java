package com.payslip.exception;

public class SuperRateException extends IllegalArgumentException {
    public SuperRateException(String message){
        super(message);
    }
}
