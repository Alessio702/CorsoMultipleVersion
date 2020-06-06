<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>PgsArchivioCorso.jsp</title>
</head>


<h1>Gestione Corso</h1>

<body>
	<s:form action="Corso" theme="simple">
		<br>
		<br>
		<s:submit align="left" action="Main" value="Home" />
		<br>
		<br>
		<br>
		<br>
		<s:if test="%{#session.lista.size()==0}">
			Non ci sono Corsi
			<br>
			<br>
			<s:submit method="nuovoCorso" value="nuovo" /> &nbsp;&nbsp;&nbsp;&nbsp;
			<s:submit method="annulla" value="annulla" />
		</s:if>


		<s:else>

			<table border="1">
				<tr>
					<td></td>
					<td>Corso</td>
					<td>Nome</td>
					<td>Cognome</td>
					<td>Durata</td>
				</tr>

				<s:iterator value="#session.lista">
					<tr>
						<td><input type="radio" name="chiave"
							value="'<s:property value="id"/>'"></td>
						<td><s:property value="corso" /></td>
						<td><s:property value="odocente.nome" /></td>
						<td><s:property value="odocente.cognome" /></td>
						<td><s:property value="durata" /></td>
					</tr>
				</s:iterator>
			</table>
			<br>
			<br>
		 <s:submit align="center"
				method="nuovoCorso" value="nuovo" /> 
			<s:submit align="center" method="modificaCorso" value="modifica" /> 
			 <s:submit align="center" onclick="return deleteConfirm()"
				method="eliminaCorso" value="elimina" />
			
		</s:else>
	</s:form>

</body>


</html>