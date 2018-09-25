package com.payslip;


import com.payslip.incometax.IncomeTaxSlab;
import com.payslip.incometax.IncomeTaxTable;
import com.payslip.parser.CsvWriter;
import com.payslip.model.EmployeeDetail;
import com.payslip.model.Payslip;
import com.payslip.parser.CsvReader;

import java.util.ArrayList;
import java.util.List;

//API to Run
public class HowToUse {

    public static void main(String[] args) {
        List<String> csvDataSet = new ArrayList<>();
        csvDataSet.add("David,Rudd,60050,9%,01 March – 31 March");
        csvDataSet.add("Ryan,Chen,120000,10%,01 March – 31 March");

        System.out.println("Input ---> ");
        System.out.println(csvDataSet);
        System.out.println("Output ---> ");

        CsvReader csvReader = new CsvReader();
        CsvWriter csvWriter = new CsvWriter();
        List<IncomeTaxSlab> incomeTaxSlabs = IncomeTaxDataSetup.getIncomeTaxTableSlabs();
        IncomeTaxTable incomeTaxTable = new IncomeTaxTable.Builder()
                .setIncomeTaxSlabs(incomeTaxSlabs).build();
        PayslipGenerator payslipGenerator = new PayslipGenerator(incomeTaxTable);

        csvDataSet.forEach(csvData -> {
            EmployeeDetail employeeDetail = csvReader.read(csvData);
            Payslip payslip = payslipGenerator.generateMonthlyPayslip(employeeDetail);
            System.out.println(csvWriter.write(payslip));
        });
    }
}
