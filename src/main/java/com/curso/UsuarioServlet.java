package com.curso;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
    private List <String> usuarios= new ArrayList<>();

    //GET

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Lista de Usuarios</h1>");
        for (String usuario : usuarios) {
            response.getWriter().println("<p>" + usuario + "</p>");
        }
    }

     //POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String Line;
        while ((Line = reader.readLine()) != null) {
            sb.append(Line);
        }

        String json = sb.toString();

        System.out.println("Json Recibido: " + json);

        String nombre = json.replace("{\"nombre\":\"", "").replace("\"}", "");

        if (!nombre.trim().isEmpty()) {
            usuarios.add(nombre);
        }
        response.setContentType("application/json");
        response.getWriter().println("{\"mensaje\":\"Usuario agregado\"}");

    
    }
    //PUT
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String nuevoNombre = request.getParameter("nuevoNombre");
        if (nombre != null && nuevoNombre != null && usuarios.contains(nombre)) {
            int index = usuarios.indexOf(nombre);
            usuarios.set(index, nuevoNombre);
        }
        response.sendRedirect("usuario");
    }
    //DELETE
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        if (nombre != null && usuarios.contains(nombre)) {
            usuarios.remove(nombre);
        }
        response.sendRedirect("usuario");
    }

    
}
