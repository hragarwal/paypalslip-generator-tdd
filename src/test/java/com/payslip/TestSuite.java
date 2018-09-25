package com.payslip;

import com.payslip.incometax.IncomeTaxBracketTest;
import com.payslip.incometax.IncomeTaxSlabTest;
import com.payslip.incometax.IncomeTaxTableTest;
import com.payslip.incometax.IncomeTaxThresholdTest;
import com.payslip.model.EmployeeDetailTest;
import com.payslip.model.EmployeeTest;
import com.payslip.model.PayslipTest;
import com.payslip.parser.CsvReaderTest;
import com.payslip.parser.CsvWriterTest;
import com.payslip.utils.ValidationUtilsTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({IncomeTaxBracketTest.class, IncomeTaxSlabTest.class, IncomeTaxTableTest.class, IncomeTaxThresholdTest.class,
        EmployeeDetailTest.class, EmployeeTest.class, PayslipTest.class, CsvReaderTest.class, CsvWriterTest.class,
        PayslipGeneratorTest.class, ValidationUtilsTest.class})
public class TestSuite {
}
