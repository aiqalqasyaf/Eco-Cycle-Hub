package RentBike;

import bean.BikeBean;
import dao.RentBikeDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class RentBikeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String bikeIdParam = request.getParameter("bikeId");
        String durationParam = request.getParameter("duration");
        String userIdParam = String.valueOf(session.getAttribute("userID"));

        if (bikeIdParam == null || bikeIdParam.isEmpty() || durationParam == null || durationParam.isEmpty() || userIdParam == null || userIdParam.isEmpty()) {
            request.setAttribute("errMessage", "Bike ID, duration, and user ID are required!");
            request.getRequestDispatcher("RentBike.jsp").forward(request, response);
            return;
        }

        try {
            int bikeId = Integer.parseInt(bikeIdParam);
            int duration = Integer.parseInt(durationParam);
            int userId = Integer.parseInt(userIdParam);

            RentBikeDao rentBikeDao = new RentBikeDao();
            String rentalResult = rentBikeDao.createRental(userId, bikeId, duration);
            String bikeResult = rentBikeDao.rentBike(bikeId);

            if (rentalResult.equals("SUCCESS") && bikeResult.equals("SUCCESS")) {
                List<BikeBean> availableBikes = rentBikeDao.getAvailableBikes();
                session.setAttribute("availableBikes", availableBikes);
                request.setAttribute("successMessage", "Bike rented successfully!");
                request.setAttribute("rentId", 1234); // Replace with real rent ID if generated
                request.setAttribute("bikeId", bikeId);
                request.setAttribute("duration", duration);
                request.getRequestDispatcher("RentBike.jsp").forward(request, response);
            } else {
                request.setAttribute("errMessage", bikeResult);
                request.getRequestDispatcher("RentBike.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("errMessage", "Invalid bike ID, duration, or user ID format!");
            request.getRequestDispatcher("RentBike.jsp").forward(request, response);
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
        return "Handles bike renting functionality";
    }
}
