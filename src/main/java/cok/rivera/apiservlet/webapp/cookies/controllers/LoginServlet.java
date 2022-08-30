package cok.rivera.apiservlet.webapp.cookies.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//RECICLE PAQUETE "HEADERS" PARA LOGIN
@WebServlet("/login-servlet-cookies")
public class LoginServlet extends HttpServlet {
  final static String USERNAME = "admin";
  final static String PASSWORD = "12345";

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    if( USERNAME.equals(username) && PASSWORD.equals(password) ) {
      resp.setContentType("text/html");

      try (PrintWriter out = resp.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("     <meta charset='UTF-8'>");
        out.println("     <title> Login Correcto con Cookies </title>");
        out.println("   </head>");
        out.println("   <body>");
        out.println("     <h1> Login Correcto con Cookies </h1>");
        out.println("     <h2> Bienvenido " + username + "</h2>");
        out.println("   </body>");
        out.println("</html>");
      }
    } else {
      //Status 401 con mensaje personalizado
      resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No tienes autorización para ingresar a esta página");
    }

  }
}