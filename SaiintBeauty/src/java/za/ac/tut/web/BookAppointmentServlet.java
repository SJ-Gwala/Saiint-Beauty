package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import za.ac.tut.entity.model.*;
import za.ac.tut.entity.bl.*;

public class BookAppointmentServlet extends HttpServlet {

    @EJB
    private BookingFacade bookingFacade;

    @EJB
    private ClientFacade clientFacade;

    @EJB
    private ServiceFacade serviceFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");

        String serviceName = request.getParameter("service");

        Service service = serviceFacade.findByName(serviceName);

        Booking booking = new Booking();
        booking.setClient(client);
        booking.setService(service);
        booking.setBookingStatus("PENDING");

        bookingFacade.create(booking);

        response.sendRedirect("clientDashboard.jsp");
    }
}