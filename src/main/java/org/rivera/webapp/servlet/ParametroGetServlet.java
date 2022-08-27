package org.rivera.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParametroGetServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();

    String hi = req.getParameter("hi");
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("   <head>");
    out.println("     <meta charset='UTF-8'>");
    out.println("     <title> Parametros Get url </title>");
    out.println("   </head>");
    out.println("   <body>");
    out.println("     <h1> Jakarta - Parámetros Get de la url </h1>");
    out.println("     <h2> El saludo enviado es: " + hi +  "</h2>");
    out.println("   </body>");
    out.println("</html>");
    out.close();

  }
}
