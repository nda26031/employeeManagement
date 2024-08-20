package org.example.controller;

import org.example.data.Department;
import org.example.data.Employee;
import org.example.data.HRManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HRManagement {
    Scanner sc = new Scanner(System.in);

    //CREATE - add
    public void addEmployee(Employee employee, Connection connection) {
        System.out.println("Enter information employee want to add: ");
        System.out.println("Name: ");
        employee.setEmployeeName(sc.nextLine());
        System.out.println("Phone number: ");
        employee.setEmployeePhoneNumber(sc.nextLine());
        System.out.println("Job Title: ");
        employee.setEmployeeJobTitle(sc.nextLine());
        System.out.println("Salary: ");
        employee.setEmployeeSalary(sc.nextDouble());
        System.out.println("Department ID: ");
        employee.setDepartmentID(sc.nextInt());

        try {

            String query = "BEGIN;" +
                    "INSERT INTO `employee`.`employee` (employeeName, employeePhoneNumber, employeeJobTitle, employeeSalary, departmentID)" +
                    "VALUES (?, ?, ?, ?, ?);" +
                    "UPDATE `employee`.`department` SET `numberOfEmployees` = `numberOfEmployees` + 1 WHERE (`departmentID` = ?);" +
                    "COMMIT;";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getEmployeePhoneNumber());
            ps.setString(3, employee.getEmployeeJobTitle());
            ps.setDouble(4, employee.getEmployeeSalary());
            ps.setInt(5, employee.getDepartmentID());
            ps.setInt(6, employee.getDepartmentID());

            ps.executeUpdate();
            System.out.println("Add employee succesfully");
        } catch (SQLException e) {
            System.out.println("Add employee fail " + e);
        }
    }

    public void addDepartment(Department department, Connection connection) {
        System.out.println("Enter information department want to add: ");
        System.out.println("Name: ");
        department.setDepartmentName(sc.nextLine());
        System.out.println("Department Code: ");
        department.setDepartmentName(sc.nextLine());
        System.out.println("Location: ");
        department.setDepartmentName(sc.nextLine());
        System.out.println("Description: ");
        department.setDepartmentName(sc.nextLine());

        try {
            String query = "INSERT INTO `employee`.`department` (departmentName, departmentCode, departmentLocation, departmentDescription, numberOfEmployees)" +
                    "VALUES (?, ?, ?, ?, ?);";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, department.getDepartmentName());
            ps.setString(2, department.getDepartmentCode());
            ps.setString(3, department.getDepartmentLocation());
            ps.setString(4, department.getDepartmentDescription());
            ps.setInt(5, 0);
            ps.executeUpdate();
            System.out.println("Add department succesfully");
        } catch (SQLException e) {
            System.out.println("Add department fail " + e);
        }
    }

    //READ - get
    public void readAllDepartment(HRManager hrManager) {
        System.out.println("Department");
        for (int i = 0; i < hrManager.getDepartments().size(); i++) {
            System.out.println(hrManager.getDepartments().get(i).toString());
        }
    }

    public void readAllEmployee(HRManager hrManager) {
        System.out.println("Employee");
        for (int i = 0; i < hrManager.getEmployees().size(); i++) {
            System.out.println(hrManager.getEmployees().get(i).toString());
        }
    }

//UPDATE - update


    //REMOVE - delete
    public void deleteEmployee(Employee employee, Connection connection) {
        System.out.println("Enter id employee want to delete: ");
        employee.setEmployeeID(sc.nextInt());
        try {
            String query1 = "SELECT * FROM employee.employee WHERE (`employeeID` = ?);";
            int departmentID = 0;
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setInt(1, employee.getEmployeeID());
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                departmentID = resultSet.getInt("departmentID");
            } catch (SQLException e) {
                System.out.println("Read all department fail " + e);
            }
            System.out.println("DPID : " + departmentID);

            String query = "BEGIN;" +
                    "SET FOREIGN_KEY_CHECKS=0;" +
                    "DELETE FROM `employee`.`employee` WHERE (`employeeID` = ?);" +
                    "UPDATE `employee`.`department` SET `numberOfEmployees` = `numberOfEmployees` - 1 WHERE (`departmentID` = ?);" +
                    "SET FOREIGN_KEY_CHECKS=1;" +
                    "COMMIT;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, employee.getEmployeeID());
            preparedStatement.setInt(2, departmentID);

            if (preparedStatement.executeUpdate() < 0) {
                System.out.println("Delete employee fail ");
            }
            System.out.println("Delete department succesful");
        } catch (SQLException e) {
            System.out.println("Delete employee fail " + e);
        }
    }

    public void deleteDepartment(Department department, Connection connection) {
        System.out.println("Enter id department want to delete: ");
        department.setDepartmentID(sc.nextInt());

        try {
            String query = "BEGIN;" +
                    "SET FOREIGN_KEY_CHECKS=0;" +
                    "DELETE FROM `employee`.`department` WHERE (`departmentID` = ?);" +
                    "SET FOREIGN_KEY_CHECKS=1;" +
                    "COMMIT;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, department.getDepartmentID());

            if (preparedStatement.executeUpdate() < 0) {
                System.out.println("Delete department fail ");
            }
            System.out.println("Delete department succesful");
        } catch (SQLException e) {
            System.out.println("Delete department fail " + e);
        }
    }


}
