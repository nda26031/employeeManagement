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
}
