package com.payslip.utils;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ValidationUtilsTest {

    @Test
    public void parseSuperRateInStringAndGetItInDecimal(){
        BigDecimal expectedPercentage = BigDecimal.valueOf(13);
        BigDecimal actualPercentage = ValidationUtils.parsePercentageFromSuperRate("13%");
        assertEquals(expectedPercentage, actualPercentage);
    }
}
