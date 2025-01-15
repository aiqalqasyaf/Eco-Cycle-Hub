/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package UpdateProfileServlet;

import dao.UpdateProfileDao;
import bean.UpdateUserBean;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Aiqal
 */
public class UpdateProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Retrieve form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        
        // Initialize the UpdateUserBean
        UpdateUserBean updateUserBean = new UpdateUserBean();
        updateUserBean.setUsername(username);
        updateUserBean.setPassword(password);
        updateUserBean.setEmail(email);
        updateUserBean.setAddress(address);
        updateUserBean.setPhone(phone);
        
        // DAO invocation
        UpdateProfileDao upDao = new UpdateProfileDao();
        String result = upDao.updateUser(updateUserBean);
        
        // Handle the result
        if (result.equals("SUCCESS")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("email", email);
            session.setAttribute("address", address);
            session.setAttribute("phone", phone);
            // Redirect or forward to a success page
            request.getRequestDispatcher("/profile.jsp").forward(request, response); // Adjust the path if necessary
        } else {
            // Redirect or forward to an error page
            request.setAttribute("errorMessage", result);
            request.getRequestDispatcher("/profile.jsp").forward(request, response); // Adjust the path if necessary
        }
    }

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
        return "Handles profile update requests";
    }
}
