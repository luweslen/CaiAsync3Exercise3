package servlets;

import db.PeoplesDB;
import models.People;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Peoples", urlPatterns = {"/peoples"})
public class Peoples extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Pessoas</title>");            
            out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\"/>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h1>Pessoas cadastradas: </h1>");
            out.println("<table class=\"table\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Nome</th>");
            out.println("<th>CPF</th>");
            out.println("<th>Idade</th>");
            out.println("<th>Cidade</th>");
            out.println("<th>Telefone</th>");
            out.println("<th>Ações</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            for (People people : PeoplesDB.data) {
                out.println("<tr>");
                out.println("<td>"+ people.getName() +"</td>");
                out.println("<td>"+ people.getCpf()+"</td>");
                out.println("<td>"+ people.getAge() +"</td>");
                out.println("<td>"+ people.getCity() +"</td>");
                out.println("<td>"+ people.getPhone() +"</td>");
                out.println("<td>-</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("<a class=\"btn btn-primary\" href='index.html'>Voltar</a>");
            out.println("<script src=\"js/bootstrap.min.js\"></script>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
