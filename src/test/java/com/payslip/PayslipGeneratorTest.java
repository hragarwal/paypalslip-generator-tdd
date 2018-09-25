package com.payslip;

import com.payslip.incometax.IncomeTaxSlab;
import com.payslip.incometax.IncomeTaxTable;
import com.payslip.model.Employee;
import com.payslip.model.EmployeeDetail;
import com.payslip.model.Payslip;
import com.payslip.parser.CsvReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PayslipGeneratorTest {

    @Test
    public void shouldReturnPayslipGeneratorObject(){
        PayslipGenerator payslipGenerator = new PayslipGenerator();

        assertNotNull(payslipGenerator);
    }

    @Test
    public void shouldReturnGrossIncomeFromAnnualSalary(){
        BigDecimal expectedGrossIncome = BigDecimal.valueOf(5004);

        CsvReader csvReader = new CsvReader();
        EmployeeDetail employeeDetail = csvReader.read("David,Rudd,60050,9%,01 March – 31 March");
        PayslipGenerator payslipGenerator = new PayslipGenerator();

        BigDecimal actualMonthlySalary = payslipGenerator.generateGrossIncome(employeeDetail.getAnnualSalary());
        assertEquals(expectedGrossIncome,actualMonthlySalary);
    }

    @Test
    public void shouldReturnMonthlyIncomeTax(){
        BigDecimal expectedMonthlyIncomeTax = BigDecimal.valueOf(922);

        List<IncomeTaxSlab> incomeTaxSlabs = IncomeTaxDataSetup.getIncomeTaxTableSlabs();
        IncomeTaxTable incomeTaxTable = new IncomeTaxTable.Builder()
                .setIncomeTaxSlabs(incomeTaxSlabs).build();

        EmployeeDetail employeeDetail = IncomeTaxDataSetup.getEmployeeDetail();

        PayslipGenerator payslipGenerator = new PayslipGenerator(incomeTaxTable);
        BigDecimal actualMonthlyIncomeTax = payslipGenerator
                                                .generateMonthlyIncomeTax(employeeDetail.getAnnualSalary());
        assertEquals(expectedMonthlyIncomeTax,actualMonthlyIncomeTax);
    }

    @Test
    public void shouldReturnNetIncomeFromGrossIncome(){
        BigDecimal expectedNetIncome = BigDecimal.valueOf(4082);

        BigDecimal grossIncome = BigDecimal.valueOf(5004);
        BigDecimal monthlyIncomeTax = BigDecimal.valueOf(922);
        PayslipGenerator payslipGenerator = new PayslipGenerator();

        BigDecimal actualNetIncome = payslipGenerator.generateNetIncome(grossIncome,monthlyIncomeTax);
        assertEquals(expectedNetIncome,actualNetIncome);
    }

    @Test
    public void shouldReturnSuperFromGrossIncome(){
        BigDecimal expectedSuper = BigDecimal.valueOf(450);

        BigDecimal grossIncome = BigDecimal.valueOf(5004);
        int superRate = 9;
        PayslipGenerator payslipGenerator = new PayslipGenerator();

        BigDecimal actualSuper = payslipGenerator.generateSuperRate(grossIncome,superRate);
        assertEquals(expectedSuper,actualSuper);
    }

    @Test
    public void generatePayslipForEmployee(){
        BigDecimal expectedGrossIncome = BigDecimal.valueOf(5004);
        BigDecimal expectedMonthlyIncomeTax = BigDecimal.valueOf(922);
        BigDecimal expectedNetIncome = BigDecimal.valueOf(4082);
        BigDecimal expectedSuper = BigDecimal.valueOf(450);

        EmployeeDetail employeeDetail = IncomeTaxDataSetup.getEmployeeDetail();
        List<IncomeTaxSlab> incomeTaxSlabs = IncomeTaxDataSetup.getIncomeTaxTableSlabs();
        IncomeTaxTable incomeTaxTable = new IncomeTaxTable.Builder()
                .setIncomeTaxSlabs(incomeTaxSlabs).build();

        PayslipGenerator payslipGenerator = new PayslipGenerator(incomeTaxTable);
        Payslip payslip = payslipGenerator.generateMonthlyPayslip(employeeDetail);

        assertNotNull(payslip);
        assertEquals("David Rudd",payslip.getName());
        assertEquals("01 March – 31 March", payslip.getPayPeriod());
        assertEquals(expectedGrossIncome, payslip.getGrossIncome());
        assertEquals(expectedMonthlyIncomeTax, payslip.getIncomeTax());
        assertEquals(expectedNetIncome, payslip.getNetIncome());
        assertEquals(expectedSuper, payslip.getSuperRate());
    }
}
