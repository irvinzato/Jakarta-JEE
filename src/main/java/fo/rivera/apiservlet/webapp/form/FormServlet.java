package fo.rivera.apiservlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    String idiom = req.getParameter("idiom");
    boolean enable = req.getParameter("enable") != null && req.getParameter("enable").equals("on");
    String secret = req.getParameter("secret");
    List<String> errors = new ArrayList<>();    //Para validar formulario

    if( username == null || username.isBlank() ) {  //isBlank de Java 11 para arriba, válida que no este vacío y no tenga solo espacios en blanco
      errors.add("El usuario es requerido");
    }
    if( password == null || password.isBlank() ) {
      errors.add("El password no puede ser vacío");
    }
    if( email == null || !email.contains("@") ) {   //Lo mejor es usar expresiones regulares
      errors.add("El correo debe tener un formato correcto");
    }
    if( country == null || country.isBlank() ) {
      errors.add("El pais es requerido");
    }
    if( languages == null || languages.length == 0 ) {
      errors.add("Debe seleccionar al menos un idioma");
    }
    if( roles == null || roles.length == 0 ) {
      errors.add("Debe seleccionar al menos un rol");
    }
    if( idiom == null ) {   //No es necesario isBlank porque es un radioButton, no puede tener espacios en blanco ni vacío, solo nulo
      errors.add("Debe seleccionar un idioma");
    }

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
      if( errors.isEmpty() ) {
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
        out.println("       <li>Idioma: " + idiom + "</li>");
        out.println("       <li>Habilitado: " + enable + "</li>");
        out.println("       <li>Secreto: " + secret + "</li>");
      } else {
        out.println("       <h2> Errores: </h2>");
        errors.forEach( error -> {
          out.println("       <li>" + error + "</li>");
        });
        out.println("       <a href=\"/web_app/index.html\">Regresar</a>");
      }
      out.println("     </ul>");
      out.println("   </body>");
      out.println("</html>");
    }
  }
}
