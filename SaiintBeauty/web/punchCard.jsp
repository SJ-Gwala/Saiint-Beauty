<%-- 
    Document   : punchCard
    Created on : 11 May 2026, 4:12:23 PM
    Author     : sihle
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.model.PunchCard"%>
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
    <title>Punch Card</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="container">

    <h2>Your Punch Card</h2>

    <%
        List<PunchCard> cards = (List<PunchCard>) request.getAttribute("cards");

        if(cards != null && !cards.isEmpty()) {
            for(PunchCard pc : cards) {
    %>

        <div style="border:1px solid #d6e6f2; padding:10px; margin-bottom:10px; border-radius:10px;">
            <p><b>Service:</b> <%= pc.getService().getServiceName() %></p>
            <p><b>Punches:</b> <%= pc.getPunches() %> / 5</p>

            <%
                if(pc.getPunches() >= 5) {
            %>
                <p style="color:green;"><b>Reward Available 🎉</b></p>
            <%
                } else {
            %>
                <p style="color:#7ec8ff;">Keep going!</p>
            <%
                }
            %>

        </div>

    <%
            }
        } else {
    %>

        <p>No punch cards yet.</p>

    <%
        }
    %>

</div>

</body>
</html>
