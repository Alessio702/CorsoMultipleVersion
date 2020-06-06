<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"      "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />

<script src="../../webjars/jquery/3.4.1/js/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="../../webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>

 <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  <script>
$(function() {
    $( "#datepicker" ).datepicker(
    		{
    			 dateFormat: "dd/mm/yy",
                 showOtherMonths: true,
                 selectOtherMonths: true,
                 showButtonPanel: true,
                 changeMonth: true,
                 changeYear: true,
                 gotoCurrent: true,
    		}).datepicker("setDate", new Date());
});
</script>

</head>
<a class="btn btn-light" href="http://localhost:8086/menu/List"
	role="button">Home</a>
<a class="btn btn-light" href="http://localhost:8086/Corso/ListaCorsi"
	role="button">Indietro</a>
	
<body>
	<div class="container">
		<spring:url value="/Corso/SaveCorso" var="saveURL" />
		<form:form modelAttribute="oggettoCorso" method="post" action="${saveURL}" cssClass="form">
			<form:hidden path="id" />
		
			<div class="form-group">
				<label>Corso</label>
				<form:input path="corso" cssClass="form-control" id="corso" />
						<form:errors path="corso" cssClass="error"/>
			</div>
			<div class="form-group">
			Date: <form:input path="datainizio" type="text" id="datepicker" />
			</div>
			<div class="form-group">
				<label>Durata</label>
				<form:input path="durata" cssClass="form-control" id="durata" />
						<form:errors path="durata" cssClass="error"/>
			</div>
			


	
			
			<div class="form-group">
				<label>Docente</label>
				<form:select path="odocente" cssClass="form-control" id="docente">
					<form:option value="0">Seleziona un Docente:</form:option>
					<form:options items="${elencoDocenti}" itemValue="id" itemLabel="fullName" />
				</form:select>
							<form:errors path="odocente" cssClass="error"/>
			</div>
			
			<div class="form-group">
				<label>Aula</label>
				<form:select path="oaula" cssClass="form-control" id="aula">
					<form:option value="0">Seleziona un'Aula:</form:option>
					<form:options items="${elencoAule}" itemValue="id" itemLabel="descrizione" />
				</form:select>
							<form:errors path="oaula" cssClass="error"/>
			</div>

			<div class="btn-group-vertical">
				<h3>Aggiungi studente:</h3>
				<form:checkboxes items="${elencoDiscenti}" path="partecipanti" itemValue="id" itemLabel="fullStudent" />
						<form:errors path="partecipanti" cssClass="error"/>
			</div>
			&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-primary">Salva</button>
		</form:form>
	</div>

</body>

</html>