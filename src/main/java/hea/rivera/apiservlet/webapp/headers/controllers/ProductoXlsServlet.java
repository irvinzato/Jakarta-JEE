package hea.rivera.apiservlet.webapp.headers.controllers;

import hea.rivera.apiservlet.webapp.headers.models.Producto;
import hea.rivera.apiservlet.webapp.headers.service.ProductoService;
import hea.rivera.apiservlet.webapp.headers.service.ProductoServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({ "/productos.xls", "/productos.html" }) //Un Servlet soporta varias rutas enlazadas
public class ProductoXlsServlet  extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ProductoService service = new ProductoServiceImp();
    List<Producto> products = service.toList();

    resp.setContentType("text/html");
    String servletPath = req.getServletPath();
    boolean isXls = servletPath.endsWith(".xls");
    if( isXls ) {
      resp.setContentType("application/vnd.ms-excel");
      resp.setHeader("Content-Disposition", "attachment;filename=productos.xls");
    }

    try (PrintWriter out = resp.getWriter()) {
      if( !isXls ) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("     <meta charset='UTF-8'>");
        out.println("     <title> Listado de productos </title>");
        out.println("   </head>");
        out.println("   <body>");
        out.println("     <h1> Listado de productos </h1>");
        out.println("       <p><a href=\"" + req.getContextPath() + "/productos.xls" + "\">Imprimir Excel</a></p>"); //"req.getContextPath()" obtiene el path principal
        out.println("       <p><a href=\"" + req.getContextPath() + "/productos.json" + "\">Formato JSON</a></p>");
      }
      out.println("       <table>");
      out.println("         <tr>");
      out.println("           <th> ID </th>");
      out.println("           <th> Nombre </th>");
      out.println("           <th> Tipo </th>");
      out.println("           <th> Precio </th>");
      out.println("         </tr>");
      products.forEach( p -> {
        out.println("         <tr>");
        out.println("           <td>" + p.getId() + "</td>");
        out.println("           <td>" + p.getName() + "</td>");
        out.println("           <td>" + p.getType() + "</td>");
        out.println("           <td>" + p.getPrice() + "</td>");
        out.println("         </tr>");
      });
      out.println("       </table>");
      if( !isXls ) {
        out.println("   </body>");
        out.println("</html>");
      }
    }
  }
}
