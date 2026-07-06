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

import za.ac.tut.entity.model.Client;
import za.ac.tut.entity.bl.ClientFacade;

public class RegisterServlet extends HttpServlet {

    @EJB
    private ClientFacade clientFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        Client c = new Client();
        c.setName(name);
        c.setPhoneNumber(phone);
        c.setPassword(password);

        clientFacade.create(c);

        response.sendRedirect("login.jsp");
    }
}