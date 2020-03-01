<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <spring:url value="/resources" var="resourcesPath"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Creacion de imagenes del Banner</title>
    <link href="${resourcesPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${resourcesPath}/bootstrap/css/theme.css" rel="stylesheet">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <spring:url value="/banners/save" var="urlForm"/>
</head>

<body>
<jsp:include page="../includes/menu.jsp"/>
<div class="container theme-showcase" role="main">

<h3 class="blog-title"><span class="label label-success">Datos de la imagen</span></h3>

    <spring:hasBindErrors name="banner">
        <div class='alert alert-danger' role='alert'>
            Por favor corrija los siguientes errores:
            <ul>
                <c:forEach var="error" items="${errors.allErrors}">
                    <li><spring:message message="${error}" /></li>
                </c:forEach>
            </ul>
        </div>
    </spring:hasBindErrors>

    <form:form action="${urlForm}" method="post" modelAttribute="banner" enctype="multipart/form-data">
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <form:hidden path="id"/>
                <label for="titulo">Titulo</label>
                <form:input type="text" class="form-control" path="titulo" id="titulo" required="required"/>
            </div>
        </div>

        <div class="col-sm-3">
            <div class="form-group">
                <label for="status" class="control-label">Status</label>
                <form:select id="status" path="status" class="form-control">
                    <form:option value="Activo">Activo</form:option>
                    <form:option value="Inactivo">Inactivo</form:option>
                </form:select>
            </div>
        </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="archivo">Imagen</label>
                    <input type="file" id="imageFile" name="imageFile" />
                    <form:hidden path="archivo"/>
                    <p class="help-block">Imagen de la pelicula</p>
                </div>
            </div>
    </div>

    <button type="submit" class="btn btn-danger" >Guardar</button>
</form:form>

<hr class="featurette-divider">

<jsp:include page="../includes/footer.jsp"/>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${resourcesPath}/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</body>
</html>
