package org.example.data;

import java.time.LocalDate;

public class Payroll {
    private int payrollID;
    private int employeeID;
    private double basicSalary;
    private double allowances;
    private double deductions;
    private double netSalary;
    private LocalDate paymentDate;

    public Payroll(int payrollID, int employeeID, double basicSalary, double allowances, double deductions, double netSalary, LocalDate paymentDate) {
        this.payrollID = payrollID;
        this.employeeID = employeeID;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.deductions = deductions;
        this.netSalary = netSalary;
        this.paymentDate = paymentDate;
    }

    public Payroll() {
    }

    public int getPayrollID() {
        return payrollID;
    }

    public void setPayrollID(int payrollID) {
        this.payrollID = payrollID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getAllowances() {
        return allowances;
    }

    public void setAllowances(double allowances) {
        this.allowances = allowances;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "payrollID=" + payrollID +
                ", employeeID=" + employeeID +
                ", basicSalary=" + basicSalary +
                ", allowances=" + allowances +
                ", deductions=" + deductions +
                ", netSalary=" + netSalary +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
