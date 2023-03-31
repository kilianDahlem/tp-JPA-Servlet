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

@WebServlet(name="searchFicheBug",
        urlPatterns={"/SearchFicheBug"})
public class SearchFicheBug extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        FicheBug fb = FicheBugDao.getFicheBugFromDatabase(Integer.parseInt(request.getParameter("id")));

        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Id : "
                + fb.getTicket_id() + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
    }
}