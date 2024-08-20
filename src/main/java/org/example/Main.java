package org.example;

import org.example.controller.DepartmentManagement;
import org.example.controller.EmployeeManagement;
import org.example.controller.HRManagement;
import org.example.data.Department;
import org.example.data.Employee;
import org.example.data.HRManager;
import org.example.data.Payroll;
import org.example.sqlDatabase.DatabaseConnection;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws IOException {
//      Connect database
        DatabaseConnection conn = DatabaseConnection.getInstance();
        conn.getConnection();

//      Initialization
        Employee employee = new Employee();
        Department department = new Department();
        Payroll payroll = new Payroll();
        EmployeeManagement employeeManagement = new EmployeeManagement();
        DepartmentManagement departmentManagement = new DepartmentManagement();
        HRManager hrManager = new HRManager(employeeManagement.readEmployees((Connection) conn), departmentManagement.readAllDepartment((Connection)conn), null);

        HRManagement hrManagement = new HRManagement();

        hrManagement.readAllEmployee(hrManager);
        hrManagement.readAllDepartment(hrManager);

        hrManagement.addEmployee(employee, (Connection)conn);
        hrManagement.addDepartment(department, (Connection)conn);
//
        hrManagement.deleteEmployee(employee, (Connection)conn);
        hrManagement.deleteDepartment(department, (Connection)conn);

        employeeManagement.listEmployeeWithDepartment(employee, department, (Connection)conn);
        //Connect API
    }
    }