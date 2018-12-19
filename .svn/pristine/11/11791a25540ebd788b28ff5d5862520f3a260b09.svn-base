<%--
  Created by IntelliJ IDEA.
  User: baltmann
  Date: 14/12/2018
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String action = request.getParameter("action"); %>
<form method="get" action="PeliculaServlet">
        <%
        switch (action) {
            case "create": %>
    Nombre:
    <input type="text" name="nombre"/><br>
    Genero:
    <input type="text" name="genero"/><br>
    <input type="hidden" name="action" value="create"/><br>
    <input type="submit" value="Enviar"/>
        <% break; // optional
        case "delete": %>
    Nombre Pelicula:
    <input type="text" name="nombre"/><br>
    <input type="hidden" name="action" value="delete"/><br>
    <input type="submit" value="Enviar"/>
        <% break; // optional
        case "showCatalog": %>
    Nombre Pelicula:
    <input type="text" name="nombre"/><br>
    <input type="hidden" name="action" value="alquilar"/><br>
    <input type="submit" value="Enviar"/>
        <% break; // optional
    } %>
</body>
</html>
