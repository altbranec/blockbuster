
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String action=request.getParameter("action"); %>
<form method="get" action="Usuario">
<%
switch(action) {
case "create" : %>
   	Nombre:
	<input type="text" name="nombre"/><br>
	Dni:
	<input type="text" name="dni"/><br>
	<input type="hidden" name="action" value="create"/><br>
	<input type="submit" value="Enviar"/>
<% break; // optional 
case "delete" : %>
	Dni:
	<input type="text" name="dni"/><br>
	<input type="hidden" name="action" value="delete"/><br>
	<input type="submit" value="Enviar"/>
<% break; // optional 
case "Alquilar" : %>
	Nombre Pelicula:
	<input type="text" name="nombre"/><br>
	<input type="hidden" name="action" value="alquilar"/><br>
	<input type="submit" value="Enviar"/>
	<% break; // optional 
case "devolver" : %>
	Nombre Pelicula:
	<input type="text" name="nombre"/><br>
	Dni Usuario:
	<input type="text" name="dni"/><br>
	<input type="hidden" name="action" value="devolver"/><br>
	<input type="submit" value="Enviar"/>
	<% break; // optional 
} %>
</form> 
</body>
</html>