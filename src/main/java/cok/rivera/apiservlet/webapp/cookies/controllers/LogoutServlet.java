package cok.rivera.apiservlet.webapp.cookies.controllers;

import cok.rivera.apiservlet.webapp.cookies.service.LoginService;
import cok.rivera.apiservlet.webapp.cookies.service.LoginServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    LoginService auth = new LoginServiceImp();
    Optional<Cookie> usernameCookie = auth.getUsername(req);
    //Para cerrar la cookie
    if( usernameCookie.isPresent() ) {
      Cookie username = new Cookie("username","");
      username.setMaxAge(0);  //Hago que no dure la cookie, la elimino
      resp.addCookie(username);
    }
    resp.sendRedirect(req.getContextPath() + "/loginCookies.html");
  }
}
