/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

import za.ac.tut.entity.model.Booking;
import za.ac.tut.entity.bl.BookingFacade;

public class ViewBookingServlet extends HttpServlet {

    @EJB
    private BookingFacade bookingFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Booking> bookings = bookingFacade.findAll();

        request.setAttribute("bookings", bookings);

        RequestDispatcher rd = request.getRequestDispatcher("viewBookings.jsp");
        rd.forward(request, response);
    }
}