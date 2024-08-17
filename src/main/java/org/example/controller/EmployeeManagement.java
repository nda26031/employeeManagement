package org.example.controller;

import org.example.data.Department;
import org.example.data.Employee;

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

    public List<Employee> listEmployeeWithDepartment(Employee employee,Department department, Connection connection) {
        System.out.println("Enter Department Name want to list: ");
        department.setDepartmentName(new Scanner(System.in).nextLine());
        String departmentId = "";
        try {
            String query1 = "SELECT * FROM employee.department WHERE (`departmentName` = ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setString(1,department.getDepartmentName());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            departmentId = resultSet.getString("departmentName");
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
        return employees;
    }
}
