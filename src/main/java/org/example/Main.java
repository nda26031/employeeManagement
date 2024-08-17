package org.example;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
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
        Connection conn = new DatabaseConnection().getConnection();

//      Initialization
        Employee employee = new Employee();
        Department department = new Department();
        Payroll payroll = new Payroll();
        EmployeeManagement employeeManagement = new EmployeeManagement();
        DepartmentManagement departmentManagement = new DepartmentManagement();
        HRManager hrManager = new HRManager(employeeManagement.readEmployees(conn), departmentManagement.readAllDepartment(conn), null);

        HRManagement hrManagement = new HRManagement();

//        hrManagement.addEmployee(employee, conn);
//        hrManagement.addDepartment(department, conn);
//
//        hrManagement.readAllDepartment(hrManager);
//        hrManagement.readAllEmployee(hrManager);
//
//        hrManagement.deleteEmployee(employee, conn);
//        hrManagement.deleteDepartment(department, conn);
//      change param to Department name and get all employee of that Department
        employeeManagement.listEmployeeWithDepartment(employee, department, conn);
        //Connect API
    }
    }