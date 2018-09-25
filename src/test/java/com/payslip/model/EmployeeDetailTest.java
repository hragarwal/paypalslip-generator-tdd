package com.payslip.model;

import com.payslip.IncomeTaxDataSetup;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmployeeDetailTest {

    @Test
    public void shouldReturnEmployeeDetailObject() {
        EmployeeDetail employeeDetail = new EmployeeDetail();

        assertNotNull(employeeDetail);
    }

    @Test
    public void shouldReturnEmployeeDetails() {
        EmployeeDetail employeeDetail  = IncomeTaxDataSetup.getEmployeeDetail();

        assertNotNull(employeeDetail);
        assertEquals("David", employeeDetail.getEmployee().getFirstName());
        assertEquals("Rudd", employeeDetail.getEmployee().getLastName());
        assertEquals(BigDecimal.valueOf(60050), employeeDetail.getAnnualSalary());
        assertEquals(9, employeeDetail.getSuperRate());
        assertEquals("01 March – 31 March", employeeDetail.getPayPeriod());
    }
}
