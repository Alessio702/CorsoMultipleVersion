<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@page import="model.session.Corso"
import="model.session.Docente"
import="model.dao.DocenteService"
import="model.dao.DocenteDAO"
import="model.dao.CorsoService"
import="model.dao.CorsoDAO" %>
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
import="java.util.*"
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>PgsGestioneCorso.jsp</TITLE>
</HEAD>
<BODY>
	<html:form action="/Corso">
		<html:submit property="metodo" value="home"/>
		<br>
		<h1>Elenco Corsi</h1>
		<br><br>
		<logic:empty property="elencoCorsi" name="CorsoForm">
			<div align="center">
				Non ci sono Corsi!
			</div>
			<br><br>
			<html:submit property="metodo" value="nuovo"/>
		</logic:empty>
		<logic:notEmpty property="elencoCorsi" name="CorsoForm">
			<table align="center" border="1">
				<tr>
					<td> </td>
					<td>Corsi</td>
					<td>Durata</td>
					<td>Docente</td>
				</tr>
			
	
				<logic:iterate id="currentCorso" property="elencoCorsi" name="CorsoForm" type="model.session.Corso">
					<tr>
					<td> <html:radio property="chiave" value="id" idName="currentCorso"></html:radio> </td>
					<td><bean:write name="currentCorso" property="corso"/> </td> 
					<td><bean:write name="currentCorso" property="durata"/> </td>
					<bean:define id="currentDocente" name="currentCorso" type="Docente" property="oDocente"/>
					<td><bean:write name="currentDocente" property="nome"/>&nbsp;<bean:write name="currentDocente" property="cognome"/> </td>	
				</tr>
				</logic:iterate>
				
				
			</table>
			<br><br>
			<html:submit property="metodo" value="nuovo"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:submit property="metodo" value="modifica"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<html:submit property="metodo" value="partecipanti"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:submit onclick="return deleteConfirm()" property="metodo" value="elimina"/>
		</logic:notEmpty>
		<script type="text/javascript"> 
			function deleteConfirm() {
				if(confirm("eliminare il Corso selezionato?"))
					return true;
				else
					return false;
			}
		</script>
	</html:form>

</BODY>
</HTML>
