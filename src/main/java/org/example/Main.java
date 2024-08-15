package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        //Connection conn = new DatabaseConnection().getConnection();

//      Initialization
//        Employee employee = new Employee();
//        Department department = new Department();
//        Payroll payroll = new Payroll();
//        EmployeeManagement employeeManagement = new EmployeeManagement();
//        DepartmentManagement departmentManagement = new DepartmentManagement();
//        HRManager hrManager = new HRManager(employeeManagement.readEmployees(conn),departmentManagement.readAllDepartment(conn),null);
//
//        HRManagement hrManagement = new HRManagement();
//
//        hrManagement.addEmployee(employee, conn);
//        hrManagement.addDepartment(department, conn);

//        hrManagement.readAllDepartment(hrManager);
//        hrManagement.readAllEmployee(hrManager);
//
//        hrManagement.deleteEmployee(employee, conn);
//        hrManagement.deleteDepartment(department, conn);
        //TODO: change param to Department name and get all employee of that Department
        //hrManagement.listEmployeeWithDepartment(hrManager);
        //Connect API
        URL url = new URL("https://run.mocky.io/v3/fcfd722e-7879-482c-86e1-91c5a5c3a94e");
        //open connection
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        //Đọc dữ liệu từ API
        BufferedReader inputStream  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = inputStream.readLine()) != null) {
            response.append(inputLine);
        }

        //lúc này response là string dưới dạng JSON
        //parse json.
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        //lúc này json đã thành Person object đối chiếu với kết quả của json nhận được

        Person person = gson.fromJson(String.valueOf(response), Person.class);
        System.out.println(person.toString());
    }

}

/**
 * {
 * "name": "Phuc",
 * "age": 23,
 * "status": "open"
 * }
 */
class Person {
    String old;
    String name;
    String status;

    public Person(String old, String name, String status) {
        this.old = old;
        this.name = name;
        this.status = status;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String age) {
        this.old = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age='" + old + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }
}