<%-- 
    Document   : login
    Created on : 12 Jan 2025, 5:20:58 pm
    Author     : Aiqal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/header.css" />
        <link rel="stylesheet" type="text/css" href="css/login.css" />
        <link
            href="https://fonts.googleapis.com/css2?family=Parkinsans:wght@300..800&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet"
        />
        <title>Eco Cycle Hub</title>
    </head>
    <body>
        <header>
            <div class="header-container">
                <div
                    class="header-items"
                    id="page-logo"
                    style="flex-grow: 5"
                    style="margin-left: 0px"
                >
                    <p style="display: inline; font-size: 28px">
                        Eco Cycle Hub
                    </p>
                </div>
            </div>
            <div id="orange-line"></div>
        </header>

        <div class="background-image"></div>

        <div class="login-container">
            <div id="login-text-container">
                <h1 id="login-text">Login</h1>
            </div>

            <form action="LoginServlet" method="post">
                <div class="role-selection">
                    <label>
                        <input type="radio" name="role" value="user" />
                        User
                    </label>
                    <label>
                        <input
                            type="radio"
                            name="role"
                            value="admin"
                            required
                        />
                        Admin
                    </label>
                </div>
                <div class="form-group">
                    <input
                        type="text"
                        id="username"
                        name="username"
                        placeholder="Username"
                        required
                    />
                </div>
                <div class="form-group">
                    <input
                        type="password"
                        id="password"
                        name="password"
                        placeholder="Password"
                        required
                    />
                </div>
                
                <%-- Display invalid user credentials message --%>
                <c:if test="${not empty errMessage}">
                    <div style="color: red; text-align: center;">
                        <p>${errMessage}</p>
                    </div>
                </c:if>
                
                <%-- Display success sign up message --%>
                <c:if test="${not empty successMessage}">
                    <div style="color: green; text-align: center;">
                        <p>${successMessage}</p>
                    </div>
                </c:if>

                <button type="submit" class="submit-btn">Login</button>
                <div class="form-group">
                    <p>
                        Don't have an account?<span
                            ><a href="signup.jsp" class="link">
                                Sign Up</a
                            ></span
                        >
                    </p>
                </div>
            </form>
        </div>
    </body>
</html>

