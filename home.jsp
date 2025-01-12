<%-- 
    Document   : home
    Created on : 12 Jan 2025, 7:13:46 pm
    Author     : Aiqal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/header.css" />
        <link rel="stylesheet" type="text/css" href="css/homestyle.css" />
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
                        href="/html/index.html"
                        >Home</a
                    >
                </div>
                <div class="header-items">
                    <a
                        class="navigation-items"
                        style="display: inline"
                        href="/html/services.html"
                        >Services</a
                    >
                </div>
                <div class="header-items">
                    <a
                        class="navigation-items"
                        style="display: inline"
                        href="#"
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
                        href="/html/profile.jsp"
                        ><%=request.getAttribute("username")%></a
                    >
                </div>
            </div>
            <div id="orange-line"></div>
        </header>
        <div class="pic-container">
            <img src="img/home-pic-1.webp" alt="home-pic-1" id="home-pic-1" />
            <div class="color-tint"></div>
            <div class="text-overlay">
                <div class="text-top">WE SAVE IT</div>
                <div class="text-bottom">FOR YOU</div>
            </div>
        </div>

        <div class="content-wrapper">
            <p id="tagline">Eco Cycle Hub, A Space For Your Ride</p>
            <div id="sec-orange-line">
                <div id="another-orange-line"></div>
            </div>
        </div>
        <p style="font-size: 30px; text-align: center; margin-top: 15px">
            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean
            commodo ligula eget dolor. Aenean massa. Cum sociis natoque
            penatibus et magnis dis parturient montes, nascetur ridiculus mus.
            Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.
            Nulla consequat massa quis enim. ndum sodales, augue velit cursus
            nunc,
        </p>

        <article id="about-us">
        <div class="pic-container" id="pic-2">
            <img src="img/home-pic-2.webp" alt="home-pic-2" id="home-pic-2" />
            <div class="color-tint-2"></div>
            <div class="tint-content-right">
                <div class="item">
                    <h3>Secure bike storage</h3>
                    <p>Safe and secure storage for your bicycle</p>
                </div>
                <div class="item">
                    <h3>Recycling facilities</h3>
                    <p>Recycling bins for different materials</p>
                </div>
                <div class="item">
                    <h3>Electric bike charging station</h3>
                    <p>Charge your electric bike for free</p>
                </div>
            </div>
        </div>

        <div class="pic-container" id="pic-3">
            <img src="img/home-pic-3.webp" alt="home-pic-2" id="home-pic-3" />
            <div class="color-tint-3"></div>
            <div class="tint-content-left">
                <div class="item">
                    <h3>Eco-Friendly Transportation</h3>
                    <p>
                        Explore our range of eco-friendly transportation options
                        including
                    </p>
                    <p>electric bikes, scooters, and skateboards.</p>
                </div>
                <div class="item">
                    <h3>Convenient Charging Stations</h3>
                    <p>
                        Access our network of convenient charging stations
                        located
                    </p>
                    <p>
                        strategically throughout the city for easy recharging of
                        your electric
                    </p>
                    <p>vehicles.</p>
                </div>
                <div class="item">
                    <h3>Community Events</h3>
                    <p>
                        Join our community events focused on promoting
                        sustainable
                    </p>
                    <p>transportation and environmental awareness.</p>
                </div>
            </div>
           </article>
        </div>
    </body>
</html>
