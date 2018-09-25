package com.payslip.utils;

import com.payslip.exception.SuperRateException;
import com.payslip.exception.ValueRangeException;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    private static final String superRatePattern = "^(\\d*.+\\d*)%$";

    public static BigDecimal parsePercentageFromSuperRate(String superRateString){
        Pattern pattern = Pattern.compile(superRatePattern);
        Matcher matcher = pattern.matcher(superRateString);
        if(matcher.find()){
            String result = matcher.group(1);
            return new BigDecimal(result);
        }
        throw new SuperRateException("Super Rate is invalid");
    }

    public static void ensureWithinRange(BigDecimal value, BigDecimal min, BigDecimal max){
        if (value.compareTo(min) < 0) throw new ValueRangeException("Value is invalid, less then 0");
        if (value.compareTo(max) > 0) throw new ValueRangeException("Value is invalid, greater then max value");
    }
}
