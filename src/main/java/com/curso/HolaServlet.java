package com.curso;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/saludo")
public class HolaServlet extends HttpServlet {
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String nombre=request.getParameter("nombre");
        if(nombre==null){
            nombre="Invitado";
        }
        response.setContentType("text/html");
        response.getWriter().println("<h1>Hola "+nombre+" !!!</h1>");
    }
}
