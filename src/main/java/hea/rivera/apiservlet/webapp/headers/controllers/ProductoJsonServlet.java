package hea.rivera.apiservlet.webapp.headers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hea.rivera.apiservlet.webapp.headers.models.Producto;
import hea.rivera.apiservlet.webapp.headers.service.ProductoService;
import hea.rivera.apiservlet.webapp.headers.service.ProductoServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/productos.json")
public class ProductoJsonServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ProductoService service = new ProductoServiceImp();
    List<Producto> products = service.toList();

    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(products);
    resp.setContentType("application/json");
    resp.getWriter().write(json);
  }
}
