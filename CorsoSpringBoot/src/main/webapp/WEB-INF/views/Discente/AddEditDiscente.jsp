<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>AddEditDiscente</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<a class="btn btn-light" href="http://localhost:8086/menu/List" role="button">Home</a> 
<a class="btn btn-light" href="http://localhost:8086/Discente/ListaDiscenti" role="button">Indietro</a> 
<body>
	<div class="container">
		<spring:url value="/Discente/SaveDiscente/" var="saveURL" />
		<h2>Add Edit Discente</h2>
		<form:form modelAttribute="oggettoDiscente" method="post"
			action="${saveURL}" cssClass="form">
			<form:hidden path="id" />
			<div class="form-group">
				<label>Nome</label>
				<form:input path="nome" cssClass="form-control" id="nome" />
				<form:errors path="nome" cssClass="error"/>
			</div>
			<div class="form-group">
				<label>Cognome</label>
				<form:input path="cognome" cssClass="form-control" id="cognome" />
				<form:errors path="cognome" cssClass="error"/>
			</div>
			<div class="form-group">
				<label>Matricola</label>
				<form:input path="matricola" cssClass="form-control" id="matricola" />
				<form:errors path="matricola" cssClass="error"/>
			</div>
			<button type="submit" class="btn btn-primary">Salva</button>
		</form:form>
	</div>
</body>
</html>