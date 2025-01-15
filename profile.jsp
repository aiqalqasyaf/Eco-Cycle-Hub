<%-- 
    Document   : profile
    Created on : 15 Jan 2025, 8:43:50 pm
    Author     : Aiqal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/header.css" />
        <link rel="stylesheet" type="text/css" href="css/homestyle.css" />
        <link rel="stylesheet" type="text/css" href="css/profile.css" />
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
                        >User</a
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
                    <label>Full Name</label>
                    <p id="user-fullname">
                        <%= request.getAttribute("fullname") %>
                    </p>
                </div>
                <div class="user-info-row">
                    <label>Email</label>
                    <p id="user-email"><%= request.getAttribute("email") %></p>
                </div>
                <div class="user-info-row">
                    <label>Address</label>
                    <p id="user-address">
                        <%= request.getAttribute("address") %>
                    </p>
                </div>
                <div class="user-info-row">
                    <label>Phone Number</label>
                    <p id="user-phone"><%= request.getAttribute("phone") %></p>
                </div>
            </div>

            <button
                class="edit-button"
                onclick="document.getElementById('editModal').style.display='flex'"
            >
                Edit
            </button>
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
                <form action="/updateProfile" method="post">
                    <label for="edit-fullname">Full Name</label>
                    <input type="text" id="edit-fullname" name="fullname"
                    value="<%= request.getAttribute("fullname") %>" />

                    <label for="edit-email">Email</label>
                    <input type="email" id="edit-email" name="email" value="<%=
                    request.getAttribute("email") %>" />

                    <label for="edit-address">Address</label>
                    <input type="text" id="edit-address" name="address"
                    value="<%= request.getAttribute("address") %>" />

                    <label for="edit-phone">Phone Number</label>
                    <input type="tel" id="edit-phone" name="phone" value="<%=
                    request.getAttribute("phone") %>" />

                    <button class="save-button" type="submit">Save</button>
                </form>
            </div>
        </div>
    </body>
</html>

