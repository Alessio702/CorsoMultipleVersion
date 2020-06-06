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
		<h2>List Aule</h2>
		<table class="table table-striped">
			<thead>
				<th scope="row">ID</th>
				<th scope="row">Descrizione</th>
				<th scope="row">Numero Posti</th>
				<th></th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${elencoAule}" var="pippo">
					<tr>
						<td>${pippo.id}</td>
						<td>${pippo.descrizione}</td>
						<td>${pippo.numeroPosti}</td>
						<td><spring:url value="/Aula/EditAula/${pippo.id}" var="editURL"/><a href="${editURL}" role="button" class="btn btn-primary">Modifica</a></td>
						<td><spring:url value="/Aula/DeleteAula/${pippo.id}" var="deleteURL"/><a href="${deleteURL}" role="button" class="btn btn-primary">Elimina</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/Aula/AddAula/" var="addURL"/><a href="${addURL}" role="button" class="btn btn-primary">Nuova Aula</a>
	</div>

</body>
</html>