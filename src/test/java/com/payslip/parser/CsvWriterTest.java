package com.payslip.parser;

import com.payslip.IncomeTaxDataSetup;
import com.payslip.model.Payslip;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CsvWriterTest {

    @Test
    public void shouldReturnCsvWriteObjectNonNull() {
        CsvWriter csvWriter = new CsvWriter();

        assertNotNull(csvWriter);
    }

    @Test
    public void shouldReturnPayslipCsvFormatFromPayslipObject() {
        String expectedPayslipCsvFormat = "David Rudd,01 March – 31 March,5004,922,4082,450";

        CsvWriter csvWriter = new CsvWriter();
        Payslip payslip = IncomeTaxDataSetup.getPayslip();
        String actualPayslipCsvFormat = csvWriter.write(payslip);

        assertEquals(expectedPayslipCsvFormat, actualPayslipCsvFormat);
    }
}
