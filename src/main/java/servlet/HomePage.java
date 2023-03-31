package servlet;

import jpa.*;
import dao.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Home",
        urlPatterns={"/Home"})
public class HomePage extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        //ajout user
       String res = "<html>"+
                "<body>"+
                "<FORM Method='POST' Action='/CreateUsersFromDB'>"+
                "Name : 		<INPUT type='text' size='20' name='name'><BR>"+
                "<INPUT type='submit' value='Ajouter'>"+
                "</FORM>" ;

//Pas implémenter ---

       //recherche user par id
        res += "<FORM Method='GET' Action='/SearchUser'>"+
                "Id : 		<INPUT type='int' size='20' name='id'><BR>"+
                "<INPUT type='submit' value='Rechercher User'>"+
                "</FORM>";

        //recherche membre par id
        res += "<FORM Method='GET' Action='/SearchMembre'>"+
                "Id : 		<INPUT type='int' size='20' name='id'><BR>"+
                "<INPUT type='submit' value='Rechercher Membre'>"+
                "</FORM>";

        //recherche fiche bug par id
        res += "<FORM Method='GET' Action='/SearchFicheBug'>"+
                "Id : 		<INPUT type='int' size='20' name='id'><BR>"+
                "<INPUT type='submit' value='Rechercher Bug'>"+
                "</FORM>";

        //recherche fiche feature par id
        res += "<FORM Method='GET' Action='/SearchFicheFeature'>"+
                "Id : 		<INPUT type='int' size='20' name='id'><BR>"+
                "<INPUT type='submit' value='Rechercher Feature'>"+
                "</FORM>" +
                "<h2>Liste des Users</h2>"+
                "<UL>";
// -- jusqu'ici

        try {
            //getUserFromDatabase();
            for (User user:UserDao.getAllUsersFromDatabase()) {
                res+= "<LI>Id : "
                        + user.getId() + " "
                        + "Name : "
                        + user.getName() + "\n";
            }
             res+="</UL><h2>Liste des Membres</h2><UL>";

            //getMembresFromDatabase();
            for (Membre membre:MembreDao.getAllMembresFromDatabase()) {
                res+= "<LI>Id : "
                        + membre.getId() + " "
                        + "Name : "
                        + membre.getName() + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


       res +="</UL> </body> </html>";
        out.println(res);
    }


}