package com.payslip.incometax;

import java.math.BigDecimal;

public class IncomeTaxThreshold {

    private BigDecimal defaultTax;
    private BigDecimal marginalTax;
    private BigDecimal incomeThreshold;

    public IncomeTaxThreshold(BigDecimal defaultTax, BigDecimal marginalTax, BigDecimal incomeThreshold) {
        this.defaultTax = defaultTax;
        this.marginalTax = marginalTax;
        this.incomeThreshold = incomeThreshold;
    }

    public IncomeTaxThreshold() {
    }

    public BigDecimal getDefaultTax() {
        return defaultTax;
    }

    public BigDecimal getMarginalTax() {
        return marginalTax;
    }

    public BigDecimal getIncomeThreshold() {
        return incomeThreshold;
    }

    public static class Builder {
        private BigDecimal defaultTax;
        private BigDecimal marginalTax;
        private BigDecimal incomeThreshold;

        public Builder setDefaultTax(BigDecimal defaultTax) {
            this.defaultTax = defaultTax;
            return this;
        }

        public Builder setMarginalTax(BigDecimal marginalTax) {
            this.marginalTax = marginalTax;
            return this;
        }

        public Builder setIncomeThreshold(BigDecimal incomeThreshold) {
            this.incomeThreshold = incomeThreshold;
            return this;
        }

        public IncomeTaxThreshold build() {
            return new IncomeTaxThreshold(defaultTax, marginalTax, incomeThreshold);
        }
    }
}
