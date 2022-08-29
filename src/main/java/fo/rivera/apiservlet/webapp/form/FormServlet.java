package fo.rivera.apiservlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");

    String username = req.getParameter("username"); //Mismo nombre del "name" en HTML para obtener parámetro
    String password = req.getParameter("password");
    String email = req.getParameter("email");
    String country = req.getParameter("country");
    String[] languages = req.getParameterValues("languages"); //Arreglo porque puedo tener selección multiple
    String[] roles = req.getParameterValues("roles");

    try (PrintWriter out = resp.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("   <head>");
      out.println("     <meta charset='UTF-8'>");
      out.println("     <title> Resultado del formulario </title>");
      out.println("   </head>");
      out.println("   <body>");
      out.println("     <h1> Resultado: </h1>");
      out.println("     <ul>");
      out.println("       <li>Usuario: " + username + "</li>");
      out.println("       <li>Contraseña: " + password + "</li>");
      out.println("       <li>Email: " + email + "</li>");
      out.println("       <li>País: " + country + "</li>");
      out.println("       <li>Lenguajes: <ul>");
      Arrays.asList(languages).forEach( language -> { //Transformo arreglo a Array para usar forEach
        out.println("       <li>" + language + "</li>");
      });
      out.println("       </ul></li>");
      out.println("       <li>Roles: <ul>");
      Arrays.asList(roles).forEach( rol -> {
        out.println("       <li>" + rol + "</li>");
      });
      out.println("       </ul></li>");
      out.println("     </ul>");
      out.println("   </body>");
      out.println("</html>");
    }
  }
}
