<%-- 
    Document   : bookAppointment
    Created on : 11 May 2026, 4:09:38 PM
    Author     : sihle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("client") == null){
        response.sendRedirect("login.jsp");
        return;
    }

    String error = request.getParameter("error");
    String msg = request.getParameter("msg");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Book Appointment</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="container">

    <h2>Book Appointment</h2>

    <% if(error != null){ %>
        <% if("slot_taken".equals(error)){ %>
            <p style="color:red;">That slot is already booked. Please choose another time.</p>
        <% } else if("date_closed".equals(error)){ %>
            <p style="color:red;">That date is unavailable. Please choose another date.</p>
        <% } else { %>
            <p style="color:red;"><%= error %></p>
        <% } %>
    <% } %>

    <% if(msg != null){ %>
        <p style="color:green;"><%= msg %></p>
    <% } %>

    <form action="BookingServlet.do" method="POST">

        <label>Service:</label>
        <select name="service" required>
            <option value="Nails">Nails</option>
            <option value="Lashes">Lashes</option>
            <option value="Makeup">Makeup</option>
        </select>

        <label>Date:</label>
       <input type="date" name="bookingDate"
       min="<%= java.time.LocalDate.now() %>"
       required>

        <label>Time:</label>
        <select name="bookingTime" required>
            <option value="15:00">15:00</option>
            <option value="15:30">15:30</option>
            <option value="16:00">16:00</option>
            <option value="16:30">16:30</option>
            <option value="17:00">17:00</option>
            <option value="17:30">17:30</option>
            <option value="18:00">18:00</option>
            <option value="18:30">18:30</option>
            <option value="19:00">19:00</option>
            <option value="19:30">19:30</option>
        </select>

        <button type="submit">Check Availability & Book</button>
    </form>

    <br>
    <a href="clientDashboard.jsp"><button>Back</button></a>

</div>

</body>
</html>