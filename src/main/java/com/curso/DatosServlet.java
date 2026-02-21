package com.curso;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/datos")
public class DatosServlet extends HttpServlet {
     protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        // Aquí puedes guardar los datos en una base de datos o procesarlos como necesites
        response.setContentType("text/html");
        response.getWriter().println("<h1>formulario de usuarios</h1>");
        response.getWriter().println("Nombre: " + nombre + "<br>    ");
        response.getWriter().println("Edad: " + edad);
    }
    
}
