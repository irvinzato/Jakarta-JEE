package htt.rivera.apiservlet.webapp.session.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class AplicacionListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {
  private ServletContext servletContext;

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    sce.getServletContext().log("Inicializando aplicación - contextInitialized");
    servletContext = sce.getServletContext();
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    servletContext.log("Destruyendo aplicación - contextDestroyed");
  }

  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    servletContext.log("Inicializando request - requestInitialized");
  }

  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    servletContext.log("Destruyendo request - requestDestroyed");
  }

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    servletContext.log("Inicializando session - sessionCreated");
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    servletContext.log("Destruyendo session - sessionDestroyed");
  }
}
