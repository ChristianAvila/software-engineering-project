<%@taglib uri="http://www.springframework.org/tags/form" 
prefix="form"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comprar</title>
</head>
<body>
<form:form method="POST" action="/LaboratorioSpringAOPMVC/Comprar" commandName="articulo">
<form:label path="titulo">Título:</form:label>
<form:input path="titulo"/>
<br>
<form:label path="cantidad">Cantidad:</form:label>
<form:input path="cantidad"/>
<br>
<input type="submit" value="Enviar"/>
</form:form>
${mensaje}
</body>
</html>