package htt.rivera.apiservlet.webapp.session.service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {
  //Reutilizo código para obtener cookie "username" - evito copiar y pegar el método
  Optional<String> getUsername(HttpServletRequest req);
}
