package com.payslip.incometax;

import com.payslip.IncomeTaxDataSetup;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IncomeTaxBracketTest {

    @Test
    public void shouldReturnIncomeTaxSlabObject() {
        IncomeTaxBracket incomeTaxBracket = new IncomeTaxBracket();
        assertNotNull(incomeTaxBracket);
    }

    @Test
    public void shouldReturnIncomeTaxBracketForAnnualSalary() {
        BigDecimal expectedMinThreshold = BigDecimal.ZERO;
        BigDecimal expectedMaxThreshold = BigDecimal.valueOf(18200);

        IncomeTaxBracket incomeTaxBracket = IncomeTaxDataSetup.getIncomeTaxBracket(BigDecimal.ZERO, BigDecimal.valueOf(18200));

        BigDecimal actualMinThreshold = incomeTaxBracket.getMinThreshold();
        BigDecimal actualMaxThreshold = incomeTaxBracket.getMaxThreshold();

        assertEquals(expectedMinThreshold, actualMinThreshold);
        assertEquals(expectedMaxThreshold, actualMaxThreshold);
    }
}
