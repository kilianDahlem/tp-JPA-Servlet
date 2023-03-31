package servlet;
import dao.*;
import jpa.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="searchFicheFeature",
        urlPatterns={"/SearchFicheFeature"})
public class SearchFicheFeature extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        FicheFeatureRequest ff = FicheFeatureDao.getFicheFeatureFromDatabase(Integer.parseInt(request.getParameter("id")));

        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Id : "
                + ff.getTicket_id() + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
    }
}