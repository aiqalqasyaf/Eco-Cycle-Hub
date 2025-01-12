/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aiqal
 */
public class DBConnection {
    
   public static Connection createConnection() {
    Connection conn = null;
    String url = "jdbc:derby://localhost:1527/EcoCycleHub;create=true";
    String username = "app";
    String password = "app";
    
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection(url, username, password);
        if (conn != null) {
            System.out.println("Database connection established successfully.");
        } else {
            System.out.println("Database connection failed.");
        }
    } catch (SQLException e) {
        System.out.println("Database Driver not found!");
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        System.out.println("Error connecting to the database!");
        e.printStackTrace();
    }
    return conn;
    }

}

