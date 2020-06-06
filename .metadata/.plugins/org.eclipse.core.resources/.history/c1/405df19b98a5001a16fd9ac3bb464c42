<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListAule</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>

</head>
<a class="btn btn-light" href="http://localhost:8086/menu/List" role="button">Indietro</a> 
<body>
	<div class="container">
		<h2>Lista Docenti</h2>
		<table class="table table-striped">
			<thead>
				<th scope="row">ID</th>
				<th scope="row">Nome</th>
				<th scope="row">Cognome</th>
				<th></th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${elencoDocenti}" var="elenco">
					<tr>
						<td>${elenco.id}</td>
						<td>${elenco.nome}</td>
						<td>${elenco.cognome}</td>
						<td><spring:url value="/Docente/EditDocente/${elenco.id}" var="editURL"/><a href="${editURL}" role="button" class="btn btn-primary">Modifica</a></td>
						<td><spring:url value="/Docente/DeleteDocente/${elenco.id}" var="deleteURL"/><a href="${deleteURL}" role="button" class="btn btn-primary">Elimina</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/Docente/AddDocente/" var="addURL"/><a href="${addURL}" role="button" class="btn btn-primary">Nuovo Docente</a>
	</div>

</body>
</html>