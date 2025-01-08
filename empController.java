/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

/**
 *
 * @author Aiqal
 */

import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/emp.controller")
public class empController extends HttpServlet {

    private static final String JDBC_URL = "jdbc:derby://localhost:1527/emp";
    private static final String JDBC_USER = "app";
    private static final String JDBC_PASSWORD = "app";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            int salary = Integer.parseInt(request.getParameter("salary"));
            String designation = request.getParameter("designation");

            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                String sql = "INSERT INTO staff (NAME, SALARY, DESIGNATION) VALUES (?, ?, ?)";
                PreparedStatement pstmt = connection.prepareStatement(sql);

                pstmt.setString(1, name);
                pstmt.setInt(2, salary);
                pstmt.setString(3, designation);

                pstmt.executeUpdate();

                // If successful, forward to success.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
                dispatcher.forward(request, response);

            } catch (Exception e) {
                // If an error occurs, forward to error.jsp
                request.setAttribute("errorMessage", e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int salary = Integer.parseInt(request.getParameter("salary"));
            String designation = request.getParameter("designation");

            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                String sql = "UPDATE staff SET NAME = ?, SALARY = ?, DESIGNATION = ? WHERE ID = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);

                pstmt.setString(1, name);
                pstmt.setInt(2, salary);
                pstmt.setString(3, designation);
                pstmt.setInt(4, id);

                pstmt.executeUpdate();

                // If successful, forward to success.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
                dispatcher.forward(request, response);

            } catch (Exception e) {
                // If an error occurs, forward to error.jsp
                request.setAttribute("errorMessage", e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

