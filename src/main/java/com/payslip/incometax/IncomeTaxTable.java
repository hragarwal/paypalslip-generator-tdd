package com.payslip.incometax;

import com.payslip.exception.AnnualSalaryException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class IncomeTaxTable {
    private List<IncomeTaxSlab> incomeTaxSlabs;

    public IncomeTaxTable(List<IncomeTaxSlab> incomeTaxSlabs) {
        this.incomeTaxSlabs = incomeTaxSlabs;
    }

    public IncomeTaxTable() {
    }

    List<IncomeTaxSlab> getIncomeTaxSlabs() {
        return incomeTaxSlabs;
    }

    public IncomeTaxSlab getTaxSlabForAnnualSalary(BigDecimal annualSalary) {
        Optional<IncomeTaxSlab> optionalIncomeTaxSlabEntry =
                incomeTaxSlabs.stream().filter(taxSlab -> taxSlab.getValidTaxBracket(annualSalary)).findFirst();

        IncomeTaxSlab incomeTaxSlab = optionalIncomeTaxSlabEntry.orElse(null);
        checkValidTaxBracket(incomeTaxSlab);
        return incomeTaxSlab;
    }

    public static class Builder {
        private List<IncomeTaxSlab> incomeTaxSlabs;

        public Builder setIncomeTaxSlabs(List<IncomeTaxSlab> incomeTaxSlabs) {
            this.incomeTaxSlabs = incomeTaxSlabs;
            return this;
        }

        public IncomeTaxTable build() {
            return new IncomeTaxTable(incomeTaxSlabs);
        }
    }

    private void checkValidTaxBracket(IncomeTaxSlab incomeTaxSlab){
        if(Objects.isNull(incomeTaxSlab)) {
            throw new AnnualSalaryException("Annual income is invalid or tax bracket not available");
        }
    }

}
