package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.*;

import za.ac.tut.entity.bl.AdminFacade;
import za.ac.tut.entity.model.Admin;

public class CreateAdminServlet extends HttpServlet {

    @EJB
    private AdminFacade adminFacade;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Admin admin = new Admin();

        admin.setUsername("admin");
        admin.setPassword("admin123");

        adminFacade.create(admin);

        response.getWriter().println("ADMIN CREATED");
    }
}