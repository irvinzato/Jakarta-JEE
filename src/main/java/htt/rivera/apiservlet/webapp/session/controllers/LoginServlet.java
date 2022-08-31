package htt.rivera.apiservlet.webapp.session.controllers;

import htt.rivera.apiservlet.webapp.session.service.LoginService;
import htt.rivera.apiservlet.webapp.session.service.LoginServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

//RECICLE PAQUETE "HEADERS" PARA LOGIN
@WebServlet({"/login-servlet-session", "/loginSession.html"})
public class LoginServlet extends HttpServlet {
  final static String USERNAME = "admin";
  final static String PASSWORD = "12345";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    LoginService serviceAuth = new LoginServiceImp();
    Optional<Cookie> cookieOptional = serviceAuth.getUsername(req);

    if( cookieOptional.isPresent() ) {  //Si está presente la cookie doy mensaje de bienvenida
      resp.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = resp.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("     <meta charset='UTF-8'>");
        out.println("     <title> Bienvenido " + cookieOptional.get().getValue() + "</title>");  //Para tener el valor de la cookie
        out.println("   </head>");
        out.println("   <body>");
        out.println("     <h1> Bienvenido " + cookieOptional.get().getValue() + " ya has iniciado sesión anteriormente </h1>");
        out.println("     <p><a href='" + req.getContextPath() + "/index.jsp'> Volver </a></p>");
        out.println("     <p><a href='" + req.getContextPath() + "/logoutSession'> Cerrar sesión </a></p>");
        out.println("   </body>");
        out.println("</html>");
      }
    } else {    //Si no hay cookie cargo el html que transforme a jsp
      getServletContext().getRequestDispatcher("/loginSession.jsp").forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    if( USERNAME.equals(username) && PASSWORD.equals(password) ) {
      Cookie usernameCookie = new Cookie("username", username);  //Parecido al SessionStorage, LocalStorage
      resp.addCookie(usernameCookie);

      //En lugar de crear un html redirecciono al get de arriba(Asi evito cache al volver atrás desde navegador)
      resp.sendRedirect(req.getContextPath() + "/loginSession.jsp");

    } else {
      //Status 401 con mensaje personalizado
      resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No tienes autorización para ingresar a esta página");
    }

  }
}
