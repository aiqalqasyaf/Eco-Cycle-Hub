<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bean.BikeBean" %>
<%@ page import="dao.RentBikeDao" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/header.css" />
        <link rel="stylesheet" type="text/css" href="css/rentbike.css" />
        <link
            href="https://fonts.googleapis.com/css2?family=Parkinsans:wght@300..800&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900&display=swap"
            rel="stylesheet"
        />
        <title>Rent a Bike - Eco Cycle Hub</title>
    </head>
    <body>
        <header>
            <div class="header-container">
                <div class="header-items" id="page-logo" style="flex-grow: 5">
                    <p style="display: inline; font-size: 28px">
                        Eco Cycle Hub
                    </p>
                </div>
                <div class="header-items">
                    <a
                        class="navigation-items"
                        style="display: inline"
                        href="home.jsp"
                        >Home</a
                    >
                </div>
                <div class="header-items">
                    <a
                        class="navigation-items"
                        style="display: inline"
                        href="services.jsp"
                        >Services</a
                    >
                </div>
                <div class="header-items">
                    <a
                        class="navigation-items"
                        style="display: inline"
                        href="profile.jsp"
                        >Profile</a
                    >
                </div>
                <div id="blank-space"></div>
                <div class="user-icon" id="user-icon">
                    <img
                        src="img/user-icon.png"
                        alt="user-icon"
                        id="user-icon"
                    />
                </div>
                <div class="header-items" style="flex-shrink: 1">
                    <a
                        class="navigation-items"
                        style="display: inline; margin-right: 70px"
                        href="profile.jsp"
                        ><%=session.getAttribute("username") %></a
                    >
                </div>
            </div>
            <div id="orange-line"></div>
        </header>
                    
        <div class="background-image"></div>            

        <!-- Bike Renting Table Section -->
        <div class="rent-table-container">
            <h2>Available Bikes for Rent</h2>

            <%
                // Debugging data retrieval
                RentBikeDao bikeDao = new RentBikeDao();
                List<BikeBean> availableBikes = bikeDao.getAvailableBikes();
                request.setAttribute("availableBikes", availableBikes);

                if (availableBikes == null || availableBikes.isEmpty()) {
                    out.println("<p>No bikes available for rent at the moment.</p>");
                } else {
            %>
            <table class="rent-table">
                <thead>
                    <tr>
                        <th>Bike ID</th>
                        <th>Bike Type</th>
                        <th>Color</th>
                        <th>Ownership Type</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (BikeBean bike : availableBikes) {
                    %>
                    <tr>
                        <td><%= bike.getBikeId() %></td>
                        <td><%= bike.getType() %></td>
                        <td><%= bike.getColor() %></td>
                        <td><%= bike.getOwnershipType() %></td>
                        <td>
                            <form method="post" action="<%= request.getContextPath() %>/RentBikeServlet">
                                <input type="hidden" name="bikeId" value="<%= bike.getBikeId() %>" />
                                <label for="duration">Duration (hours):</label>
                                <input class="duration" type="number" name="duration" min="1" required />
                                <button type="submit" class="rent-btn">Rent</button>
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <%
                }
            %>
            
              <%-- Display invalid user credentials message --%>
                <c:if test="${not empty errMessage}">
                    <div class="statusMessage"style="color: red; text-align: center;">
                        <p>${errMessage}</p>
                    </div>
                </c:if>
                
                <%-- Display success sign up message --%>
                <c:if test="${not empty successMessage}">
                    <div class ="statusMessage" style="color: green; text-align: center;">
                        <p>${successMessage}</p>
                    </div>
                </c:if>
        </div>
        
    </body>
</html>
