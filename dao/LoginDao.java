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

public class LoginDao {
    
    public String authenticateUser(LoginBean loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        String role = loginBean.getRole();
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            con = DBConnection.createConnection();
            if (con == null) {
                throw new SQLException("Failed to establish a database connection.");
            }

            statement = con.createStatement();

            if (role.equals("user")) {
                resultSet = statement.executeQuery("SELECT USERID, NAME, PASSWORD, EMAIL, ADDRESS, PHONE FROM USERS");

                while (resultSet.next()) {
                    String usernameDB = resultSet.getString("NAME");
                    String passwordDB = resultSet.getString("PASSWORD");

                    if (username.equals(usernameDB) && password.equals(passwordDB)) {
                        loginBean.setUserID(resultSet.getString("USERID")); // Set userID
                        loginBean.setEmail(resultSet.getString("EMAIL"));
                        loginBean.setAddress(resultSet.getString("ADDRESS"));
                        loginBean.setPhone(resultSet.getString("PHONE"));
                        return "SUCCESS";
                    }
                }
            } else if (role.equals("admin")) {
                resultSet = statement.executeQuery("SELECT ADMINID, NAME, PASSWORD FROM ADMIN");

                while (resultSet.next()) {
                    String usernameDB = resultSet.getString("NAME");
                    String passwordDB = resultSet.getString("PASSWORD");

                    if (username.equals(usernameDB) && password.equals(passwordDB)) {
                        loginBean.setUserID(resultSet.getString("ID")); // Set userID
                        return "SUCCESS";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error.";
        }

        return "Invalid username or password. Please try again.";
    }
}

