package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import za.ac.tut.entity.bl.BookingFacade;
import za.ac.tut.entity.model.Booking;
import za.ac.tut.entity.model.Client;

public class ViewMyBookingsServlet extends HttpServlet {

    @EJB
    private BookingFacade bookingFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("client") == null){
            response.sendRedirect("login.jsp");
            return;
        }

        Client client = (Client) session.getAttribute("client");

        List<Booking> bookings = bookingFacade.findByClient(client);

        request.setAttribute("bookings", bookings);

        request.getRequestDispatcher("myBookings.jsp").forward(request, response);
    }
}