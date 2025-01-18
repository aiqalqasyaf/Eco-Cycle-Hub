package dao;

import bean.BikeBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class RentBikeDao {

    public List<BikeBean> getAvailableBikes() {
        List<BikeBean> bikeList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBConnection.createConnection();
            String query = "SELECT * FROM BIKE WHERE STATUS = 'Available' AND OWNERSHIPTYPE = 'RentalSystem'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                BikeBean bike = new BikeBean();
                bike.setBikeId(rs.getInt("BIKEID"));
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

    public String rentBike(int bikeId) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.createConnection();
            String query = "UPDATE BIKE SET STATUS = 'Unavailable' WHERE BIKEID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, bikeId);

            int result = ps.executeUpdate();
            if (result > 0) {
                return "SUCCESS";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: Unable to rent bike. Please try again later.";
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return "Error: Unable to rent bike. Please try again later.";
    }

    public String createRental(int userId, int bikeId, int durationtime) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.createConnection();
            String query = "INSERT INTO RENTBIKE (USERID, BIKEID, DURATIONTIME, STATUS) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, bikeId);
            ps.setInt(3, durationtime);
            ps.setString(4, "Ongoing");

            int result = ps.executeUpdate();
            if (result > 0) {
                return "SUCCESS";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: Unable to process rental. Please try again later.";
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return "Error: Unable to process rental. Please try again later.";
    }
}
