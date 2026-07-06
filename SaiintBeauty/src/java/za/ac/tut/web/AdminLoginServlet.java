package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.*;

import za.ac.tut.entity.model.Admin;
import za.ac.tut.entity.bl.AdminFacade;

public class AdminLoginServlet extends HttpServlet {

    @EJB
    private AdminFacade adminFacade;

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {

    HttpSession session = request.getSession();

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    System.out.println("USERNAME: [" + username + "]");
    System.out.println("PASSWORD: [" + password + "]");

    Admin admin = adminFacade.login(username, password);

    System.out.println("ADMIN: " + admin);

    if(admin != null){

        session.setAttribute("admin", admin);

        response.sendRedirect("adminDashboard.jsp?msg=Welcome Admin");

    } else {

        response.sendRedirect("adminLogin.jsp?error=Wrong login");
    }
}
}