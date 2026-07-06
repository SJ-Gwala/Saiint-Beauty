<%-- 
    Document   : clientDashboard
    Created on : 11 May 2026, 4:08:46 PM
    Author     : sihle
--%>
<%@page import="za.ac.tut.entity.model.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Client client = (Client) session.getAttribute("client");

    if(client == null){
        response.sendRedirect("login.jsp");
        return;
    }

    String msg = request.getParameter("msg");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Client Dashboard</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="container">

    <% if(msg != null){ %>
        <p style="color:green;"><%= msg %></p>
    <% } %>

    <h2>Welcome, <%= client.getName() %></h2>

    <a href="bookAppointment.jsp"><button>Book Appointment</button></a>

    <a href="ViewMyBookingsServlet.do"><button>My Bookings</button></a>

    <a href="PunchCardServlet.do"><button>My Punch Card</button></a>

    <a href="LogoutServlet.do"><button>Logout</button></a>

</div>

</body>
</html>