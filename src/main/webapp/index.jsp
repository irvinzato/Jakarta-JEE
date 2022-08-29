<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%
    Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Jakarta con Tomcat - Formularios</title> <!-- Puedo añadir de forma local Bootstrap V-417 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="px-5">
    <h1> Aprendamos Jakarta usando Tomcat(Da soporte tanto a servlets como a páginas JSP (Java Server Pages) o Java Sockets)  </h1>
    <h1> En este proyecto tengo ejemplos con Servlet enviando parámetros Get por URL o Query String y Formularios </h1>
    <a href="/web_app/parametros/url-get?hi=Hola animo"> Enviando parámetro 'hi'</a> <br>
    <a href="/web_app/parametros/url-get?hi=Hola animo&name=Irving"> Enviando 2 parámetros </a> <br>
    <a href="/web_app/parametros/url-get?name=Irving"> Enviando parámetro 'name' </a> <br>
    <a href="/web_app/parametros/url-get?hi=Hola animo&name=Irving&code=423"> Enviando 3 parámetros, con código </a> <br>
    <a href="/web_app/parametros/url-get"> Sin parámetros </a>
    <hr>
</div>

    <h3 class="px-5"> Formulario de usuarios </h3>
    <%
        if( errors != null && errors.size() > 0 ) {
    %>
    <ul class="alert alert-danger mx-5">
        <% for( String err: errors.values() ) { %>
            <li> <% out.print(err); %> </li>
        <% } %>
    </ul>
    <% } %>

    <div class="px-5">
        <form action="/web_app/registro" method="post"> <!-- Importante indicar "method" post porque por defecto seria get-->
            <div class="row mb-3">
                <label for="username" class="col-form-label col-sm-2">Usuario</label> <!-- "for" enlaza con "id" para que también reaccione al dar click en etiqueta -->
                <div class="col-sm-4"><input type="text" name="username" id="username" class="form-control"></div>
                <% if( errors != null && errors.containsKey("username") ) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("username") +  "</small>");
                } %>
            </div>
            <div class="row mb-3">
                <label for="password" class="col-form-label col-sm-2">Contraseña</label>
                <div class="col-sm-4"><input type="password" name="password" id="password" class="form-control"></div>
                <% if( errors != null && errors.containsKey("password") ) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("password") +  "</small>");
                } %>
            </div>
            <div class="row mb-3">
                <label for="email" class="col-form-label col-sm-2">Email</label>
                <div class="col-sm-4"><input type="text" name="email" id="email" class="form-control"></div>
                <% if( errors != null && errors.containsKey("email") ) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("email") +  "</small>");
                } %>
            </div>
            <div class="row mb-3">
                <label for="country" class="col-form-label col-sm-2">País</label>
                <div class="col-sm-4">
                    <select name="country" id="country" class="form-select">
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
                    out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("country") +  "</small>");
                } %>
            </div>
            <div class="row mb-3">
                <label for="languages" class="col-form-label col-sm-2">Lenguajes de programación</label>
                <div class="col-sm-4">
                    <select name="languages" id="languages" multiple class="form-select">
                        <option value="java" selected>Java</option>
                        <option value="javascript">JavaScript</option>
                        <option value="jakarta">Jakarta EE9</option>
                        <option value="angular" selected>Angular</option>
                        <option value="spring">Spring</option>
                        <option value="react">React</option>
                    </select>
                </div>
                <% if( errors != null && errors.containsKey("languages") ) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("languages") +  "</small>");
                } %>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2">Roles</label>
                <div class="form-check">
                    <input type="checkbox" name="roles" value="ROLE_ADMIN" class="form-check-input">
                    <label class="form-check-label">Administrador</label>
                </div>
                <div class="form-check">
                    <input type="checkbox" name="roles" value="ROLE_USER" checked class="form-check-input">
                    <label class="form-check-label">Usuario</label>
                </div>
                <div class="form-check">
                    <input type="checkbox" name="roles" value="ROLE_MODERATOR" class="form-check-input">
                    <label class="form-check-label">Moderador</label>
                </div>
                <% if( errors != null && errors.containsKey("roles") ) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("roles") +  "</small>");
                } %>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2">Idiomas</label>
                <div class="form-check">
                    <input type="radio" name="idiom" value="es" class="form-check-input">
                    <label class="form-check-label">Español</label>
                </div>
                <div class="form-check">
                    <input type="radio" name="idiom" value="en" class="form-check-input">
                    <label class="form-check-label">Ingles</label>
                </div>
                <div class="form-check">
                    <input type="radio" name="idiom" value="fr" class="form-check-input">
                    <label class="form-check-label">Frances</label>
                </div>
                <% if( errors != null && errors.containsKey("idiom") ) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("idiom") +  "</small>");
                } %>
            </div>
            <div class="row mb-3">
                <label for="enable" class="col-form-label col-sm-2">Habilitar</label>
                <div class="form-check">
                    <input type="checkbox" name="enable" id="enable" checked class="form-check-input">
                </div>
            </div>
            <div class="row mb-3">
                <div>
                    <input type="submit" value="Enviar" class="btn btn-primary">
                </div>
            </div>
            <input type="hidden" name="secret" value="12345"> <!--El campo secreto normalmente va después del botón submit pero antes del form-->
        </form>
    </div>
</body>
</html>