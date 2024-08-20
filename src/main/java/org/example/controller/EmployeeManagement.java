package org.example.controller;

import org.example.data.Department;
import org.example.data.Employee;
import org.example.data.HRManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    public List<Employee> readEmployees(Connection connection) {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employee.employee;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("employeeID"), resultSet.getString("employeeName"), resultSet.getString("employeePhoneNumber"), resultSet.getString("employeeJobTitle"), resultSet.getDouble("employeeSalary"), resultSet.getInt("departmentID"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Read all department fail: " + e);
        }
        return employees;
    }

    public List<Employee> listEmployeeWithDepartment(Employee employee, Department department, Connection connection) {
        System.out.println("Enter Department Name want to list: ");
        department.setDepartmentName(new Scanner(System.in).nextLine());
        String departmentId = "";
        try {
            String query1 = "SELECT * FROM employee.department WHERE (`departmentName` = ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setString(1,department.getDepartmentName());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                departmentId = resultSet.getString("departmentId");
            }else {
                System.out.println("Department not found.");
            }
        }catch (SQLException e){
            System.out.println("Can find department Name" + e);
        }

        System.out.println("DPName : " + departmentId);

        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employee.employee WHERE (`departmentID` = ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,departmentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employee = new Employee(resultSet.getInt("employeeID"), resultSet.getString("employeeName"), resultSet.getString("employeePhoneNumber"), resultSet.getString("employeeJobTitle"), resultSet.getDouble("employeeSalary"), resultSet.getInt("departmentID"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("List employee fail " + e);
        }

        for (Employee emp : employees) {
            System.out.println("Employee ID: " + emp.getEmployeeID());
            System.out.println("Employee Name: " + emp.getEmployeeName());
            System.out.println("Employee Phone Number: " + emp.getEmployeePhoneNumber());
            System.out.println("Employee Job Title: " + emp.getEmployeeJobTitle());
            System.out.println("Employee Salary: " + emp.getEmployeeSalary());
            System.out.println("Department ID: " + emp.getDepartmentID());
            System.out.println("-----------------------------");
        }


        return employees;
    }
}
