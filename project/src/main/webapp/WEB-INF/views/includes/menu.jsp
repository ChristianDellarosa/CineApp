<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/peliculas/indexPaginate" var="peliculasIndex"/>
<spring:url value="/banners/index" var="bannersIndex"/>
<spring:url value="/" var="root"/>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href=${root}>Cine APP</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">Acerca</a></li>
                <li><a href="${peliculasIndex}?page=0">Peliculas</a></li>
                <li><a href="${bannersIndex}">Banners</a></li>
                <li><a href="#">Login</a></li>
            </ul>
        </div>
    </div>
</nav>