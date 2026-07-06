package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import za.ac.tut.entity.bl.BookingFacade;
import za.ac.tut.entity.bl.PunchCardFacade;
import za.ac.tut.entity.model.Booking;
import za.ac.tut.entity.model.PunchCard;

public class UpdateBookingServlet extends HttpServlet {

    @EJB
    private BookingFacade bookingFacade;

    @EJB
    private PunchCardFacade punchCardFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateBooking(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateBooking(request, response);
    }

    private void updateBooking(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String idStr = request.getParameter("id");
        String status = request.getParameter("status");

        if (idStr == null || idStr.trim().isEmpty() || status == null || status.trim().isEmpty()) {
            response.sendRedirect("ViewBookingServlet.do?error=missing_values");
            return;
        }

        Long id;
        try {
            id = Long.parseLong(idStr.trim());
        } catch (NumberFormatException ex) {
            response.sendRedirect("ViewBookingServlet.do?error=invalid_booking_id");
            return;
        }

        Booking booking = bookingFacade.find(id);

        if (booking == null) {
            response.sendRedirect("ViewBookingServlet.do?error=booking_not_found");
            return;
        }

        String oldStatus = booking.getBookingStatus();
        booking.setBookingStatus(status);
        bookingFacade.edit(booking);

        // Add a punch only the first time this booking becomes COMPLETED.
        if ("COMPLETED".equals(status) && !"COMPLETED".equals(oldStatus)) {

            PunchCard pc = new PunchCard();
            pc.setClient(booking.getClient());
            pc.setService(booking.getService());
            pc.setPunches(1);

            punchCardFacade.addOrUpdatePunch(pc);
        }

        response.sendRedirect("ViewBookingServlet.do?msg=booking_updated");
    }
}
