/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import za.ac.tut.entity.bl.AdminFacade;

import za.ac.tut.entity.model.Client;
import za.ac.tut.entity.bl.ClientFacade;

public class LoginServlet extends HttpServlet {

    @EJB
    private ClientFacade clientFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       

        String phone = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

       Client client = clientFacade.login(phone, password);

if(client != null){

    HttpSession session = request.getSession();
    session.setAttribute("client", client);

    response.sendRedirect("clientDashboard.jsp?msg=Login successful");

} else {
    response.sendRedirect("login.jsp?error=Invalid credentials");
}
    
    }
}