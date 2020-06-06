<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@page import="model.session.Discente"
import="model.dao.DiscenteService"
import="model.dao.DiscenteDAO" %>
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
<TITLE>pgsArchivioDiscente.jsp</TITLE>
</HEAD>
<BODY>
	<html:form action="/Discente">
		<html:submit property="metodo" value="home"/>
		<br>
		<h1>Elenco Discenti</h1>
		<br><br>
		<logic:empty property="elencoDiscenti" name="DiscenteForm">
			<div align="center">
				Non ci sono Discenti!
			</div>
			<br><br>
			<html:submit property="metodo" value="nuovo"/>
		</logic:empty>
		<logic:notEmpty property="elencoDiscenti" name="DiscenteForm">
			<table align="center" border="1">
				<tr>
					<td> </td>
					<td>Discenti</td>
				</tr>
				<logic:iterate id="currentDiscente" property="elencoDiscenti" name="DiscenteForm" type="model.session.Discente">
					<tr>
					<td> <html:radio property="chiave" value="id" idName="currentDiscente"></html:radio> </td>
					<td> <bean:write name="currentDiscente" property="cognome"/> <bean:write name="currentDiscente" property="nome"/> <bean:write name="currentDiscente" property="matricola"/> </td>
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
				if(confirm("eliminare il Discente selezionato?"))
					return true;
				else
					return false;
			}
		</script>
	</html:form>

</BODY>
</HTML>
