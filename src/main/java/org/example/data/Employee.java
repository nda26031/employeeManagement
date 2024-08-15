package org.example.data;

public class Employee {
    private int employeeID;
    private String employeeName;
    private String employeePhoneNumber;
    private String employeeJobTitle;
    private double employeeSalary;
    private int departmentID;

    public Employee(int employeeID, String employeeName, String employeePhoneNumber, String employeeJobTitle, double employeeSalary, int departmentID) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeJobTitle = employeeJobTitle;
        this.employeeSalary = employeeSalary;
        this.departmentID = departmentID;
    }

    public Employee() {
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeJobTitle() {
        return employeeJobTitle;
    }

    public void setEmployeeJobTitle(String employeeJobTitle) {
        this.employeeJobTitle = employeeJobTitle;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", employeePhoneNumber='" + employeePhoneNumber + '\'' +
                ", employeeJobTitle='" + employeeJobTitle + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", departmentID=" + departmentID +
                '}';
    }
}


