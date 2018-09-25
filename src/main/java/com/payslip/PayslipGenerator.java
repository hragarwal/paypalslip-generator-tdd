package com.payslip;

import com.payslip.incometax.IncomeTaxSlab;
import com.payslip.incometax.IncomeTaxTable;
import com.payslip.model.Employee;
import com.payslip.model.EmployeeDetail;
import com.payslip.model.Payslip;

import java.math.BigDecimal;

public class PayslipGenerator {

    private static final int MONTHS_IN_A_YEAR = 12;

    private IncomeTaxTable incomeTaxTable;

    public PayslipGenerator(IncomeTaxTable incomeTaxTable) {
        this.incomeTaxTable = incomeTaxTable;
    }

    public PayslipGenerator() {
    }

    BigDecimal generateGrossIncome(BigDecimal annualSalary) {
        return annualSalary.divide(BigDecimal.valueOf(MONTHS_IN_A_YEAR), 0, BigDecimal.ROUND_HALF_DOWN);
    }

    BigDecimal generateMonthlyIncomeTax(BigDecimal annualSalary) {
        IncomeTaxSlab incomeTaxSlab = incomeTaxTable.getTaxSlabForAnnualSalary(annualSalary);
        BigDecimal defaultTax = incomeTaxSlab.getIncomeTaxThreshold().getDefaultTax();
        BigDecimal marginalTax = incomeTaxSlab.getIncomeTaxThreshold().getMarginalTax();
        BigDecimal incomeThreshold = incomeTaxSlab.getIncomeTaxThreshold().getIncomeThreshold();
        return (defaultTax.add((annualSalary.subtract(incomeThreshold)).multiply(marginalTax)))
                .divide(BigDecimal.valueOf(MONTHS_IN_A_YEAR), 0, BigDecimal.ROUND_HALF_DOWN);
    }

    BigDecimal generateNetIncome(BigDecimal grossIncome, BigDecimal monthlyIncomeTax) {
        return grossIncome.subtract(monthlyIncomeTax);
    }

    BigDecimal generateSuperRate(BigDecimal grossIncome, int superRate) {
        return grossIncome
                .multiply(BigDecimal.valueOf(superRate))
                .divide(BigDecimal.valueOf(100), 0, BigDecimal.ROUND_HALF_DOWN);
    }

    Payslip generateMonthlyPayslip(EmployeeDetail employeeDetail) {
        Employee employee = employeeDetail.getEmployee();
        BigDecimal annualSalary = employeeDetail.getAnnualSalary();
        int superRate = employeeDetail.getSuperRate();
        String payPeriod = employeeDetail.getPayPeriod();

        BigDecimal monthlyGrossIncome = generateGrossIncome(annualSalary);
        BigDecimal monthlyIncomeTax = generateMonthlyIncomeTax(annualSalary);
        BigDecimal monthlyNetIncome = generateNetIncome(monthlyGrossIncome, monthlyIncomeTax);
        BigDecimal monthlySuperRate = generateSuperRate(monthlyGrossIncome, superRate);

        return new Payslip.Builder()
                .setName(employee.getEmployeeFullName())
                .setGrossIncome(monthlyGrossIncome)
                .setIncomeTax(monthlyIncomeTax)
                .setNetIncome(monthlyNetIncome)
                .setSuperRate(monthlySuperRate)
                .setPayPeriod(payPeriod)
                .build();

    }
}
