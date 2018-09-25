package com.payslip.exception;

public class ValueRangeException extends IllegalArgumentException{

    public ValueRangeException(String message){
        super(message);
    }
}
