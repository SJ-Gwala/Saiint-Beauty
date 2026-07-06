<%-- 
    Document   : adminLogin
    Created on : 11 May 2026, 5:08:37 PM
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
    <title>Admin Login</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="container">

    <h2>Admin Login</h2>

    <form action="AdminLoginServlet.do" method="POST">

        <label>Username:</label><br>
        <input type="text" name="username" required><br><br>

        <label>Password:</label><br>
        <input type="password" name="password" required><br><br>

        <button type="submit">Login</button>

    </form>

</div>

</body>
</html>
