package com.curso;
import java.io.IOException;
import java.time.LocalDateTime;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/hora")
public class HoraServlet extends HttpServlet {
     protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LocalDateTime ahora = LocalDateTime.now();
        response.setContentType("text/html");
        response.getWriter().println("<h1>La hora actual es: "+ahora+"</h1>");
    }
    
}
