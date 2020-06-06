<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>PgsGestionePersona.jsp</title>
</head>


<h1>Gestione Persona</h1>

<body>


	<s:form action="Persona" theme="simple">
		<br>
		<br>
		<s:submit align="left" action="Main" value="Home" />
		<br>
		<br>
		<br>
		<br>
		<s:if test="%{#session.lista.size()==0}">
			Non ci sono Persone
			<br>
			<br>
			<s:submit method="annulla" value="annulla" /> &nbsp;&nbsp;&nbsp;&nbsp;
		</s:if>


		<s:else>

			<table border="1">
				<tr>
					<td></td>
					<td>Cognome</td>
					<td>Nome</td>
					<td>Tipologia</td>
				</tr>

				<s:iterator value="#session.lista">
					<tr>
						<td><input type="radio" name="chiave"
							value="'<s:property value="id"/>'"></td>
						<td><s:property value="cognome" /></td>
						<td><s:property value="nome" /></td>
						<td><s:property value="class.simpleName" />
					</tr>
				</s:iterator>
			</table>
			<br>
			<br>
			<s:submit method="annulla" value="annulla" /> &nbsp;&nbsp;&nbsp;&nbsp;
		</s:else>
	</s:form>

</body>


</html>