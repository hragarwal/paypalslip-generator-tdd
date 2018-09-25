package com.payslip.parser;

import com.payslip.model.Payslip;

import java.util.ArrayList;
import java.util.List;

public class CsvWriter {

    public String write(Payslip payslip) {
        List<String> payslipAttributes = new ArrayList<>();

        payslipAttributes.add(payslip.getName());
        payslipAttributes.add(payslip.getPayPeriod());
        payslipAttributes.add(String.valueOf(payslip.getGrossIncome()));
        payslipAttributes.add(String.valueOf(payslip.getIncomeTax()));
        payslipAttributes.add(String.valueOf(payslip.getNetIncome()));
        payslipAttributes.add(String.valueOf(payslip.getSuperRate()));

        return String.join(",", payslipAttributes);
    }
}
