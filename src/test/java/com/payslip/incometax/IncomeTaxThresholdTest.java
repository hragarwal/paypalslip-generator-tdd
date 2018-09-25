package com.payslip.incometax;

import com.payslip.IncomeTaxDataSetup;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IncomeTaxThresholdTest {

    @Test
    public void shouldReturnIncomeTaxThresholdNonNull() {
        IncomeTaxThreshold incomeTaxThreshold = new IncomeTaxThreshold();

        assertNotNull(incomeTaxThreshold);
    }

    @Test
    public void shouldReturnIncomeTaxThresholdForAnnualSalary() {
        BigDecimal expectedDefaultTax = BigDecimal.ZERO;
        BigDecimal expectedMarginalTax = BigDecimal.valueOf(0.19);
        BigDecimal expectedIncomeThreshold = BigDecimal.valueOf(18200);

        IncomeTaxThreshold incomeTaxThreshold = IncomeTaxDataSetup.getIncomeTaxThreshold(BigDecimal.ZERO, BigDecimal.valueOf(0.19), BigDecimal.valueOf(18200));

        BigDecimal actualDefaultTax = incomeTaxThreshold.getDefaultTax();
        BigDecimal actualMarginalTax = incomeTaxThreshold.getMarginalTax();
        BigDecimal actualIncomeThreshold = incomeTaxThreshold.getIncomeThreshold();

        assertEquals(expectedDefaultTax, actualDefaultTax);
        assertEquals(expectedMarginalTax, actualMarginalTax);
        assertEquals(expectedIncomeThreshold, actualIncomeThreshold);
    }
}
