<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%
    Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
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
        <% for( String err: errors.values() ) { %>
            <li> <% out.print(err); %> </li>
        <% } %>
    </ul>
    <% } %>
    <form action="/web_app/registro" method="post"> <!-- Importante indicar "method" post porque por defecto seria get-->
        <div>
            <label for="username">Usuario</label> <!-- "for" enlaza con "id" para que también reaccione al dar click en etiqueta -->
            <div><input type="text" name="username" id="username"></div>
            <% if( errors != null && errors.containsKey("username") ) {
                out.println("<small style='color: red;'>" + errors.get("username") +  "</small>");
            } %>
        </div>
        <div>
            <label for="password">Contraseña</label>
            <div><input type="password" name="password" id="password"></div>
            <% if( errors != null && errors.containsKey("password") ) {
                out.println("<small style='color: red;'>" + errors.get("password") +  "</small>");
            } %>
        </div>
        <div>
            <label for="email">Email</label>
            <div><input type="text" name="email" id="email"></div>
            <% if( errors != null && errors.containsKey("email") ) {
                out.println("<small style='color: red;'>" + errors.get("email") +  "</small>");
            } %>
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
            <% if( errors != null && errors.containsKey("country") ) {
                out.println("<small style='color: red;'>" + errors.get("country") +  "</small>");
            } %>
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
            <% if( errors != null && errors.containsKey("languages") ) {
                out.println("<small style='color: red;'>" + errors.get("languages") +  "</small>");
            } %>
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
            <% if( errors != null && errors.containsKey("roles") ) {
                out.println("<small style='color: red;'>" + errors.get("roles") +  "</small>");
            } %>
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
            <% if( errors != null && errors.containsKey("idiom") ) {
                out.println("<small style='color: red;'>" + errors.get("idiom") +  "</small>");
            } %>
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