package com.payslip.parser;


import com.payslip.exception.SuperRateException;
import com.payslip.exception.ValueRangeException;
import com.payslip.model.EmployeeDetail;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CsvReaderTest {

    @Test
    public void shouldPass() {
        assertTrue(true);
    }

    @Test
    public void csvReaderShouldBeNotNull() {
        CsvReader csvReader = new CsvReader();

        assertNotNull(csvReader);
    }

    @Test
    public void shouldReturnEmployeeDetailsObjectFromCsv() {
        CsvReader csvReader = new CsvReader();
        EmployeeDetail employeeDetails = csvReader.read("David,Rudd,60050,9%,01 March – 31 March");

        assertNotNull(employeeDetails);
    }

    @Test
    public void shouldReturnEmployeeDetailsFromCsv() {
        CsvReader csvReader = new CsvReader();
        EmployeeDetail employeeDetail = csvReader.read("David,Rudd,60050,9%,01 March – 31 March");

        assertNotNull(employeeDetail);
        assertEquals("David", employeeDetail.getEmployee().getFirstName());
        assertEquals("Rudd", employeeDetail.getEmployee().getLastName());
        assertEquals(BigDecimal.valueOf(60050), employeeDetail.getAnnualSalary());
        assertEquals(9, employeeDetail.getSuperRate());
        assertEquals("01 March – 31 March", employeeDetail.getPayPeriod());
    }

    @Test(expected = SuperRateException.class)
    public void throwExceptionWhenSuperRateIsInvalidFormat(){
        CsvReader csvReader = new CsvReader();
        csvReader.read("David,Rudd,60050,65,01 March – 31 March");
    }

    @Test(expected = ValueRangeException.class)
    public void throwExceptionWhenSuperRateIsInvalid(){
        CsvReader csvReader = new CsvReader();
        csvReader.read("David,Rudd,60050,65%,01 March – 31 March");
    }

    @Test(expected = ValueRangeException.class)
    public void throwExceptionWhenAnnualSalaryIsInvalid(){
        CsvReader csvReader = new CsvReader();
        csvReader.read("David,Rudd,-60050,9%,01 March – 31 March");
    }
}
