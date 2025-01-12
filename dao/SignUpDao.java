/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import util.DBConnection;
import bean.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpDao {

    public String registerUser(UserBean userBean) {
        String name = userBean.getName();
        String email = userBean.getEmail();
        String password = userBean.getPassword();

        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = DBConnection.createConnection();
            String query = "INSERT INTO USERS (NAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";
            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                return "SUCCESS"; // Registration successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: Unable to register user. Please try again later.";
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return "Error: Unable to register user. Please try again later.";
    }
}

