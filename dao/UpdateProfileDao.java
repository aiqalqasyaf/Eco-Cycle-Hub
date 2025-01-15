/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.UpdateUserBean;
import java.sql.*;
import util.DBConnection;

public class UpdateProfileDao {
    public String updateUser(UpdateUserBean updateUserBean) {
        String username = updateUserBean.getUsername();
        String password = updateUserBean.getPassword();
        String email = updateUserBean.getEmail();
        String address = updateUserBean.getAddress();
        String phone = updateUserBean.getPhone();

        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish database connection
            con = DBConnection.createConnection();
            if (con == null) {
                throw new SQLException("Failed to establish a database connection.");
            }

            // Update query
            String query = "UPDATE users SET name = ?, password = ?, email = ?, address = ?, phone = ? WHERE name = ?";

            // Prepare the statement
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, username);

            // Execute the update
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                return "SUCCESS"; // Indicate successful update
            } else {
                return "User not found or no changes made."; // No rows updated
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error while updating user profile: " + e.getMessage();
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

