package org.example.controller;

import org.example.data.Department;
import org.example.data.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentManagement {
//    //CREATE - add
//    public void createDepartment(Department department, Connection connection) {
//        try {
//            String query = "INSERT INTO Department (departmentName, departmentLocation, departmentDescription, numberOfEmployees)" +
//                    "VALUES (?, ?, ?, ?);";
//
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, department.getDepartmentName());
//            ps.setInt(2, 0);
//            ps.executeUpdate();
//            System.out.println("Add department succesfully");
//        } catch (SQLException e) {
//            System.out.println("Add department fail " + e);
//        }
//    }

//READ - get
public List<Department> readAllDepartment(Connection connection) {
    List<Department> departments = null;
    try {
        departments = new ArrayList<>();
        String query = "SELECT * FROM employee.department;";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Department department = new Department(rs.getInt("departmentID"), rs.getString("departmentName"), rs.getString("departmentCode"), rs.getString("departmentLocation"), rs.getString("departmentDescription"), rs.getInt("numberOfEmployees"));
            departments.add(department);
        }
    } catch (SQLException e) {
        System.out.println("Read all department fail " + e);
    }
    return departments;
}

    public List<Department> listDepartment(Connection connection) {
        List<Department> departments = null;
        try {
            departments = new ArrayList<>();
            String query = "SELECT * FROM employee.department;";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department(rs.getInt("departmentID"), rs.getString("departmentName"), rs.getString("departmentCode"), rs.getString("departmentLocation"), rs.getString("departmentDescription"), rs.getInt("numberOfEmployees"));
                departments.add(department);
            }
        } catch (SQLException e) {
            System.out.println("Read all department fail " + e);
        }
        return departments;
    }

//UPDATE - update


//DELETE - delete
public void deleteDepartment(Department department, Connection connection) {
//    try {
//        String query = "DELETE FROM `employee`.`employee` WHERE (`employeeID` = ?);";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setInt(1, department.getDepartmentID());
//
//        if(preparedStatement.executeUpdate()<0){
//            System.out.println("Delete department fail ");
//        }
//        System.out.println("Delete department succesful");
//    } catch (SQLException e) {
//        System.out.println("Delete department fail " + e);
//    }
}
}
