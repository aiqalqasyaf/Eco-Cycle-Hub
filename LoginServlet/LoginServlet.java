/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package LoginServlet;

import dao.LoginDao;
import dao.RegisterBikeDao;
import bean.LoginBean;
import bean.BikeBean;

import java.util.List;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        LoginBean loginbean = new LoginBean();
        loginbean.setUsername(username);
        loginbean.setPassword(password);
        loginbean.setRole(role);

        LoginDao loginDao = new LoginDao();
        String userValidate = loginDao.authenticateUser(loginbean);

        if (userValidate.equals("SUCCESS")) {
            HttpSession session = request.getSession();
            session.setAttribute("userID", loginbean.getUserID()); // Add userID to the session
            session.setAttribute("username", username);
            session.setAttribute("role", role);
            session.setAttribute("email", loginbean.getEmail());
            session.setAttribute("address", loginbean.getAddress());
            session.setAttribute("phone", loginbean.getPhone());
            session.setAttribute("password", loginbean.getPassword());
            
            int userID = Integer.parseInt(loginbean.getUserID());
            RegisterBikeDao bikeDao = new RegisterBikeDao();
            List<BikeBean> bikeList = bikeDao.getBikesByUserId(userID);
            session.setAttribute("bikeList", bikeList);

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
        return "Short description";
    }
}

