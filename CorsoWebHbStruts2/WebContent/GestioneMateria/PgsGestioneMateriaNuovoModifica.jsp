<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PgsGestioneMateriaNuovoModifica.jsp</title>
</head>
<h1>Modifica Materia</h1>
<body>
	<s:form action="Materia">

		<table>
			<tr>
				<s:textfield label="nome" name="nomeMat"
					value="%{#session.oggetto.nome}" />
			</tr>
			<tr>
				<s:textfield label="tipologia" name="tipologiaMat"
					value="%{#session.oggetto.tipologia}" />
			</tr>
		</table>
		<br>
		<br>
		<br>
		<br>
		<s:submit method="registra" value="registra" />
		<s:submit method="annulla" value="annulla" />
	</s:form>
</body>
</html>








