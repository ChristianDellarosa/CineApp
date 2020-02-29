<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
<jsp:include page="../includes/menu.jsp"></jsp:include>
<div class="container theme-showcase" role="main">

<h3 class="blog-title"><span class="label label-success">Datos de la imagen</span></h3>

<form action=${urlForm} method="post" enctype="multipart/form-data">
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label for="titulo">Titulo</label>
                <input type="text" class="form-control" name="titulo" id="titulo" required="required"/>
            </div>
        </div>

        <div class="col-sm-3">
            <div class="form-group">
                <label for="status">Status</label>
                <select id="status" name="status" class="form-control">
                    <option value="Activo">Activo</option>
                    <option value="Inactivo">Inactivo</option>
                </select>
            </div>
        </div>

        <div class="col-sm-3">
            <div class="form-group">
                <label for="archivo">Imagen</label>
                <input type="file" id="archivo" name="archivo" required="required" />
                <p class="help-block">Tamaño recomendado: 1140 x 250 </p>
            </div>
        </div>

    </div>

    <button type="submit" class="btn btn-danger" >Guardar</button>
</form>

<hr class="featurette-divider">

<jsp:include page="../includes/footer.jsp"></jsp:include>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${resourcesPath}/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</body>
</html>
