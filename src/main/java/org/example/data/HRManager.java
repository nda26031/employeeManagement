package org.example.data;

import java.util.List;

public class HRManager {
    private List<Employee> employees;
    private List<Department> departments;
    private List<Payroll> payrolls;

    public HRManager(List<Employee> employees, List<Department> departments, List<Payroll> payrolls) {
        this.employees = employees;
        this.departments = departments;
        this.payrolls = payrolls;
    }

    public List<Employee> getEmployees() {
        return employees;
    }


    public List<Department> getDepartments() {
        return departments;
    }


    public List<Payroll> getPayrolls() {
        return payrolls;
    }

}
