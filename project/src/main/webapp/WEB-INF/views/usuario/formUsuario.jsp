<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">
    <title>Creacion de Usuarios</title>
    <spring:url value="/resources" var="resourcesPath" />
    <spring:url value="/usuarios/save" var="save" />
    <link href="${resourcesPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${resourcesPath}/bootstrap/css/theme.css" rel="stylesheet">
</head>

<body>

<jsp:include page="../includes/menu.jsp" />

<div class="container theme-showcase" role="main">

    <h3 class="blog-title"><span class="label label-success">Datos del Usuario</span></h3>

    <form:form action="${save}" method="post" modelAttribute="usuario">
        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="perfil" class="control-label">PERFIL</label>
                    <select id="perfil" name="perfil" class="form-control">
                        <option value="EDITOR">EDITOR</option>
                        <option value="GERENTE">GERENTE</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="username">Cuenta</label>
                    <form:input type="text" class="form-control" path="username" id="username" placeholder="Usuario" required="required"/>
                </div>
            </div>

            <div class="col-sm-3">
                <div class="form-group">
                    <label for="password">Password</label>
                    <form:input type="password" class="form-control" path="password" id="password" placeholder="Contraseña" required="required"/>
                </div>
            </div>

            <div class="col-sm-3">
                <div class="form-group">
                    <label for="email">Email</label>
                    <form:input type="text" class="form-control" path="email" id="email" placeholder="Correo electrónico" required="required"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="telefono">Teléfono</label>
                    <form:input type="text" class="form-control" path="telefono" id="telefono" placeholder="Telefono" required="required"/>
                </div>
            </div>

            <div class="col-sm-3">
                <div class="form-group">
                    <label for="activo" class="control-label">Activo</label>
                    <form:select id="activo" path="activo" class="form-control">
                        <option value=1 selected >Activo</option>
                        <option value=0>Inactivo</option>
                    </form:select>
                </div>
            </div>

        </div>

        <button type="submit" class="btn btn-danger" >Guardar</button>
    </form:form>

    <hr class="featurette-divider">

    <jsp:include page="../includes/footer.jsp" />

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${resourcesPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
