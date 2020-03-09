<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Usuarios</title>
    <spring:url value="/resources" var="resourcesPath"/>

    <link href="${resourcesPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${resourcesPath}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

<jsp:include page="../includes/menu.jsp"></jsp:include>

<div class="container theme-showcase" role="main">

    <h3>Listado de Usuarios</h3>

    <c:if test="${msg!=null}">
        <div class="alert alert-success" role="alert"> ${msg}</div>
    </c:if>

    <c:if test="${msgDelete!=null}">
        <div class="alert alert-success" role="alert"> ${msgDelete}</div>
    </c:if>

    <spring:url value="/usuarios/create" var="create"/>
    <spring:url value="/usuarios/edit" var="update"/>
    <spring:url value="/usuarios/delete" var="delete"/>
    <a href="${create}" class="btn btn-success" role="button" title="Nuevo usuario" >Nuevo</a><br><br>

    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Username</th>
                <th>Activo</th>
                <th>Email</th>
                <th>Telefono</th>
                <th>Opciones</th>
            </tr>

            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.username}</td>
                    <c:choose>
                        <c:when test="${usuario.activo == 1}">
                            <td><span class="label label-success">Activo</span></td>
                        </c:when>
                        <c:otherwise>
                            <td><span class="label label-danger">Inactivo</span></td>
                        </c:otherwise>
                    </c:choose>
                    <td>${usuario.email}</td>
                    <td>${usuario.telefono}</td>
                    <td>
          <%--          <a href="${update}/${usuario.id}" class="btn btn-success btn-sm" role="button" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a> --%>
                        <a href="${delete}/${usuario.id}" onclick='return confirm("�Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>

    <hr class="featurette-divider">

    <jsp:include page="../includes/footer.jsp"></jsp:include>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${resourcesPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>