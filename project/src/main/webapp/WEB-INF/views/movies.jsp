<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <spring:url value="/resources" var="resourcesPath"/>

    <title>Bienvenido a Cine APP</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


</head>
<body>
<h1>Bienvenido a Home</h1>

<div class="panel panel-default">
    <div class="panel-heading">Tabla de Peliculas</div>
    <div class="panel-body">
        <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Duracion(min)</th>
                <th>Clasificacion</th>
                <th>Genero</th>
                <th>Imagen</th>
                <th>Fecha de Estreno</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${peliculas}" var="pelicula">
                <tr>
                    <td>${pelicula.id}</td>
                    <td>${pelicula.titulo}</td>
                    <td>${pelicula.duracion}</td>
                    <td>${pelicula.clasificacion}</td>
                    <td>${pelicula.genero}</td>
                    <td><img src="${resourcesPath}/images/movies/${pelicula.imagen}" width="80" height="100"></td>
                    <td><fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd-MM-yyyy"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${pelicula.status==true}">
                                <span class="label label-success">ACTIVA</span>
                            </c:when>
                            <c:otherwise>
                                <span class="label label-danger">INACTIVA</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
