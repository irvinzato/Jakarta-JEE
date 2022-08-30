package hea.rivera.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirigir")
public class RedirigirServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //Modifico la respuesta para redirigir a "http://localhost:8080/web_app/productos.html"
    resp.setHeader("Location", req.getContextPath() + "/productos.html");
    resp.setStatus(HttpServletResponse.SC_FOUND);
    //resp.sendRedirect(req.getContextPath() + "/productos.html");  //Lo mismo que las dos líneas de arriba pero en una
  }
}
