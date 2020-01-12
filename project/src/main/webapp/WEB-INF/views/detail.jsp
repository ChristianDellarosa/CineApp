<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  <%-- JSTL --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> <%-- JSTL --%>
<html>
<head>
    <title>Detalle de la pelicula</title>
</head>
<body>
    <h1>Titulo Pelicula: ${peliculas.get(id).titulo}</h1>
    <h2>Duracion: ${peliculas.get(id).duracion}</h2>
    <h3>Genero: ${peliculas.get(id).genero}</h3>
</body>
</html>
