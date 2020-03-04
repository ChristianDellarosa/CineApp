<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<spring:url value="/peliculas/indexPaginate" var="peliculasIndex"/>
<spring:url value="/banners/index" var="bannersIndex"/>
<spring:url value="/noticias/index" var="noticiasIndex"/>
<spring:url value="/about" var="about"/>
<spring:url value="/formLogin" var="login"/>
<spring:url value="/admin/logout" var="logout"/>
<spring:url value="/" var="root"/>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <sec:authorize access="isAnonymous()">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${root}">Cine APP</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="${about}">Acerca</a></li>
                <li><a href="${login}">Login</a></li>
            </ul>
        </div>
        </sec:authorize>

        <sec:authorize access="hasAnyAuthority('EDITOR')">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${root}admin/index">Cine APP | Administracion </a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="${peliculasIndex}?page=0">Peliculas</a></li>
                    <li><a href="${noticiasIndex}">Noticias</a></li>
                    <li><a href="${logout}">Cerrar sesion</a></li>
                </ul>
            </div>
        </sec:authorize>

        <sec:authorize access="hasAnyAuthority('GERENTE')">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${root}admin/index">Cine APP | Nivel gerencial </a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="${peliculasIndex}?page=0">Peliculas</a></li>
                    <li><a href="${bannersIndex}">Banners</a></li>
                    <li><a href="${noticiasIndex}">Noticias</a></li>
                    <li><a href="${logout}">Cerrar sesion</a></li>
                </ul>
            </div>
        </sec:authorize>

    </div>
</nav>