<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<head>
<title>PgsArchivioDiscenteNuovoModifica.jsp</title>
</head>



<h1>Modifica Discente</h1>

<body>

	<s:form action="Discente">

		<table>
			<tr>
				<s:textfield label="nome" name="nomeDisc"
					value="%{#session.oggetto.nome}" />
			</tr>
			<tr>
				<s:textfield label="cognome" name="cognomeDisc"
					value="%{#session.oggetto.cognome}" />
			</tr>
			<tr>
				<s:textfield label="matricola" name="matricolaDisc"
					value="%{#session.oggetto.matricola}" />
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
