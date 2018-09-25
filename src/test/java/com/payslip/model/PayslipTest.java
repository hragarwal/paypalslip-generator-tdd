package com.payslip.model;

import com.payslip.IncomeTaxDataSetup;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PayslipTest {

    @Test
    public void shouldReturnPayslipObjectNonNull() {
        Payslip payslip = new Payslip();

        assertNotNull(payslip);
    }

    @Test
    public void shouldReturnPayslip() {
        Payslip payslip = IncomeTaxDataSetup.getPayslip();

        assertEquals("David Rudd", payslip.getName());
        assertEquals("01 March – 31 March", payslip.getPayPeriod());
        assertEquals(BigDecimal.valueOf(5004), payslip.getGrossIncome());
        assertEquals(BigDecimal.valueOf(922), payslip.getIncomeTax());
        assertEquals(BigDecimal.valueOf(4082), payslip.getNetIncome());
        assertEquals(BigDecimal.valueOf(450), payslip.getSuperRate());
    }
}
