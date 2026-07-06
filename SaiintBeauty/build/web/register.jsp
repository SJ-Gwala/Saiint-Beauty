<%-- 
    Document   : register
    Created on : 11 May 2026, 4:08:08 PM
    Author     : sihle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String msg = request.getParameter("msg");
    String error = request.getParameter("error");
%>

<% if(msg != null) { %>
    <p style="color:green;"><%= msg %></p>
<% } %>

<% if(error != null) { %>
    <p style="color:red;"><%= error %></p>
<% } %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="container">

    <h2>Client Registration</h2>

    <form action="RegisterServlet.do" method="POST">

        <label>Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Phone Number:</label><br>
        <input type="text" name="phoneNumber" required><br><br>

        <label>Password:</label><br>
        <input type="password" name="password" required><br><br>

        <button type="submit">Register</button>

    </form>

</div>

</body>
</html>
