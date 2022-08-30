package cok.rivera.apiservlet.webapp.cookies.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {
  //Reutilizo código para obtener cookie "username" - evito copiar y pegar el método
  Optional<Cookie> getUsername(HttpServletRequest req);
}
