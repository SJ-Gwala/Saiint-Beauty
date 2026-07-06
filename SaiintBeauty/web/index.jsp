<%-- 
    Document   : index
    Created on : 11 May 2026, 4:05:19 PM
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
    <title>Saiint Beauty</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <div class="container">
    <h1>SAIINT BEAUTY</h1>

    <p>Elegant Nails • Lashes • Makeup</p>

    <a href="login.jsp"><button>Login</button></a>
    <a href="register.jsp"><button>Register</button></a>
    <a href="adminLogin.jsp"><button>Admin Login</button></a>
</div>

</body>
</html>
