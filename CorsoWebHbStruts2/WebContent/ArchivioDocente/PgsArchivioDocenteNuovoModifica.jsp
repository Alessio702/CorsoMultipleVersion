<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<head>
<title>PgsArchivioDocenteNuovoModifica.jsp</title>
</head>



<h1>Gestione Docente</h1>

<body>

	<script type="text/javascript">
function setIdMateria(id)
{
	document.getElementById("idMat").value = id;
	}
</script>


	<s:form action="Docente">
		<s:hidden id="idMat" name="idMateria" />
		<s:hidden name="id" />
		<table>
			<tr>
				<s:textfield label="nome" name="nomeDoc"
					value="%{#session.oggetto.nome}" />
			</tr>
			<tr>
				<s:textfield label="cognome" name="cognomeDoc"
					value="%{#session.oggetto.cognome}" />
			</tr>
			<tr>
				<s:textfield label="Anni Esperienza" name="anniEspDoc"
					value="%{#session.oggetto.anniesp}" />
			</tr>
		</table>
		<br>
		<br>


		<table border="1">
			<tr>
				<td>Nome</td>
				<td>Tipologia</td>
				<td></td>
			</tr>
			<s:iterator value="#session.listamaterie">
				<tr>
					<td><s:property value="nome" /></td>
					<td><s:property value="tipologia" /></td>
					<td><s:set var="varId" value="id" /> <s:set var="isMateria"
							value="false" /> <s:iterator value="#session.oggetto.materie">
							<s:if test="%{#varId.equals(id)}">
								<s:set var="isMateria" value="true" />
							</s:if>
						</s:iterator> <s:if test="%{#isMateria==false}">
							<input type="image" src="Symbol-Error.png"
								onclick="setIdMateria('<s:property value="id"/>')"
								name="method:aggiungiMateria" />
						</s:if> <s:else>
							<input type="image" src="Symbol-Check.png"
								onclick="setIdMateria('<s:property value="id"/>')"
								name="method:rimuoviMateria" />
						</s:else></td>
				</tr>
			</s:iterator>
		</table>


		<br>
		<br>
		<s:submit method="registra" value="registra" />
		<s:submit method="annulla" value="annulla" />


		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>

	</s:form>

</body>




</html>
