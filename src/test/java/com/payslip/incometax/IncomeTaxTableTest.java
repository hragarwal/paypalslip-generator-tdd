package com.payslip.incometax;

import com.payslip.IncomeTaxDataSetup;
import com.payslip.exception.AnnualSalaryException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IncomeTaxTableTest {

    @Test
    public void shouldReturnIncomeTaxTableObjectNonNull() {
        IncomeTaxTable incomeTaxTable = new IncomeTaxTable();

        assertNotNull(incomeTaxTable);
    }

    @Test
    public void shouldReturnIncomeTaxSlabs() {
        List<IncomeTaxSlab> incomeTaxSlabs = IncomeTaxDataSetup.getIncomeTaxTableSlabs();
        IncomeTaxTable incomeTaxTable = new IncomeTaxTable.Builder()
                .setIncomeTaxSlabs(incomeTaxSlabs).build();
        List<IncomeTaxSlab> actualIncomeTaxSlabs = incomeTaxTable.getIncomeTaxSlabs();

        assertEquals(incomeTaxSlabs.size(), actualIncomeTaxSlabs.size());
    }

    @Test(expected = AnnualSalaryException.class)
    public void throwExceptionWhenAnnualIncomeIsInvalid(){
        List<IncomeTaxSlab> incomeTaxSlabs = IncomeTaxDataSetup.getIncomeTaxTableSlabs();
        IncomeTaxTable incomeTaxTable = new IncomeTaxTable.Builder()
                .setIncomeTaxSlabs(incomeTaxSlabs).build();
        incomeTaxTable.getTaxSlabForAnnualSalary(BigDecimal.valueOf(-500));
    }
}
