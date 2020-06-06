<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddEditAula</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<a class="btn btn-light" href="http://localhost:8086/menu/List" role="button">Home</a> 
<a class="btn btn-light" href="http://localhost:8086/Aula/ListaAule" role="button">Indietro</a> 
<body>
	<div class="container">
		<spring:url value="/Aula/SaveAula/" var="saveURL" />
		<h2>Add Edit Aula</h2>
		<form:form modelAttribute="oggettoAula" method="post"
			action="${saveURL}" cssClass="form">
			<form:hidden path="id" />
			<div class="form-group">
				<label>Descrizione</label>
				<form:input path="descrizione" cssClass="form-control" id="descrizione" />
					<form:errors path="descrizione" cssClass="error"/>
			</div>
			<div class="form-group">
			<label>Numero Posti</label>
			<form:input path="numeroPosti" cssClass="form-control" id="numeroPosti" />
			<form:errors path="numeroPosti" cssClass="error"/>
			</div>
			<button type="submit" class="btn btn-primary">Salva</button>
		</form:form>
	</div>
</body>
</html>