package org.example.data;

public class Department {
    private int departmentID;
    private String departmentName;
    private String departmentCode;
    private String departmentLocation;
    private String departmentDescription ;
    private int numberOfEmployees;


    public Department(int departmentID, String departmentName, String departmentCode, String departmentLocation, String departmentDescription, int numberOfEmployees) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.departmentLocation = departmentLocation;
        this.departmentDescription = departmentDescription;
        this.numberOfEmployees = numberOfEmployees;
    }

    public Department() {
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentLocation='" + departmentLocation + '\'' +
                ", departmentDescription='" + departmentDescription + '\'' +
                ", numberOfEmployees=" + numberOfEmployees +
                '}';
    }
}
