/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import util.DBConnection;
import bean.LoginBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aiqal
 */
public class LoginDao {
    
    public String authenticateUser (LoginBean loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        String role = loginBean.getRole();
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String usernameDB = null;
        String passwordDB = null;
        
        try {
            con = DBConnection.createConnection();
             if (con == null) {
                throw new SQLException("Failed to establish a database connection.");
            }
             
            statement = con.createStatement();
            
            if (role.equals("user")) {
                resultSet = statement.executeQuery("SELECT NAME, PASSWORD FROM USERS");

                while (resultSet.next()) {
                    usernameDB = resultSet.getString("NAME");
                    passwordDB = resultSet.getString("PASSWORD");
                
                    if(username.equals(usernameDB) && password.equals(passwordDB))
                    return "SUCCESS";
                }
            } else if (role.equals("admin")) {
                resultSet = statement.executeQuery("SELECT NAME, PASSWORD FROM ADMIN");
                
                while (resultSet.next()) {
                    usernameDB = resultSet.getString("NAME");
                    passwordDB = resultSet.getString("PASSWORD");
               
                    if(username.equals(usernameDB) && password.equals(passwordDB))
                    return "SUCCESS";
                }
            }
            
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return "Invalid username or password. Please try again.";
    }
}
