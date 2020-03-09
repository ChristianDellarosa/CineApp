<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login</title>
    <spring:url value="/resources" var="resourcesPath" />
    <spring:url value="/" var="urlRoot" />

    <link href="${resourcesPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${resourcesPath}/bootstrap/css/theme.css" rel="stylesheet">
    <link href="${resourcesPath}/bootstrap/css/signin.css" rel="stylesheet">

</head>

<body>

<div class="container theme-showcase" role="main">

    <hr class="featurette-divider">

    <img src="${resourcesPath}/images/login.png" width="136" height="136" class="center">

    <form class="form-signin" action="${urlRoot}login" method="post">

        <c:if test="${param.error!= null}">
           <%-- <img src="${resourcesPath}/images/error.png" width="48" height="48" class="center"> --%>
            <h4 class="form-signin-heading" style="color:red">Acceso denegado</h4>
        </c:if>

        <h3 class="form-signin-heading">CineApp | Administracion</h3>
        <label for="username" class="sr-only">Usuario</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required autofocus>
        <label for="password" class="sr-only">Contraseña</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
    </form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${resourcesPath}/bootstrap/js/bootstrap.min.js" ></script>
</body>
</html>