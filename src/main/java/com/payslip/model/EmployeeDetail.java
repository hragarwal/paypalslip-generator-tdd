package com.payslip.model;

import java.math.BigDecimal;

public class EmployeeDetail {
    private Employee employee;
    private BigDecimal annualSalary;
    private int superRate;
    private String payPeriod;

    public EmployeeDetail(Employee employee, BigDecimal annualSalary, int superRate, String payPeriod) {
        this.employee = employee;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
        this.payPeriod = payPeriod;
    }

    EmployeeDetail() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public int getSuperRate() {
        return superRate;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public static class Builder {
        private Employee employee;
        private BigDecimal annualSalary;
        private int superRate;
        private String payPeriod;

        public Builder setEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Builder setAnnualSalary(BigDecimal annualSalary) {
            this.annualSalary = annualSalary;
            return this;
        }

        public Builder setSuperRate(int superRate) {
            this.superRate = superRate;
            return this;
        }

        public Builder setPayPeriod(String payPeriod) {
            this.payPeriod = payPeriod;
            return this;
        }

        public EmployeeDetail build() {
            return new EmployeeDetail(employee, annualSalary, superRate, payPeriod);
        }
    }

}
