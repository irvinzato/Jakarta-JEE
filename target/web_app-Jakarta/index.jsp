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
    <h1> Aprendamos Jakarta usando Tomcat(Da soporte tanto a servlets como a páginas JSP (Java Server Pages) o Java Sockets  </h1>
    <h1> En este proyecto tengo ejemplos con Servlet enviando parámetros Get por URL o Query String, Formularios, Cabeceras HTTP y Cookies </h1>
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
            <div class="col-sm-4"><input type="text" name="username" id="username" class="form-control" value="${param.username}"></div>
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
            <div class="col-sm-4"><input type="text" name="email" id="email" class="form-control" value="${param.email}"></div>
            <% if( errors != null && errors.containsKey("email") ) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("email") +  "</small>");
            } %>
        </div>
        <div class="row mb-3">
            <label for="country" class="col-form-label col-sm-2">País</label>
            <div class="col-sm-4">
                <select name="country" id="country" class="form-select">
                    <option value="">-- seleccionar --</option>
                    <option value="MX" ${param.country.equals("MX") ? "selected" : ""}>México</option>
                    <option value="ES" ${param.country.equals("ES") ? "selected" : ""}>España</option>
                    <option value="CL" ${param.country.equals("CL") ? "selected" : ""}>Chile</option>
                    <option value="AR" ${param.country.equals("AR") ? "selected" : ""}>Argentina</option>
                    <option value="COL" ${param.country.equals("COL") ? "selected" : ""}>Colombia</option>
                    <option value="PE" ${param.country.equals("PE") ? "selected" : ""}>Perú</option>
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
                    <option value="java"
                    ${paramValues.languages.stream().anyMatch( v -> v.equals("java")).get() ? "selected" : ""}>Java</option>
                    <option value="javascript"
                    ${paramValues.languages.stream().anyMatch( v -> v.equals("javascript")).get() ? "selected" : ""}>JavaScript</option>
                    <option value="jakarta"
                    ${paramValues.languages.stream().anyMatch( v -> v.equals("jakarta")).get() ? "selected" : ""}>Jakarta EE9</option>
                    <option value="angular"
                    ${paramValues.languages.stream().anyMatch( v -> v.equals("angular")).get() ? "selected" : ""}>Angular</option>
                    <option value="spring"
                    ${paramValues.languages.stream().anyMatch( v -> v.equals("spring")).get() ? "selected" : ""}>Spring</option>
                    <option value="react"
                    ${paramValues.languages.stream().anyMatch( v -> v.equals("react")).get() ? "selected" : ""}>React</option>
                </select>
            </div>
            <% if( errors != null && errors.containsKey("languages") ) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("languages") +  "</small>");
            } %>
        </div>
        <div class="row mb-3">
            <label class="col-form-label col-sm-2">Roles</label>
            <div class="form-check col-sm-2">
                <input type="checkbox" name="roles" value="ROLE_ADMIN" class="form-check-input"
                ${paramValues.roles.stream().anyMatch( v -> v.equals("ROLE_ADMIN")).get() ? "checked" : ""}>
                <label class="form-check-label">Administrador</label>
            </div>
            <div class="form-check col-sm-2">
                <input type="checkbox" name="roles" value="ROLE_USER" class="form-check-input"
                ${paramValues.roles.stream().anyMatch( v -> v.equals("ROLE_USER")).get() ? "checked" : ""}>
                <label class="form-check-label">Usuario</label>
            </div>
            <div class="form-check col-sm-2">
                <input type="checkbox" name="roles" value="ROLE_MODERATOR" class="form-check-input"
                ${paramValues.roles.stream().anyMatch( v -> v.equals("ROLE_MODERATOR")).get() ? "checked" : ""}>
                <label class="form-check-label">Moderador</label>
            </div>
            <% if( errors != null && errors.containsKey("roles") ) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("roles") +  "</small>");
            } %>
        </div>
        <div class="row mb-3">
            <label class="col-form-label col-sm-2">Idiomas</label>
            <div class="form-check col-sm-2">
                <input type="radio" name="idiom" value="es" class="form-check-input" ${param.idiom.equals("es") ? "checked" : ""}>
                <label class="form-check-label">Español</label>
            </div>
            <div class="form-check col-sm-2">
                <input type="radio" name="idiom" value="en" class="form-check-input" ${param.idiom.equals("en") ? "checked" : ""}>
                <label class="form-check-label">Ingles</label>
            </div>
            <div class="form-check col-sm-2">
                <input type="radio" name="idiom" value="fr" class="form-check-input" ${param.idiom.equals("fr") ? "checked" : ""}>
                <label class="form-check-label">Frances</label>
            </div>
            <% if( errors != null && errors.containsKey("idiom") ) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("idiom") +  "</small>");
            } %>
        </div>
        <div class="row mb-3">
            <label for="enable" class="col-form-label col-sm-2">Habilitar</label>
            <div class="form-check col-sm-2">
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
<hr>

<div class="px-5">
    <h3> Cabeceras HTTP </h3>

    <ul>
        <li><a href="/web_app/cabeceras-request"> Cabeceras Http request </a></li>
        <li><a href="/web_app/productos.html"> Productos html </a></li>
        <li><a href="/web_app/productos.json"> Mostrar productos JSON </a></li>
        <li>Recibo JSON y transformo a Producto, ocupe POSTMAN</li>
        <li><a href="/web_app/hora-actualizada"> Hora actualizada </a></li>
        <li><a href="/web_app/redirigir"> Redirigir </a></li>
        <li><a href="/web_app/despachar"> Despachar </a></li>
        <li><a href="/web_app/login.html"> Login Ejemplo Status HTTP </a></li>
        <li><a href="/web_app/buscar.html"> Buscar producto. Ejemplo Status HTTP </a></li>
    </ul>
</div>
<hr>

<div class="px-5">
    <h3> Manejo de Cookies(Como base Login anterior) </h3>

    <ul>
        <li><a href="/web_app/productosCookies.html"> Productos Cookies </a></li>
        <li><a href="/web_app/loginCookies.html"> Login con Cookies </a></li> <!-- Transforme archivo a jsp, ahora utiliza método get del Servlet para la ruta -->
        <li><a href="/web_app/logout"> Cerrar Sesión </a></li>
    </ul>
</div>
<hr>

<div class="px-5">
    <h3> Manejo de HttpSession(Como base Login con Cookies) </h3>
    <h3> Extendido a carro de compras </h3>

    <ul>
        <li><a href="/web_app/productosSession.html"> Productos Session </a></li>
        <li><a href="/web_app/loginSession.html"> Login con Session </a></li> <!-- Transforme archivo a jsp, ahora utiliza método get del Servlet para la ruta -->
        <li><a href="/web_app/logoutSession"> Cerrar Sesión </a></li>
        <li><a href="/web_app/ver-carro"> Ver carro de compras </a></li>
    </ul>
</div>

</body>
</html>