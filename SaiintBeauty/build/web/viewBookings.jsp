<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.model.Booking"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("admin") == null){
        response.sendRedirect("adminLogin.jsp");
        return;
    }

    String msg = request.getParameter("msg");
    String error = request.getParameter("error");
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Bookings</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="container" style="width:850px;">

    <h2>All Bookings</h2>

    <% if(msg != null) { %>
        <p style="color:green;"><%= msg %></p>
    <% } %>

    <% if(error != null) { %>
        <p style="color:red;"><%= error %></p>
    <% } %>

    <table border="1" width="100%">
        <tr>
            <th>Client</th>
            <th>Service</th>
            <th>Date</th>
            <th>Time</th>
            <th>Status</th>
            <th>Update</th>
        </tr>

        <%
            if(bookings != null && !bookings.isEmpty()){
                for(Booking b : bookings){
        %>
        <tr>
            <td><%= b.getClient() != null ? b.getClient().getName() : "Unknown" %></td>
            <td><%= b.getService() != null ? b.getService().getServiceName() : "Unknown" %></td>
            <td><%= b.getBookingDate() %></td>
            <td><%= b.getBookingTime() %></td>
            <td><%= b.getBookingStatus() %></td>
            <td>
                <form action="UpdateBookingServlet.do" method="POST">
                    <input type="hidden" name="id" value="<%= b.getBookingId() %>">
                    <select name="status" required>
                        <option value="PENDING" <%= "PENDING".equals(b.getBookingStatus()) ? "selected" : "" %>>PENDING</option>
                        <option value="APPROVED" <%= "APPROVED".equals(b.getBookingStatus()) ? "selected" : "" %>>APPROVED</option>
                        <option value="REJECTED" <%= "REJECTED".equals(b.getBookingStatus()) ? "selected" : "" %>>REJECTED</option>
                        <option value="COMPLETED" <%= "COMPLETED".equals(b.getBookingStatus()) ? "selected" : "" %>>COMPLETED</option>
                    </select>
                    <button type="submit">Update</button>
                </form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6">No bookings yet.</td>
        </tr>
        <%
            }
        %>
    </table>

    <br>
    <a href="adminDashboard.jsp"><button>Back to Dashboard</button></a>

</div>

</body>
</html>
