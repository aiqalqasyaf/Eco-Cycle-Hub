/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package RegisterBikeServlet;

import bean.*;
import dao.RegisterBikeDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 *
 * @author Aiqal
 */
public class RegisterBikeServlet extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false); // Avoid creating a new session
        
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp"); // Redirect if session or username doesn't exist
            return;
        }
        
        String type = request.getParameter("type");
        String color = request.getParameter("color");
        
        if (type == null || type.isEmpty() || color == null || color.isEmpty()) {
            request.setAttribute("errMessage", "Bike type and color are required!");
            request.getRequestDispatcher("/registerbike.jsp").forward(request, response);
            return;
        }
        
        String username = (String) session.getAttribute("username");
        String userID = String.valueOf(session.getAttribute("userID"));
        
        BikeBean bikeBean = new BikeBean();
        bikeBean.setType(type);
        bikeBean.setColor(color);
        
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setUserID(userID);
        
        // DAO invocation
        RegisterBikeDao regbike = new RegisterBikeDao();
        String result = regbike.registerBike(bikeBean, loginBean);
        
        // Handle result
        if (result.equals("SUCCESS")) {
            RegisterBikeDao regbikeDao = new RegisterBikeDao();
            List<BikeBean> updatedBikeList = regbikeDao.getBikesByUserId(Integer.parseInt(userID));

            // Update session attribute
            session.setAttribute("bikeList", updatedBikeList);

            request.setAttribute("successMessage", "Bike registered! You may check your profile.");
            request.getRequestDispatcher("/registerbike.jsp").forward(request, response);
        } else {
            request.setAttribute("errMessage", result);
            request.getRequestDispatcher("/registerbike.jsp").forward(request, response); // Redirect back to signup page on failure
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
