package com.payslip;

import com.payslip.incometax.IncomeTaxBracket;
import com.payslip.incometax.IncomeTaxSlab;
import com.payslip.incometax.IncomeTaxThreshold;
import com.payslip.model.Employee;
import com.payslip.model.EmployeeDetail;
import com.payslip.model.Payslip;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class IncomeTaxDataSetup {

    public static List<IncomeTaxSlab> getIncomeTaxTableSlabs() {
        List<IncomeTaxSlab> incomeTaxSlabs = new LinkedList<>();

        IncomeTaxBracket incomeTaxBracket1 = getIncomeTaxBracket(BigDecimal.ZERO, BigDecimal.valueOf(18200));
        IncomeTaxThreshold incomeTaxThreshold1 = getIncomeTaxThreshold(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        IncomeTaxSlab incomeTaxSlab1 = getIncomeTaxSlab(incomeTaxBracket1, incomeTaxThreshold1);

        IncomeTaxBracket incomeTaxBracket2 = getIncomeTaxBracket(BigDecimal.valueOf(18201), BigDecimal.valueOf(37000));
        IncomeTaxThreshold incomeTaxThreshold2 = getIncomeTaxThreshold(BigDecimal.ZERO, BigDecimal.valueOf(0.19), BigDecimal.valueOf(18200));
        IncomeTaxSlab incomeTaxSlab2 = getIncomeTaxSlab(incomeTaxBracket2, incomeTaxThreshold2);

        IncomeTaxBracket incomeTaxBracket3 = getIncomeTaxBracket(BigDecimal.valueOf(37001), BigDecimal.valueOf(87000));
        IncomeTaxThreshold incomeTaxThreshold3 = getIncomeTaxThreshold(BigDecimal.valueOf(3572), BigDecimal.valueOf(0.325), BigDecimal.valueOf(37000));
        IncomeTaxSlab incomeTaxSlab3 = getIncomeTaxSlab(incomeTaxBracket3, incomeTaxThreshold3);

        IncomeTaxBracket incomeTaxBracket4 = getIncomeTaxBracket(BigDecimal.valueOf(87001), BigDecimal.valueOf(180000));
        IncomeTaxThreshold incomeTaxThreshold4 = getIncomeTaxThreshold(BigDecimal.valueOf(19822), BigDecimal.valueOf(0.37), BigDecimal.valueOf(87000));
        IncomeTaxSlab incomeTaxSlab4 = getIncomeTaxSlab(incomeTaxBracket4, incomeTaxThreshold4);

        IncomeTaxBracket incomeTaxBracket5 = getIncomeTaxBracket(BigDecimal.valueOf(180001), BigDecimal.valueOf(Double.MAX_VALUE));
        IncomeTaxThreshold incomeTaxThreshold5 = getIncomeTaxThreshold(BigDecimal.valueOf(54232), BigDecimal.valueOf(0.45), BigDecimal.valueOf(180000));
        IncomeTaxSlab incomeTaxSlab5 = getIncomeTaxSlab(incomeTaxBracket5, incomeTaxThreshold5);

        incomeTaxSlabs.add(incomeTaxSlab1);
        incomeTaxSlabs.add(incomeTaxSlab2);
        incomeTaxSlabs.add(incomeTaxSlab3);
        incomeTaxSlabs.add(incomeTaxSlab4);
        incomeTaxSlabs.add(incomeTaxSlab5);
        return incomeTaxSlabs;
    }

    public static IncomeTaxBracket getIncomeTaxBracket(BigDecimal minThreshold, BigDecimal maxThreshold) {
        return new IncomeTaxBracket.Builder()
                .setMinThreshold(minThreshold)
                .setMaxThreshold(maxThreshold).build();
    }

    public static IncomeTaxThreshold getIncomeTaxThreshold(BigDecimal defaultTax, BigDecimal marginalTax, BigDecimal threshold) {
        return new IncomeTaxThreshold.Builder()
                .setDefaultTax(defaultTax)
                .setMarginalTax(marginalTax)
                .setIncomeThreshold(threshold).build();
    }

    public static IncomeTaxSlab getIncomeTaxSlab(IncomeTaxBracket incomeTaxBracket, IncomeTaxThreshold incomeTaxThreshold) {
        return new IncomeTaxSlab.Builder()
                .setIncomeTaxBracket(incomeTaxBracket)
                .setIncomeTaxThreshold(incomeTaxThreshold)
                .build();
    }

    private static Employee getEmployee() {
        return new Employee.Builder()
                .setFirstName("David")
                .setLastName("Rudd").build();
    }

    public static EmployeeDetail getEmployeeDetail() {
        return new EmployeeDetail.Builder()
                .setEmployee(getEmployee())
                .setAnnualSalary(BigDecimal.valueOf(60050))
                .setSuperRate(9)
                .setPayPeriod("01 March – 31 March").build();
    }

    public static Payslip getPayslip() {
        return new Payslip.Builder()
                .setName("David Rudd")
                .setPayPeriod("01 March – 31 March")
                .setGrossIncome(BigDecimal.valueOf(5004))
                .setIncomeTax(BigDecimal.valueOf(922))
                .setNetIncome(BigDecimal.valueOf(4082))
                .setSuperRate(BigDecimal.valueOf(450))
                .build();
    }
}
