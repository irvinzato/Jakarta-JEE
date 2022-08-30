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
import java.util.Optional;

@WebServlet("/buscar-producto")
public class BuscarProductoServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ProductoService service = new ProductoServiceImp();
    String nameProduct = req.getParameter("product");

    Optional<Producto> found = service.toList().stream().filter(p -> {
              if( nameProduct == null || nameProduct.isBlank() ) {
                return false;
              }
              return p.getName().contains(nameProduct);
            })
            .findFirst();
    if( found.isPresent() ) {
      resp.setContentType("text/html");
      try (PrintWriter out = resp.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("     <meta charset='UTF-8'>");
        out.println("     <title> Producto encontrado </title>");
        out.println("   </head>");
        out.println("   <body>");
        out.println("     <h1> Producto encontrado </h1>");
        out.println("     <h2> Se encontró " + nameProduct + "</h2>");
        out.println("     <h2> Precio - " + found.get().getPrice() + "</h2>");
        out.println("     <h2> Tipo - " + found.get().getType() + "</h2>");
        out.println("   </body>");
        out.println("</html>");
      }
    } else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No se encontró el producto " + nameProduct);
    }
  }
}
