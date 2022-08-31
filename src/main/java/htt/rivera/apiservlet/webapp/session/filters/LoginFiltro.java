package htt.rivera.apiservlet.webapp.session.filters;

import htt.rivera.apiservlet.webapp.session.service.LoginService;
import htt.rivera.apiservlet.webapp.session.service.LoginServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/ver-carro", "/agregar-carro"}) //Puedo modificar mis rutas con "/carro/*" para que sea carro y lo que tegan después entre
public class LoginFiltro implements Filter {

  @Override  //Filtro para páginas que pueden ser privadas
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    LoginService serviceLogin = new LoginServiceImp();
    Optional<String> username = serviceLogin.getUsername((HttpServletRequest) servletRequest );

    if( username.isPresent() ) {
      filterChain.doFilter(servletRequest, servletResponse);  //Para continuar con la cadena de los filtros o recursos hasta llegar al Servlet
    } else {
      ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED,
              "FILTRO DE SERVLET - No tienes autorización para ingresar a esta pagina, por favor haz login");
    }
  }
}
