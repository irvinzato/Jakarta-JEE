package cok.rivera.apiservlet.webapp.cookies.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceImp implements LoginService{

  @Override
  public Optional<Cookie> getUsername(HttpServletRequest req) {
    Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
    Optional<Cookie> cookieOptional = Arrays.stream(cookies)
            .filter( c -> "username".equals(c.getName()))  //Puedo hacer un "map" para transformar la "cookie" a "string"
            .findAny();
    return cookieOptional;
  }
}
