/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import bean.*;
import java.time.LocalDate;
import java.sql.*;
import util.DBConnection;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Aiqal
 */
public class RegisterBikeDao {
    
    public String registerBike(BikeBean bikeBean, LoginBean loginBean) { 
        String type = bikeBean.getType();
        String color = bikeBean.getColor();
        String username = loginBean.getUsername();
        int userID = Integer.parseInt(loginBean.getUserID());
        String ownershipType = "User";
        
        Date sqlRegistrationDate = Date.valueOf(LocalDate.now());
        
        Connection con = null;  
        PreparedStatement ps = null;
        
        try {
            con = DBConnection.createConnection();
            if (con == null) {
                throw new SQLException("Failed to establish a database connection");
            }
            
            String query = "INSERT INTO BIKE (TYPE, USERID, COLOR, REGISTRATIONDATE, STATUS, OWNERSHIPTYPE) VALUES (?, ?, ? ,? ,?, ?)";
            ps = con.prepareStatement(query);
            
            ps.setString(1, type);
            ps.setInt(2, userID);
            ps.setString(3, color);
            ps.setDate(4, sqlRegistrationDate);
            ps.setString(5, "Unavailable"); 
            ps.setString(6, ownershipType);
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                return "SUCCESS";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: Unable to register bike. Please try again later.";
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "Error: Unable to register bike. Please try again later.";
    }
    
    public List<BikeBean> getBikesByUserId(int userId) {
        List<BikeBean> bikeList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBConnection.createConnection();
            if (con == null) {
                throw new SQLException("Failed to establish a database connection");
            }

            String query = "SELECT * FROM BIKE WHERE USERID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            while (rs.next()) {
                BikeBean bike = new BikeBean();
                bike.setBikeId(rs.getInt("BIKEID")); // Assuming BikeBean has a setBikeId method
                bike.setType(rs.getString("TYPE"));
                bike.setColor(rs.getString("COLOR"));
                bike.setRegistrationDate(rs.getString("REGISTRATIONDATE"));
                bike.setStatus(rs.getString("STATUS"));
                bike.setOwnershipType(rs.getString("OWNERSHIPTYPE"));
                bikeList.add(bike);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return bikeList;
    }
}
