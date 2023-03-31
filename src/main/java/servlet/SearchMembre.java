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

@WebServlet(name="searchMembre",
        urlPatterns={"/SearchMembre"})
public class SearchMembre extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Membre m = MembreDao.getMembreFromDatabase(Integer.parseInt(request.getParameter("id")));

        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Nom : "
                + m.getName() + "\n" +
                " <LI>Id : "
                + m.getId() + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
    }
}