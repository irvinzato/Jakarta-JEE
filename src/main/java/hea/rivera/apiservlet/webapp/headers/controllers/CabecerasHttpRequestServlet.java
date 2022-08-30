package hea.rivera.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request")
public class CabecerasHttpRequestServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    String methodHttp = req.getMethod();
    String requestUri = req.getRequestURI();
    String requestUrl = req.getRequestURL().toString();   //Esté devuelve un "StringBuffer" por eso cast
    String contextPath = req.getContextPath();
    String servletPath = req.getServletPath();
    String ip = req.getLocalAddr();
    int port = req.getLocalPort();
    String scheme = req.getScheme();
    String host = req.getHeader("host");
    String url = scheme + "://" + host + contextPath + servletPath;  //Dos formas de construir ruta URL
    String url2 = scheme + "://" + ip + ":" + port + contextPath + servletPath;
    //INFORMACIÓN DEL CLIENTE, LAS VARIABLES DE ARRIBA SON PROPIAS DE LA APLICACIÓN
    String ipClient = req.getRemoteAddr();

    try (PrintWriter out = resp.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("   <head>");
      out.println("     <meta charset='UTF-8'>");
      out.println("     <title> Cabeceras HTTP Request </title>");
      out.println("   </head>");
      out.println("   <body>");
      out.println("     <h1> Cabeceras HTTP Request </h1>");
      out.println("     <ul>");
      out.println("       <li>Método Http: " + methodHttp + "</li>");
      out.println("       <li>Método URI: " + requestUri + "</li>");
      out.println("       <li>Método URL: " + requestUrl + "</li>");
      out.println("       <li>Método ContextPath: " + contextPath + "</li>");
      out.println("       <li>Método ServletPath: " + servletPath + "</li>");
      out.println("       <li>Método IP local: " + ip + "</li>");
      out.println("       <li>Método Puerto local: " + port + "</li>");
      out.println("       <li>Método Esquema: " + scheme + "</li>");
      out.println("       <li>Método Host: " + host + "</li>");
      out.println("       <li>URL construida 1: " + url + "</li>");
      out.println("       <li>URL construida 2: " + url2 + "</li>");
      out.println("       <li>IP Cliente: " + ipClient + "</li>");
      Enumeration<String> headerNames = req.getHeaderNames();
      while( headerNames.hasMoreElements() ) {
        String headBoard = headerNames.nextElement();
        out.println("       <li>Cabecera: " + headBoard + ": " + req.getHeader(headBoard) + "</li>");
      }
      out.println("     </ul>");
      out.println("   </body>");
      out.println("</html>");
    }
  }
}
