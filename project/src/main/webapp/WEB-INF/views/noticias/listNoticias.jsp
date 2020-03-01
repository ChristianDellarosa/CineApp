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
	<title>Listado de Noticias</title>
		<spring:url value="/resources" var="resourcesPath"/>

	<link href="${resourcesPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${resourcesPath}/bootstrap/css/theme.css" rel="stylesheet">

	</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container theme-showcase" role="main">

		<h3>Listado de Noticias</h3>

		<c:if test="${msg!=null}">
			<div class="alert alert-success" role="alert"> ${msg}</div>
		</c:if>

		<c:if test="${msgDelete!=null}">
			<div class="alert alert-success" role="alert"> ${msgDelete}</div>
		</c:if>

		<spring:url value="/noticias/create" var="create"/>
		<spring:url value="/noticias/edit" var="update"/>
		<spring:url value="/noticias/delete" var="delete"/>
        <a href="${create}" class="btn btn-success" role="button" title="Nueva noticia" >Nueva</a><br><br>
      
        <div class="table-responsive">	
	        <table class="table table-hover table-striped table-bordered">
	          <tr>
	              <th>Id</th>
	              <th>Titulo</th>
	              <th>Fecha</th>
	              <th>Status</th>
	              <th>Opciones</th>
	          </tr>
	
				<c:forEach var="noticia" items="${noticias}">
					<tr>
						<td>${noticia.id}</td>
						<td>${noticia.titulo}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy" value="${noticia.fecha}" /></td>
						<c:choose>
							<c:when test="${noticia.status eq 'Activa'}">
								<td><span class="label label-success">${noticia.status}</span></td>
							</c:when>
							<c:otherwise>
								<td><span class="label label-danger">${noticia.status}</span></td>
							</c:otherwise>
						</c:choose>								
						<td>
						   <a href="${update}/${noticia.id}" class="btn btn-success btn-sm" role="button" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="${delete}/${noticia.id}" onclick='return confirm("¿Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
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