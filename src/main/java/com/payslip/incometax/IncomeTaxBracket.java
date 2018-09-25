package com.payslip.incometax;

import java.math.BigDecimal;

public class IncomeTaxBracket {

    private BigDecimal minThreshold;
    private BigDecimal maxThreshold;

    public IncomeTaxBracket(BigDecimal minThreshold, BigDecimal maxThreshold) {
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
    }

    public IncomeTaxBracket() {
    }

    BigDecimal getMinThreshold() {
        return minThreshold;
    }

    BigDecimal getMaxThreshold() {
        return maxThreshold;
    }

    public static class Builder {
        private BigDecimal minThreshold;
        private BigDecimal maxThreshold;

        public Builder setMinThreshold(BigDecimal minThreshold) {
            this.minThreshold = minThreshold;
            return this;
        }

        public Builder setMaxThreshold(BigDecimal maxThreshold) {
            this.maxThreshold = maxThreshold;
            return this;
        }

        public IncomeTaxBracket build() {
            return new IncomeTaxBracket(minThreshold, maxThreshold);
        }
    }
}
