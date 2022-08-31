package htt.rivera.apiservlet.webapp.session.controllers;

import htt.rivera.apiservlet.webapp.session.models.Carro;
import htt.rivera.apiservlet.webapp.session.models.ItemCarro;
import htt.rivera.apiservlet.webapp.session.models.Producto;
import htt.rivera.apiservlet.webapp.session.service.ProductoService;
import htt.rivera.apiservlet.webapp.session.service.ProductoServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/agregar-carro")
public class AgregarCarroServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    ProductoService service = new ProductoServiceImp();
    Optional<Producto> product = service.byId(id);

    if( product.isPresent() ) {
      ItemCarro item = new ItemCarro(1, product.get());
      HttpSession session = req.getSession();
      Carro car;
      if( session.getAttribute("carro") == null ) { //Primera vez que se usa el carro
        car = new Carro();
        session.setAttribute("carro", car);
      } else {                                        //Ya existe en la sesión el carro
        car = (Carro) session.getAttribute("car");
      }
      car.addItemCar(item);
    }
    resp.sendRedirect(req.getContextPath() + "/ver-carro");
  }
}
