<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PgsGestioneMateria.jsp</title>
</head>
<h1>Gestione Materia</h1>
<body>

	<s:form action="Materia" theme="simple">
		<br>
		<br>
		<s:submit align="left" action="Main" value="Home" />
		<br>
		<br>
		<br>
		<br>
		<s:if test="%{#session.lista.size()==0}">
			Non ci sono Materie
			<br>
			<br>
			<s:submit method="nuovaMateria" value="nuovo" /> &nbsp;&nbsp;&nbsp;&nbsp;
			<s:submit method="annulla" value="annulla" /> &nbsp;&nbsp;&nbsp;&nbsp;
	</s:if>

		<s:else>

			<table border="1">
				<tr>
					<td></td>
					<td>Nome</td>
					<td>Tipologia</td>
				</tr>
				<s:iterator value="#session.lista">
					<tr>
						<td><input type="radio" name="chiave"
							value="'<s:property value="id"/>'"></td>
						<td><s:property value="nome" /></td>
						<td><s:property value="tipologia" />
					</tr>
				</s:iterator>
			</table>
			<br>
			<br>
			<s:submit align="center" method="nuovaMateria" value="nuovo" /> &nbsp;&nbsp;&nbsp;&nbsp;
			<s:submit align="center" method="modificaMateria" value="modifica" /> &nbsp;&nbsp;&nbsp;&nbsp;
			 <s:submit align="center" onclick="return deleteConfirm()"
				method="eliminaMateria" value="elimina" /> &nbsp;&nbsp;&nbsp;&nbsp;
			
	</s:else>

	</s:form>
</body>
</html>