<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@page import="model.session.Docente"
import="model.dao.DocenteService"
import="model.dao.DocenteDAO" %>
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
<TITLE>pgsArchivioDocente.jsp</TITLE>
</HEAD>
<BODY>
	<html:form action="/Docente">
		<html:submit property="metodo" value="home"/>
		<br>
		<h1>Elenco Docenti</h1>
		<br><br>
		<logic:empty property="elencoDocenti" name="DocenteForm">
			<div align="center">
				Non ci sono Docenti!
			</div>
			<br><br>
			<html:submit property="metodo" value="nuovo"/>
		</logic:empty>
		<logic:notEmpty property="elencoDocenti" name="DocenteForm">
			<table align="center" border="1">
				<tr>
					<td> </td>
					<td>Docenti</td>
				</tr>
				<logic:iterate id="currentDocente" property="elencoDocenti" name="DocenteForm" type="model.session.Docente">
					<tr>
					<td> <html:radio property="chiave" value="id" idName="currentDocente"></html:radio> </td>
					<td> <bean:write name="currentDocente" property="cognome"/> <bean:write name="currentDocente" property="nome"/> </td>
				</tr>
				</logic:iterate>
			</table>
			<br><br>
			<html:submit property="metodo" value="nuovo"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:submit property="metodo" value="modifica"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:submit onclick="return deleteConfirm()" property="metodo" value="elimina"/>
		</logic:notEmpty>
		<script type="text/javascript"> 
			function deleteConfirm() {
				if(confirm("eliminare il docente selezionato?"))
					return true;
				else
					return false;
			}
		</script>
	</html:form>

</BODY>
</HTML>
