package htt.rivera.apiservlet.webapp.session.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class AplicacionListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {
  private ServletContext servletContext;

  //Utilizado para guardar objetos únicos que van a ser compartidos por toda la aplicación
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    sce.getServletContext().log("Inicializando aplicación - contextInitialized");
    servletContext = sce.getServletContext();
    servletContext.setAttribute("mensaje", "Algún valor global de la app");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    servletContext.log("Destruyendo aplicación - contextDestroyed");
  }

  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    servletContext.log("Inicializando request - requestInitialized");
    sre.getServletRequest().setAttribute("mensajeRequest", "Guardando algún valor para el request");
  }

  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    servletContext.log("Destruyendo request - requestDestroyed");
  }

  //Cada que se crea la session puedo crear el carrito de compras
  @Override
  public void sessionCreated(HttpSessionEvent se) {
    servletContext.log("Inicializando session - sessionCreated");
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    servletContext.log("Destruyendo session - sessionDestroyed");
  }
}
