<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>PgsArchivioDocente.jsp</title>
</head>


<h1>Gestione Docente</h1>

<body>


	<s:form action="Docente" theme="simple">
		<br>
		<br>
		<s:submit align="left" action="Main" value="Home" />
		<br>
		<br>
		<br>
		<br>
		<s:if test="%{#session.lista.size()==0}">
			Non ci sono Docenti
			<br>
			<br>
			<s:submit method="nuovoDocente" value="nuovo" /> &nbsp;&nbsp;&nbsp;&nbsp;
			<s:submit method="annulla" value="annulla" /> &nbsp;&nbsp;&nbsp;&nbsp;
		</s:if>


		<s:else>

			<table border="1">
				<tr>
					<td></td>
					<td>Cognome</td>
					<td>Nome</td>
					<td>Anni Esperienza</td>
				</tr>

				<s:iterator value="#session.lista">
					<tr>
						<td><input type="radio" name="chiave"
							value="'<s:property value="id"/>'"></td>
						<td><s:property value="cognome" /></td>
						<td><s:property value="nome" /></td>
						<td><s:property value="anniesp" />
					</tr>
				</s:iterator>
			</table>
			<br>
			<br>
			<s:submit align="center" method="nuovoDocente" value="nuovo" /> &nbsp;&nbsp;&nbsp;&nbsp;
			<s:submit align="center" method="modificaDocente" value="modifica" /> &nbsp;&nbsp;&nbsp;&nbsp;
			 <s:submit align="center" onclick="return deleteConfirm()"
				method="eliminaDocente" value="elimina" /> &nbsp;&nbsp;&nbsp;&nbsp;
				<s:if test="hasActionMessages()">
				<div class="welcome">
					<s:actionmessage />
				</div>
			</s:if>
		</s:else>
	</s:form>

</body>


</html>