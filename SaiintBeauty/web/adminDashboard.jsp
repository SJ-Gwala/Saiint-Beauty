<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    if(session.getAttribute("admin") == null){
        response.sendRedirect("adminLogin.jsp");
        return;
    }

    String msg = request.getParameter("msg");
    String error = request.getParameter("error");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="container">

    <% if(msg != null) { %>
        <p style="color:green;"><%= msg %></p>
    <% } %>

    <% if(error != null) { %>
        <p style="color:red;"><%= error %></p>
    <% } %>

    <h2>Admin Dashboard</h2>

    <a href="ViewBookingServlet.do"><button>View & Manage Bookings</button></a>
    <a href="ManageAvailabilityServlet.do"><button>Manage Availability</button></a>
    <a href="LogoutServlet.do"><button>Logout</button></a>

</div>

</body>
</html>
