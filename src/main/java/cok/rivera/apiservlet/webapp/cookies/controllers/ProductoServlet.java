package cok.rivera.apiservlet.webapp.cookies.controllers;

import cok.rivera.apiservlet.webapp.cookies.models.Producto;
import cok.rivera.apiservlet.webapp.cookies.service.LoginService;
import cok.rivera.apiservlet.webapp.cookies.service.LoginServiceImp;
import cok.rivera.apiservlet.webapp.cookies.service.ProductoService;
import cok.rivera.apiservlet.webapp.cookies.service.ProductoServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productosCookies.html", "/productos"})
public class ProductoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ProductoService service = new ProductoServiceImp();
    List<Producto> products = service.toList();

    LoginService serviceLoginCookie = new LoginServiceImp();
    Optional<Cookie> cookieOptional = serviceLoginCookie.getUsername(req);

    resp.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = resp.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("   <head>");
      out.println("     <meta charset='UTF-8'>");
      out.println("     <title> Listado de productos con Cookies </title>");
      out.println("   </head>");
      out.println("   <body>");
      out.println("     <h1> Listado de productos con Cookies </h1>");
      if( cookieOptional.isPresent() ) {
        out.println("       <h2 style='color: blue;'> Hola " + cookieOptional.get().getValue() + " bienvenido ! </h2>");
      }
      out.println("       <table>");
      out.println("         <tr>");
      out.println("           <th> ID </th>");
      out.println("           <th> Nombre </th>");
      out.println("           <th> Tipo </th>");
      if( cookieOptional.isPresent() ) {
        out.println("           <th> Precio </th>");
      }
      out.println("         </tr>");
      products.forEach(p -> {
        out.println("         <tr>");
        out.println("           <td>" + p.getId() + "</td>");
        out.println("           <td>" + p.getName() + "</td>");
        out.println("           <td>" + p.getType() + "</td>");
        if( cookieOptional.isPresent() ) {
          out.println("           <td>" + p.getPrice() + "</td>");
        }
        out.println("         </tr>");
      });
      out.println("       </table>");
      out.println("       <p><a href='" + req.getContextPath() + "/index.jsp'> Volver </a></p>");
      out.println("   </body>");
      out.println("</html>");
    }
  }
}
