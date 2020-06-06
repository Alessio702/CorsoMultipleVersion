<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
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
<TITLE>PgsGestionePartecipanti.jsp</TITLE>
</HEAD>
<BODY>
	<html:form action="/Corso">
		<html:submit property="metodo" value="home"/>
		<br>
		<h1>Elenco Non Partecipanti</h1>
		<br><br>
		<logic:empty property="oCorso.nonpartecipanti" name="CorsoForm">
			<div align="center">
				Non ci sono Discenti!
			</div>
			<br><br>
			<html:submit property="metodo" value="annulla"/>
		</logic:empty>
		<logic:notEmpty property="oCorso.nonpartecipanti" name="CorsoForm">
			<table align="center" border="1">
				<tr>
					<td> </td>
					<td>Nome</td>
					<td>Cognome</td>
					<td>Matricola</td>
				</tr>
			
	
				<logic:iterate id="currentCorso" property="oCorso.nonpartecipanti" name="CorsoForm" type="model.session.Discente">
					<tr>
					<td> <html:radio property="chiave" value="id" idName="currentCorso"></html:radio> </td>
					<td><bean:write name="currentCorso" property="nome"/> </td> 
					<td><bean:write name="currentCorso" property="cognome"/> </td>
					<td><bean:write name="currentCorso" property="matricola"/> </td>	
				</tr>
				</logic:iterate>
				
				
			</table>
			<br><br>
			<html:submit property="metodo" value="annulla"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:submit property="metodo" value="aggiungi_partecipanti"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</logic:notEmpty>
		
	</html:form>

</BODY>
</HTML>
