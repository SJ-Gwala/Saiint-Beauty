<%-- 
    Document   : myBookings
    Created on : 12 May 2026, 10:06:38 AM
    Author     : sihle
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.model.Booking"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
%>

<!DOCTYPE html>
<html>
<head>
    <title>My Bookings</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="container" style="width:700px;">

    <h2>My Bookings</h2>

    <table border="1" width="100%">
        <tr>
            <th>Service</th>
            <th>Date</th>
            <th>Time</th>
            <th>Status</th>
        </tr>

        <%
            if(bookings != null && !bookings.isEmpty()){
                for(Booking b : bookings){
        %>
        <tr>
            <td><%= b.getService().getServiceName() %></td>
            <td><%= b.getBookingDate() %></td>
            <td><%= b.getBookingTime() %></td>
            <td><%= b.getBookingStatus() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="4">You have no bookings yet.</td>
        </tr>
        <%
            }
        %>
    </table>

    <br>
    <a href="clientDashboard.jsp"><button>Back to Dashboard</button></a>

</div>

</body>
</html>
