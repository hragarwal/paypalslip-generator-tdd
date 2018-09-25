package com.payslip.incometax;

import com.payslip.IncomeTaxDataSetup;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IncomeTaxSlabTest {

    @Test
    public void shouldReturnIncomeTaxSlabObject() {
        IncomeTaxSlab incomeTaxSlab = new IncomeTaxSlab();
        assertNotNull(incomeTaxSlab);
    }

    @Test
    public void shouldReturnTaxSlabDetailsForAnnualSalary() {
        BigDecimal expectedMinThreshold = BigDecimal.ZERO;
        BigDecimal expectedMaxThreshold = BigDecimal.valueOf(18200);
        BigDecimal expectedDefaultTax = BigDecimal.ZERO;
        BigDecimal expectedMarginalTax = BigDecimal.valueOf(0.19);
        BigDecimal expectedIncomeThreshold = BigDecimal.valueOf(18200);

        IncomeTaxBracket incomeTaxBracket = IncomeTaxDataSetup.getIncomeTaxBracket(BigDecimal.ZERO, BigDecimal.valueOf(18200));
        IncomeTaxThreshold incomeTaxThreshold = IncomeTaxDataSetup.getIncomeTaxThreshold(BigDecimal.ZERO, BigDecimal.valueOf(0.19), BigDecimal.valueOf(18200));
        IncomeTaxSlab incomeTaxSlab = IncomeTaxDataSetup.getIncomeTaxSlab(incomeTaxBracket, incomeTaxThreshold);

        BigDecimal actualMinThreshold = incomeTaxSlab.getIncomeTaxBracket().getMinThreshold();
        BigDecimal actualMaxThreshold = incomeTaxSlab.getIncomeTaxBracket().getMaxThreshold();
        BigDecimal actualDefaultTax = incomeTaxSlab.getIncomeTaxThreshold().getDefaultTax();
        BigDecimal actualMarginalTax = incomeTaxSlab.getIncomeTaxThreshold().getMarginalTax();
        BigDecimal actualIncomeThreshold = incomeTaxSlab.getIncomeTaxThreshold().getIncomeThreshold();

        assertEquals(expectedMinThreshold, actualMinThreshold);
        assertEquals(expectedMaxThreshold, actualMaxThreshold);
        assertEquals(expectedDefaultTax, actualDefaultTax);
        assertEquals(expectedMarginalTax, actualMarginalTax);
        assertEquals(expectedIncomeThreshold, actualIncomeThreshold);
    }

}
