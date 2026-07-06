<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.model.Availability"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("admin") == null){
        response.sendRedirect("adminLogin.jsp");
        return;
    }

    String msg = request.getParameter("msg");
    String error = request.getParameter("error");
    List<Availability> closedDates = (List<Availability>) request.getAttribute("closedDates");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Availability</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="container" style="width:700px;">

    <h2>Manage Availability</h2>
    <p>Every day is open from <b>15:00 - 20:00</b> by default. </p>

    <% if(msg != null){ %>
        <p style="color:green;"><%= msg %></p>
    <% } %>

    <% if(error != null){ %>
        <p style="color:red;"><%= error %></p>
    <% } %>

    <form action="ManageAvailabilityServlet.do" method="POST">
        <label>Select date to close:</label>
        <input type="date" name="unavailableDate" min="<%= java.time.LocalDate.now() %>" required>
        <input type="hidden" name="action" value="close">
        <button type="submit">Close This Date</button>
    </form>

    <h3>Closed Dates</h3>

    <table border="1" width="100%">
        <tr>
            <th>Date</th>
            <th>Action</th>
        </tr>

        <%
            boolean found = false;
            if(closedDates != null){
                for(Availability a : closedDates){
                    if(Boolean.TRUE.equals(a.getUnavailable())){
                        found = true;
        %>
        <tr>
            <td><%= a.getUnavailableDate() %></td>
            <td>
                <form action="ManageAvailabilityServlet.do" method="POST" style="margin:0;">
                    <input type="hidden" name="unavailableDate" value="<%= a.getUnavailableDate() %>">
                    <input type="hidden" name="action" value="open">
                    <button type="submit">Open Again</button>
                </form>
            </td>
        </tr>
        <%
                    }
                }
            }

            if(!found){
        %>
        <tr>
            <td colspan="2">No closed dates yet.</td>
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
