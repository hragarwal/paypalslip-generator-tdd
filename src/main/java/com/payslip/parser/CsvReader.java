package com.payslip.parser;

import com.payslip.model.Employee;
import com.payslip.model.EmployeeDetail;
import com.payslip.utils.ValidationUtils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvReader {

    public EmployeeDetail read(String csvString) {
        String[] payslipParameters = csvString.split(",");
        String firstName = payslipParameters[0];
        String lastName = payslipParameters[1];
        BigDecimal annualSalary = validateGrossSalary(payslipParameters[2]);
        int superRate = validateSuperRate(payslipParameters[3]);
        String payPeriod = payslipParameters[4];

        Employee employee = new Employee.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
        return new EmployeeDetail.Builder()
                .setEmployee(employee)
                .setAnnualSalary(annualSalary)
                .setPayPeriod(payPeriod)
                .setSuperRate(superRate)
                .build();
    }

    private int validateSuperRate(String superRateString){
        BigDecimal superRate = ValidationUtils.parsePercentageFromSuperRate(superRateString);
        ValidationUtils.ensureWithinRange(superRate, BigDecimal.ZERO, BigDecimal.valueOf(50));
        return superRate.intValue();
    }

    private BigDecimal validateGrossSalary(String annualSalaryString){
        BigDecimal grossSalary = new BigDecimal(annualSalaryString);
        ValidationUtils.ensureWithinRange(grossSalary, BigDecimal.ZERO, BigDecimal.valueOf(Integer.MAX_VALUE));
        return grossSalary;
    }
}
