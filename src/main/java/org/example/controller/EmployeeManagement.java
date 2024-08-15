package org.example.controller;

import org.example.data.Department;
import org.example.data.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
    public void createEmployee(Employee employee, Connection connection) {
//        try {
//
//            String query = "BEGIN;" +
//                    "INSERT INTO Employee (employeeName, employeePhoneNumber, employeeJobTitle, employeeSalary, departmentID)" +
//                    "VALUES (?, ?, ?, ?, ?);" +
//                    "UPDATE Department SET `numberOfEmployees` = `numberOfEmployees` + 1 WHERE `departmentID` = ?;" +
//                    "COMMIT;";
//
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, employee.getEmployeeName());
//            ps.setString(2, employee.getEmployeePhoneNumber());
//            ps.setString(3, employee.getEmployeeJobTitle());
//            ps.setDouble(4, employee.getEmployeeSalary());
//            ps.setInt(5, employee.getDepartmentID());
//            ps.setInt(6, employee.getDepartmentID());
//
//            ps.executeUpdate();
//            System.out.println("Add employee succesfully");
//        } catch (SQLException e) {
//            System.out.println("Add employee fail " + e);
//        }
    }

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
            System.out.println("Read all department fail " + e);
        }
        return employees;
    }

    public List<Employee> listEmployeeWithDepartment(Employee employee, Connection connection) {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employee.employee WHERE (`getDepartmentID` = ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,employee.getDepartmentID());
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


    public void deleteEmployee(Employee employee, Connection connection) {
//        try {
//            String query = "DELETE FROM `employee`.`employee` WHERE (`employeeID` = ?);";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, employee.getEmployeeID());
//
//            if(preparedStatement.executeUpdate()<0){
//                System.out.println("Delete employee fail ");
//            }
//            System.out.println("Delete department succesful");
//        } catch (SQLException e) {
//            System.out.println("Delete employee fail " + e);
//        }
    }
}
