<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>PgsArchivioDiscente.jsp</title>
</head>


<h1>Gestione Discente</h1>

<body>
	<s:form action="Discente" theme="simple">
		<br>
		<br>
		<s:submit align="left" action="Main" value="Home" />
		<br>
		<br>
		<br>
		<br>
		<s:if test="%{#session.lista==0}">
			Non ci sono Discenti
			<br>
			<br>
			<s:submit method="nuovoDiscente" value="nuovo" /> &nbsp;&nbsp;&nbsp;&nbsp;
			<s:submit method="annulla" value="annulla" /> &nbsp;&nbsp;&nbsp;&nbsp;
		</s:if>


		<s:else>

			<table border="1">
				<tr>
					<td></td>
					<td>Cognome</td>
					<td>Nome</td>
					<td>Matricola</td>
				</tr>

				<s:iterator value="#session.lista">
					<tr>
						<td><input type="radio" name="chiave"
							value="'<s:property value="id"/>'"></td>
						<td><s:property value="cognome" /></td>
						<td><s:property value="nome" /></td>
						<td><s:property value="matricola" /></td>
					</tr>
				</s:iterator>
			</table>
			<br>
			<br>
		  &nbsp;&nbsp;&nbsp;&nbsp; <s:submit align="center"
				method="nuovoDiscente" value="nuovo" /> &nbsp;&nbsp;&nbsp;&nbsp;
			<s:submit align="center" method="modificaDiscente" value="modifica" /> &nbsp;&nbsp;&nbsp;&nbsp;
			 <s:submit align="center" onclick="return deleteConfirm()"
				method="eliminaDiscente" value="elimina" /> &nbsp;&nbsp;&nbsp;&nbsp;
			
		</s:else>
	</s:form>

</body>


</html>