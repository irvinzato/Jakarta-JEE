package org.rivera.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//Un servlet es una instancia que se despliega en el servidor, en este caso de tomcat
@WebServlet("/hola-mundo") //Ruta asociada
public class HolaMundoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("   <head>");
    out.println("     <meta charset='UTF-8'>");
    out.println("     <title> Jakarta - Servlet </title>");
    out.println("   </head>");
    out.println("   <body>");
    out.println("     <h1> Aprendamos Jakarta </h1>");
    out.println("   </body>");
    out.println("</html>");
    out.close();
  }

}
