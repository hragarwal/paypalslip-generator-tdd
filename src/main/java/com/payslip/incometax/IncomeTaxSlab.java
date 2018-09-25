package com.payslip.incometax;

import java.math.BigDecimal;

public class IncomeTaxSlab {

    private IncomeTaxBracket incomeTaxBracket;
    private IncomeTaxThreshold incomeTaxThreshold;

    public IncomeTaxSlab(IncomeTaxBracket incomeTaxBracket, IncomeTaxThreshold incomeTaxThreshold) {
        this.incomeTaxBracket = incomeTaxBracket;
        this.incomeTaxThreshold = incomeTaxThreshold;
    }

    public IncomeTaxSlab() {
    }

    IncomeTaxBracket getIncomeTaxBracket() {
        return incomeTaxBracket;
    }

    public IncomeTaxThreshold getIncomeTaxThreshold() {
        return incomeTaxThreshold;
    }

    boolean getValidTaxBracket(BigDecimal annualSalary) {
        return annualSalary.compareTo(incomeTaxBracket.getMinThreshold()) > 0
                && annualSalary.compareTo(incomeTaxBracket.getMaxThreshold()) < 0;
    }

    public static class Builder {
        private IncomeTaxBracket incomeTaxBracket;
        private IncomeTaxThreshold incomeTaxThreshold;

        public Builder setIncomeTaxBracket(IncomeTaxBracket incomeTaxBracket) {
            this.incomeTaxBracket = incomeTaxBracket;
            return this;
        }

        public Builder setIncomeTaxThreshold(IncomeTaxThreshold incomeTaxThreshold) {
            this.incomeTaxThreshold = incomeTaxThreshold;
            return this;
        }

        public IncomeTaxSlab build() {
            return new IncomeTaxSlab(incomeTaxBracket, incomeTaxThreshold);
        }
    }

}
