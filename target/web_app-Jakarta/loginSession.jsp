<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login con Session</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="px-5">
    <h3> Login utilizando Session </h3>

    <form action="/web_app/login-servlet-session" method="post">
        <div class="row mb-3">
            <label for="username"  class="col-form-label col-sm-2"> Usuario </label>
            <div class="col-sm-4"><input type="text" name="username" id="username" class="form-control"></div>
        </div>
        <div class="row mb-3">
            <label for="password" class="col-form-label col-sm-2"> Contraseña </label>
            <div class="col-sm-4"><input type="password" name="password" id="password" class="form-control"></div>
        </div>
        <div class="row mb-3">
            <div>
                <input type="submit" value="Login" class="btn btn-primary">
            </div>
        </div>
    </form>
</div>
</body>
</html>