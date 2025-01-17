<%-- 
    Document   : registerbike
    Created on : 17 Jan 2025, 1:05:19 am
    Author     : Aiqal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/header.css" />
        <link rel="stylesheet" type="text/css" href="css/registerbike.css" />
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

        <div class="registerBikeForm">
            <form action="RegisterBikeServlet" method="post">
                <div class="secondContainer">
                    <h2 id="heading1">Register a Bike</h2>
                    <h2>Bike Details</h2>
                    <div class="container-items">
                        <input
                            type="text"
                            id="type"
                            name="type"
                            placeholder="Type"
                            required
                        />
                    </div>
                    <div class="container-items">
                        <input
                            type="text"
                            id="color"
                            name="color"
                            placeholder="Color"
                            required
                        />
                    </div>
                </div>
                 <%-- Display failed registration --%>
                <c:if test="${not empty errMessage}">
                    <div style="color: red; text-align: center;">
                        <p>${errMessage}</p>
                    </div>
                </c:if>
                
                <%-- Display successful bike registration --%>
                <c:if test="${not empty successMessage}">
                    <div style="color: green; text-align: center;">
                        <p>${successMessage}</p>
                    </div>
                </c:if>
                <div class="submitContainer">
                    <button type="submit" class="submit-btn">Submit</button>
                </div>
            </form>
        </div>
    </body>
</html>

