/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SignUpServlet;

import dao.SignUpDao;
import bean.UserBean;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Aiqal
 */
public class SignUpServlet extends HttpServlet {

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

        // Retrieve parameters from the signup form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Set up the UserBean with the form data
        UserBean userBean = new UserBean();
        userBean.setName(name);
        userBean.setEmail(email);
        userBean.setPassword(password);

        // Use the SignUpDao to save the user data
        SignUpDao signUpDao = new SignUpDao();
        String registrationResult = signUpDao.registerUser(userBean);

        // Handle registration results
        if ("SUCCESS".equals(registrationResult)) {
            request.setAttribute("successMessage", "Registration successful! You can now log in.");
            request.getRequestDispatcher("/login.jsp").forward(request, response); // Redirect to login page
        } else {
            request.setAttribute("errMessage", registrationResult);
            request.getRequestDispatcher("/signup.jsp").forward(request, response); // Redirect back to signup page on failure
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "SignUp Servlet";
    }
    // </editor-fold>
}
