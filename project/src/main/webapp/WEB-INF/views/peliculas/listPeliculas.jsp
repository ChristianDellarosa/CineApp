<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <spring:url value="/resources" var="resourcesPath"/>
    <spring:url value="/peliculas/create" var="create"/>
    <spring:url value="/peliculas/edit" var="update"/>
    <spring:url value="/peliculas/delete" var="delete"/>
    <spring:url value="/peliculas/indexPaginate" var="paginate"/>
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Peliculas</title>
    <link href="${resourcesPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${resourcesPath}/bootstrap/css/theme.css" rel="stylesheet">
</head>

<body>

<jsp:include page="../includes/menu.jsp"></jsp:include>

<div class="container theme-showcase" role="main">

    <h3>Listado de Peliculas</h3>

    <c:if test="${msg!=null}">
        <div class="alert alert-success" role="alert"> ${msg}</div>
    </c:if>

    <c:if test="${msgDelete!=null}">
        <div class="alert alert-success" role="alert"> ${msgDelete}</div>
    </c:if>

    <a href="${create}" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva Pelicula</a><br><br>

    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Titulo</th>
                <th>Genero</th>
                <th>Clasificacion</th>
                <th>Duracion</th>
                <th>Fecha De Estreno</th>
                <th>Status</th>
                <th>Opciones</th>
            </tr>
                 <c:forEach var="pelicula" items="${peliculas.content}">
                 <tr>
                        <td>${pelicula.titulo}</td>
                        <td>${pelicula.genero}</td>
                        <td>${pelicula.clasificacion}</td>
                        <td>${pelicula.duracion}</td>
                        <td>${pelicula.fechaEstreno}</td>
                        <td> <c:choose>
                                <c:when test="${pelicula.status eq 'Activa'}">
                                    <span class="label label-success">Activa</span>
                                 </c:when>
                                 <c:otherwise>
                                     <span class="label label-danger">Inactiva</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    <td>
                    <a href="${update}/${pelicula.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="${delete}/${pelicula.id}" onclick='return confirm("Estas seguro?") ' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                    </td>
            </tr>
                </c:forEach>
        </table>
    </div>
    <nav aria-label="">
        <ul class="pager">
            <li><a href="${paginate}?page=${peliculas.number - 1 }">Anterior</a></li>
            <li><a href="${paginate}?page=${peliculas.number + 1 }">Siguiente</a></li>
        </ul>
    </nav>

    <hr class="featurette-divider">

    <jsp:include page="../includes/footer.jsp"></jsp:include>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${resourcesPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>