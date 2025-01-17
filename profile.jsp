<%-- 
    Document   : profile
    Created on : 15 Jan 2025, 8:43:50 pm
    Author     : Aiqal
--%>

<%@ page import="java.util.List" %>
<%@ page import="bean.BikeBean" %>
<%@ page import="util.PasswordUtils" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/header.css" />
        <link rel="stylesheet" type="text/css" href="css/homestyle.css" />
        <link rel="stylesheet" type="text/css" href="css/profile.css" />
        <link rel="stylesheet" type="text/css" href="css/registeredBikes.css" />
        <link
            href="https://fonts.googleapis.com/css2?family=Parkinsans:wght@300..800&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet"
        />
        <title>Eco Cycle Hub</title>
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
                    <a class="navigation-items" style="display: inline" href="#"
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
                        ><%= session.getAttribute("username") %></a
                    >
                </div>
            </div>
            <div id="orange-line"></div>
        </header>
        <div class="background-image"></div>

        <div class="profile-container">
            <div class="user-info">
                <div class="user-info-row">
                    <p id="heading1">User Details</p>
                </div>
                <div class="user-info-row">
                    <label>Username</label>
                    <p id="user-fullname">
                        <%= session.getAttribute("username") != null ? session.getAttribute("username") : "" %>
                    </p>
                </div>
                    <div class="user-info-row">
                    <label>Password</label>
                    <p id="user-password">
                         <%= PasswordUtils.maskPassword((String) session.getAttribute("password")) %>
                    </p>
                </div>

                <div class="user-info-row">
                    <label>Email</label>
                    <p id="user-email">
                        <%= session.getAttribute("email") != null ? session.getAttribute("email") : "" %>
                    </p>
                </div>
                <div class="user-info-row">
                    <label>Address</label>
                    <p id="user-address">
                        <%= session.getAttribute("address") != null ? session.getAttribute("address") : "" %>
                    </p>
                </div>
                <div class="user-info-row">
                    <label>Phone Number</label>
                    <p id="user-phone">
                        <%= session.getAttribute("phone") != null ? session.getAttribute("phone") : "" %>
                    </p>
                </div>
            </div>
                     <%-- Display failed message --%>
                    <c:if test="${not empty errorMessage}">
                        <div style="color: red; text-align: center;">
                            <p>${errorMessage}</p>
                        </div>
                    </c:if>
                    
            <button
                class="edit-button"
                onclick="document.getElementById('editModal').style.display='flex'"
            >
                Edit
            </button>
        </div>
                    
        <div class="bikes-container">
        <h2>Registered Bikes</h2>
        <table class="bikes-table">
        <thead>
            <tr>
                <th>Bike ID</th>
                <th>Type</th>
                <th>Color</th>
                <th>Registration Date</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<BikeBean> bikes = (List<BikeBean>) session.getAttribute("bikeList");
                if (bikes != null && !bikes.isEmpty()) {
                    for (BikeBean bike : bikes) {
            %>
            <tr>
                <td><%= bike.getBikeId() %></td>
                <td><%= bike.getType() %></td>
                <td><%= bike.getColor() %></td>
                <td><%= bike.getRegistrationDate() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="6" style="text-align: center;">No bikes registered under this account.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>            
                    
        <!-- Modal -->
        <div id="editModal" class="modal">
            <div class="modal-content">
                <button
                    class="modal-close"
                    onclick="document.getElementById('editModal').style.display='none'"
                >
                    &times;
                </button>
                <h3>Edit Profile</h3>
                <form action="UpdateProfileServlet" method="POST">
                    <label for="edit-fullname">Full Name</label>
                    <input type="text" id="edit-fullname" name="username"
                    value="<%= session.getAttribute("username") != null ? session.getAttribute("username") : "" %>" />

                    <label for="edit-email">Email</label>
                    <input type="email" id="edit-email" name="email" 
                    value="<%= session.getAttribute("email") != null ? session.getAttribute("email") : "" %>" />
                    
                    <label for="edit-password">Password</label>
                     <div class="password-container">
                        <input type="password" id="edit-password" name="password"
                               value="<%= session.getAttribute("password") %>" />
                        <input type="checkbox" id="show-password" onclick="togglePassword()">Show Password
                    </div>

                    <label for="edit-address">Address</label>
                    <input type="text" id="edit-address" name="address"
                    value="<%= session.getAttribute("address") != null ? session.getAttribute("address") : "" %>" />

                    <label for="edit-phone">Phone Number</label>
                    <input type="tel" id="edit-phone" name="phone" 
                    value="<%= session.getAttribute("phone") != null ? session.getAttribute("phone") : "" %>" />

                    <button class="save-button" type="submit">Save</button>
                </form>
                    
                    <script>
                        function togglePassword() {
                            var passwordField = document.getElementById("edit-password");
                            var showPasswordCheckbox = document.getElementById("show-password");

                            if (showPasswordCheckbox.checked) {
                                passwordField.type = "text";
                            } else {
                                passwordField.type = "password";
                            }
                        }
                    </script>
            </div>
        </div>
    </body>
</html>

