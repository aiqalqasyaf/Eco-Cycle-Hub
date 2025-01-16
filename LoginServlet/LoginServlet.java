/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package LoginServlet;

import dao.LoginDao;
import bean.LoginBean;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Aiqal
 */
public class LoginServlet extends HttpServlet {

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

    // Retrieve parameters from the request
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String role = request.getParameter("role"); // Get the role value (admin or user)

    // Set up the LoginBean with the username, password, and role
    LoginBean loginbean = new LoginBean();
    loginbean.setUsername(username);
    loginbean.setPassword(password);
    loginbean.setRole(role); // Add a role property in your LoginBean class if it doesn't exist

    // Authenticate the user with the role
    LoginDao loginDao = new LoginDao();
    String userValidate = loginDao.authenticateUser(loginbean); // You may need to update LoginDao for role validation

    // Handle authentication results
    if (userValidate.equals("SUCCESS")) {
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("role", role);

        // Assuming you fetch additional user details like email, address, and phone:
        session.setAttribute("email", loginbean.getEmail());
        session.setAttribute("address", loginbean.getAddress());
        session.setAttribute("phone", loginbean.getPhone());
        session.setAttribute("password", loginbean.getPassword());

        // Redirect based on the role
        if ("admin".equals(role)) {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else if ("user".equals(role)) {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
    } else {
        request.setAttribute("errMessage", userValidate);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
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
