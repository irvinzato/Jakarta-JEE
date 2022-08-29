<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%
    List<String> errors = (List<String>) request.getAttribute("errors");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Jakarta con Tomcat - Formularios</title>
</head>
<body>
    <h1> Aprendamos Jakarta usando Tomcat(Da soporte tanto a servlets como a páginas JSP (Java Server Pages) o Java Sockets)  </h1>
    <h1> En este proyecto tengo ejemplos con Servlet enviando parámetros Get por URL o Query String y Formularios </h1>
    <a href="/web_app/parametros/url-get?hi=Hola animo"> Enviando parámetro 'hi'</a> <br>
    <a href="/web_app/parametros/url-get?hi=Hola animo&name=Irving"> Enviando 2 parámetros </a> <br>
    <a href="/web_app/parametros/url-get?name=Irving"> Enviando parámetro 'name' </a> <br>
    <a href="/web_app/parametros/url-get?hi=Hola animo&name=Irving&code=423"> Enviando 3 parámetros, con código </a> <br>
    <a href="/web_app/parametros/url-get"> Sin parámetros </a>
    <hr>

    <h3> Formulario de usuarios </h3>
    <%
        if( errors != null && errors.size() > 0 ) {
    %>
    <ul>
        <% for(String err: errors) { %>
            <li> <% out.print(err); %> </li>
        <% } %>
    </ul>
    <% } %>
    <form action="/web_app/registro" method="post"> <!-- Importante indicar "method" post porque por defecto seria get-->
        <div>
            <label for="username">Usuario</label> <!-- "for" enlaza con "id" para que también reaccione al dar click en etiqueta -->
            <div><input type="text" name="username" id="username"></div>
        </div>
        <div>
            <label for="password">Contraseña</label>
            <div><input type="password" name="password" id="password"></div>
        </div>
        <div>
            <label for="email">Email</label>
            <div><input type="text" name="email" id="email"></div>
        </div>
        <div>
            <label for="country">País</label>
            <div>
                <select name="country" id="country">
                    <option value="">-- seleccionar --</option>
                    <option value="MX" selected>México</option>
                    <option value="ES">España</option>
                    <option value="CL">Chile</option>
                    <option value="AR">Argentina</option>
                    <option value="COL">Colombia</option>
                    <option value="PE">Perú</option>
                </select>
            </div>
        </div>
        <div>
            <label for="languages">Lenguajes de programación</label>
            <div>
                <select name="languages" id="languages" multiple>
                    <option value="java" selected>Java</option>
                    <option value="javascript">JavaScript</option>
                    <option value="jakarta">Jakarta EE9</option>
                    <option value="angular" selected>Angular</option>
                    <option value="spring">Spring</option>
                    <option value="react">React</option>
                </select>
            </div>
        </div>
        <div>
            <label>Roles</label>
            <div>
                <input type="checkbox" name="roles" value="ROLE_ADMIN">
                <label>Administrador</label>
            </div>
            <div>
                <input type="checkbox" name="roles" value="ROLE_USER" checked>
                <label>Usuario</label>
            </div>
            <div>
                <input type="checkbox" name="roles" value="ROLE_MODERATOR">
                <label>Moderador</label>
            </div>
        </div>
        <div>
            <label>Idiomas</label>
            <div>
                <input type="radio" name="idiom" value="es">
                <label>Español</label>
            </div>
            <div>
                <input type="radio" name="idiom" value="en">
                <label>Ingles</label>
            </div>
            <div>
                <input type="radio" name="idiom" value="fr">
                <label>Frances</label>
            </div>
        </div>
        <div>
            <label for="enable">Habilitar</label>
            <div>
                <input type="checkbox" name="enable" id="enable" checked>
            </div>
        </div>
        <div>
            <div>
                <input type="submit" value="Enviar">
            </div>
        </div>
        <input type="hidden" name="secret" value="12345"> <!--El campo secreto normalmente va después del botón submit pero antes del form-->
    </form>

</body>
</html>