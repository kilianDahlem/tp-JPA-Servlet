package servlet;

import dao.UserDao;
import jpa.EntityManagerHelper;
import jpa.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "createusersfromdb",
        urlPatterns = {"/CreateUsersFromDB"})
public class CreateUsersFromDB extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao.createUser(new User(req.getParameter("name")));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("C'est good");

    }
}
