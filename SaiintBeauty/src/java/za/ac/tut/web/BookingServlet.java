package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import za.ac.tut.entity.bl.AvailabilityFacade;
import za.ac.tut.entity.bl.BookingFacade;
import za.ac.tut.entity.bl.ServiceFacade;
import za.ac.tut.entity.model.Availability;
import za.ac.tut.entity.model.Booking;
import za.ac.tut.entity.model.Client;
import za.ac.tut.entity.model.Service;

public class BookingServlet extends HttpServlet {

    @EJB
    private BookingFacade bookingFacade;

    @EJB
    private ServiceFacade serviceFacade;

    @EJB
    private AvailabilityFacade availabilityFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("client") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Client client = (Client) session.getAttribute("client");

        String serviceName = request.getParameter("service");
        String bookingDate = request.getParameter("bookingDate");
        String bookingTime = request.getParameter("bookingTime");

        if (serviceName == null || bookingDate == null || bookingTime == null
                || serviceName.trim().isEmpty() || bookingDate.trim().isEmpty() || bookingTime.trim().isEmpty()) {
            response.sendRedirect("bookAppointment.jsp?error=missing_values");
            return;
        }

        if (dateIsClosed(bookingDate)) {
            response.sendRedirect("bookAppointment.jsp?error=date_closed");
            return;
        }

        boolean taken = bookingFacade.slotTaken(bookingDate, bookingTime);

        if (taken) {
            response.sendRedirect("bookAppointment.jsp?error=slot_taken");
            return;
        }

        Service service = serviceFacade.findByName(serviceName);

        Booking booking = new Booking();
        booking.setClient(client);
        booking.setService(service);
        booking.setBookingDate(bookingDate);
        booking.setBookingTime(bookingTime);
        booking.setBookingStatus("PENDING");

        bookingFacade.create(booking);

        response.sendRedirect("clientDashboard.jsp?msg=Booking successful");
    }

    private boolean dateIsClosed(String bookingDate) {
        List<Availability> all = availabilityFacade.findAll();
        for (Availability a : all) {
            if (a.getUnavailableDate() != null
                    && a.getUnavailableDate().equals(bookingDate)
                    && Boolean.TRUE.equals(a.getUnavailable())) {
                return true;
            }
        }
        return false;
    }
}
