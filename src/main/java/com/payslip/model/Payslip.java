package com.payslip.model;

import java.math.BigDecimal;

public class Payslip {

    private String name;
    private String payPeriod;
    private BigDecimal grossIncome;
    private BigDecimal incomeTax;
    private BigDecimal netIncome;
    private BigDecimal superRate;

    public Payslip(String name, String payPeriod, BigDecimal grossIncome, BigDecimal incomeTax, BigDecimal netIncome, BigDecimal superRate) {
        this.name = name;
        this.payPeriod = payPeriod;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superRate = superRate;
    }

    public Payslip() {
    }

    public String getName() {
        return name;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public BigDecimal getGrossIncome() {
        return grossIncome;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public BigDecimal getSuperRate() {
        return superRate;
    }

    public static class Builder {
        private String name;
        private String payPeriod;
        private BigDecimal grossIncome;
        private BigDecimal incomeTax;
        private BigDecimal netIncome;
        private BigDecimal superRate;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPayPeriod(String payPeriod) {
            this.payPeriod = payPeriod;
            return this;
        }

        public Builder setGrossIncome(BigDecimal grossIncome) {
            this.grossIncome = grossIncome;
            return this;
        }

        public Builder setIncomeTax(BigDecimal incomeTax) {
            this.incomeTax = incomeTax;
            return this;
        }

        public Builder setNetIncome(BigDecimal netIncome) {
            this.netIncome = netIncome;
            return this;
        }

        public Builder setSuperRate(BigDecimal superRate) {
            this.superRate = superRate;
            return this;
        }

        public Payslip build() {
            return new Payslip(name, payPeriod, grossIncome, incomeTax, netIncome, superRate);
        }
    }
}
