<%-- 
    Document   : services
    Created on : 15 Jan 2025, 3:52:16 pm
    Author     : Aiqal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/header.css" />
        <link rel="stylesheet" type="text/css" href="css/services.css" />
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

        <div class="services-container">
            <div class="services-item">
                <img src="img/bike-1.webp" alt="bike" />
                <a href="#" class="button">Register a Bike</a>
            </div>
            <div class="services-item">
                <img src="img/bike-2.webp" alt="bike" />
                <a href="parkbike.html" class="button">Park a Bike</a>
            </div>
            <div class="services-item">
                <img src="img/bike-3.webp" alt="bike" />
                <a href="rentbike.html" class="button">Rent a Bike</a>
            </div>
            <div class="services-item"></div>
        </div>

        <div class="pic-container" id="pic-2">
            <img
                src="img/services-pic-1.webp"
                alt="home-pic-2"
                id="home-pic-2"
            />
            <div class="color-tint-2"></div>
            <div class="tint-content-left">
                <div class="item">
                    <h3>WORRY LESS ABOUT YOUR BIKE</h3>
                    <p>
                        Lorem ipsum dolor sit amet, consectetuer adipiscing
                        elit. Aenean commodo ligula eget dolor. Aenean
                    </p>
                    <p>
                        massa. Cum sociis natoque penatibus et magnis dis
                        parturient montes, nascetur ridiculus mus.
                    </p>
                </div>
            </div>
        </div>
    </body>
</html>

