package hea.rivera.apiservlet.webapp.headers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hea.rivera.apiservlet.webapp.headers.models.Producto;
import hea.rivera.apiservlet.webapp.headers.service.ProductoService;
import hea.rivera.apiservlet.webapp.headers.service.ProductoServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productos.json")
public class ProductoJsonServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ProductoService service = new ProductoServiceImp();
    List<Producto> products = service.toList();
    //Transformo lista de productos a JSON
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(products);
    resp.setContentType("application/json");
    resp.getWriter().write(json);
  }

  @Override  //Ahora recibo un JSON y lo transformo a algo, lo contrario a lo que hice arriba
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //PROBE CON POSTMAN !
    ServletInputStream jsonStream = req.getInputStream();
    ObjectMapper mapper = new ObjectMapper();
    Producto product = mapper.readValue(jsonStream, Producto.class); //De JSON a Producto

    resp.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = resp.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("   <head>");
      out.println("     <meta charset='UTF-8'>");
      out.println("     <title> Detalle de producto desde JSON </title>");
      out.println("   </head>");
      out.println("   <body>");
      out.println("     <h1> Detalle de producto desde JSON </h1>");
      out.println("     <ul>");
      out.println("     <li> ID: " + product.getId() + "</li>");
      out.println("     <li> Nombre: " + product.getName() + "</li>");
      out.println("     <li> Tipo: " + product.getType() + "</li>");
      out.println("     <li> Precio: " + product.getPrice() + "</li>");
      out.println("     </ul>");
      out.println("   </body>");
      out.println("</html>");
    }
  }
}
