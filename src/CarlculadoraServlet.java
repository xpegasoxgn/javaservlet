package com.curso;
import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/calculadora")
public class CarlculadoraServlet extends HttpServlet {
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
       String n1 =request.getParameter("a");
       String n2 =request.getParameter("b");

       int resultado=0;
       if(n1!=null && n2!=null){
        resultado=Integer.parseInt(n1)+Integer.parseInt(n2);
       }
       response.setContentType("text/html");
         response.getWriter().println("<h1>El resultado de la suma es: "+resultado+"</h1>");
    }
}
