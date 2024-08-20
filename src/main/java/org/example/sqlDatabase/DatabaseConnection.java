package org.example.sqlDatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    final String DB_ULR = "jdbc:mysql://localhost:3306/employee?allowMultiQueries=true";
    final String PASSWORD = "";
    final String USER_NAME = "root";

    private DatabaseConnection(){

    }

    private static DatabaseConnection databaseConnection;

    public static DatabaseConnection getInstance(){
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }

    public Connection getConnection(){
        return getConnection(DB_ULR,USER_NAME,PASSWORD);
    }

    public static Connection getConnection(String dbURL, String userName, String password){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL,userName,password);
            System.out.println("Connection successfull");
        }catch (Exception e){
            System.out.println("Connetion fail");
            e.printStackTrace();
        }
        return conn;
    }
}
