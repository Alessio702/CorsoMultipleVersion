<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<head>
<title>PgsArchivioCorsoNuovo.jsp</title>
</head>



<h1>Nuovo Corso</h1>

<body>

	<script type="text/javascript">
	function setIdPartecipante(id) 
	{
		document.getElementById("idPart").value = id;
	}
	</script>

	<s:form action="Corso">
		<s:hidden id="idPart" name="idPartecipante" />

		<table>

			<tr>
				<s:textfield label="corso" name="corsoCor"
					value="%{#session.oggetto.corso}" />
			</tr>
			<tr>
				<s:select label="Docente" name="IDDocente" list="#session.mappa"
					value="%{#session.oggetto.odocente.id}" />
			</tr>
			<tr>
				<s:textfield label="durata" name="durataCor"
					value="%{#session.oggetto.durata}" />
			</tr>
			<tr>
				<s:select label="Materia" name="IDMateria"
					list="#session.mappamaterie"
					value="%{#session.oggetto.omateria.id}" />
			</tr>

		</table>
		<table border="1">
			<tr>
				<td>Cognome</td>
				<td>Nome</td>
				<td>Matricola</td>
				<td></td>
			</tr>
			<s:iterator value="#session.listadisc">
				<tr>
					<td><s:property value="cognome" /></td>
					<td><s:property value="nome" /></td>
					<td><s:property value="matricola" /></td>
					<td><s:set var="varId" value="id" /> <s:set var="isPartecipante" value="false" /> <s:iterator value="#session.oggetto.partecipanti">
							<s:if test="%{#varId.equals(id)}">
								<s:set var="isPartecipante" value="true" />
							</s:if>
						</s:iterator> <s:if test="%{#isPartecipante==false}">
							<input type="image" src="Symbol-Error.png" onclick="setIdPartecipante('<s:property value="id"/>')" name="method:aggiungiPartecipante" />
						</s:if> <s:else>
							<input type="image" src="Symbol-Check.png" onclick="setIdPartecipante('<s:property value="id"/>')" name="method:rimuoviPartecipante" />
						</s:else></td>
				</tr>
			</s:iterator>
		</table>
		<br>
		<br>
		<br>
		<br>
		<s:submit align="center" method="registra" value="registra" />
		<s:submit align="center" method="annulla" value="annulla" />
	</s:form>

</body>




</html>
