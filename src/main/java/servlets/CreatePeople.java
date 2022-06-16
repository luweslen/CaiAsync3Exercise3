package servlets;

import db.PeoplesDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.People;

public class CreatePeople extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            int age = Integer.parseInt(request.getParameter("age"));
            String city = request.getParameter("city");
            String cpf = request.getParameter("cpf");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");

            People newPeople = new People();

            newPeople.setName(name);
            newPeople.setAge(age);
            newPeople.setCity(city);
            newPeople.setCpf(cpf);
            newPeople.setPhone(phone);

            PeoplesDB.data.add(newPeople);

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Nova pessoa</title>");            
                out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\"/>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<div class=\"container\">");
                out.println("<h1>Nova pessoa: </h1>");
                out.println("<dl class=\"dl-horizontal\">");
                out.println("<dt>Nome:</dt>");
                out.println("<dd>"+ newPeople.getName() +"</dd>");
                out.println("<dt>CPF:</dt>");
                out.println("<dd>"+ newPeople.getCpf() +"</dd>");
                out.println("<dt>Cidade:</dt>");
                out.println("<dd>"+ newPeople.getCity() +"</dd>");
                out.println("<dt>Idade:</dt>");
                out.println("<dd>"+ newPeople.getAge() +"</dd>");
                out.println("<dt>Telefone:</dt>");
                out.println("<dd>"+ newPeople.getPhone() +"</dd>");
                out.println("</dl>");
                out.println("<a class=\"btn btn-primary\" href='index.html'>Voltar</a>");
                out.println("<script src=\"js/bootstrap.min.js\"></script>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (NumberFormatException ex){
            response.sendRedirect("index");
        }
    }
    @Override
    protected void doPost(
        HttpServletRequest request, 
        HttpServletResponse response
    ) throws ServletException, IOException {
        processRequest(request, response);
    }
}
