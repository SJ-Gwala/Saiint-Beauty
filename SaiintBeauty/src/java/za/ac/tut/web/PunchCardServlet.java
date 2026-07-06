package za.ac.tut.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import za.ac.tut.entity.bl.PunchCardFacade;
import za.ac.tut.entity.model.Client;
import za.ac.tut.entity.model.PunchCard;

public class PunchCardServlet extends HttpServlet {

    @EJB
    private PunchCardFacade punchCardFacade;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null ||
                session.getAttribute("client") == null){

            response.sendRedirect("login.jsp");
            return;
        }

        Client client =
                (Client) session.getAttribute("client");

        List<PunchCard> cards =
                punchCardFacade.findByClient(client);

        request.setAttribute("cards", cards);

        request.getRequestDispatcher("punchCard.jsp")
                .forward(request, response);
        
        
    }
}