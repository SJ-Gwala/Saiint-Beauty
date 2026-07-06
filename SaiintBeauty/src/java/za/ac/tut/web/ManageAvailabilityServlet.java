package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import za.ac.tut.entity.bl.AvailabilityFacade;
import za.ac.tut.entity.model.Availability;

public class ManageAvailabilityServlet extends HttpServlet {

    @EJB
    private AvailabilityFacade availabilityFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            response.sendRedirect("adminLogin.jsp");
            return;
        }

        List<Availability> closedDates = availabilityFacade.findAll();
        request.setAttribute("closedDates", closedDates);
        request.getRequestDispatcher("manageAvailability.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            response.sendRedirect("adminLogin.jsp");
            return;
        }

        String action = request.getParameter("action");
        String date = request.getParameter("unavailableDate");

        if (date == null || date.trim().isEmpty()) {
            response.sendRedirect("ManageAvailabilityServlet.do?error=date_required");
            return;
        }

        date = date.trim();

        if ("close".equals(action)) {
            Availability existing = findByDate(date);
            if (existing == null) {
                Availability availability = new Availability();
                availability.setUnavailableDate(date);
                availability.setUnavailable(Boolean.TRUE);
                availabilityFacade.create(availability);
            } else {
                existing.setUnavailable(Boolean.TRUE);
                availabilityFacade.edit(existing);
            }
            response.sendRedirect("ManageAvailabilityServlet.do?msg=date_closed");
            return;
        }

        if ("open".equals(action)) {
            Availability existing = findByDate(date);
            if (existing != null) {
                availabilityFacade.remove(existing);
            }
            response.sendRedirect("ManageAvailabilityServlet.do?msg=date_opened");
            return;
        }

        response.sendRedirect("ManageAvailabilityServlet.do?error=invalid_action");
    }

    private Availability findByDate(String date) {
        List<Availability> all = availabilityFacade.findAll();
        for (Availability a : all) {
            if (a.getUnavailableDate() != null
                    && a.getUnavailableDate().equals(date)
                    && Boolean.TRUE.equals(a.getUnavailable())) {
                return a;
            }
        }
        return null;
    }
}
