<%-- 
    Document   : signup
    Created on : 12 Jan 2025, 5:38:33 pm
    Author     : Aiqal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/header.css" />
        <link rel="stylesheet" type="text/css" href="css/signup.css" />
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
            </div>
            <div id="orange-line"></div>
        </header>

        <div class="background-image"></div>

        <div class="login-container">
            <div id="login-text-container">
                <h1 id="login-text">Sign Up</h1>
            </div>
            <form action="SignUpServlet" method="post">
                <div class="form-group">
                    <input
                        type="text"
                        id="name"
                        name="name"
                        placeholder="Name"
                        required
                    />
                </div>
                <div class="form-group">
                    <input
                        type="email"
                        id="email"
                        name="email"
                        placeholder="Email Address"
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
                <button type="submit" class="submit-btn">Sign Up</button>
                <div class="form-group">
                    <p>
                        Already have an account?<span
                            ><a href="login.jsp" class="link">
                                Sign In</a
                            ></span
                        >
                    </p>
                </div>
            </form>
        </div>
    </body>
</html>

