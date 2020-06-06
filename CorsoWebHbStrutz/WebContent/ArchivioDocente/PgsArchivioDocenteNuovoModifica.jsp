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
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>pgsArchivioDocenteNuovoModifica.jsp</TITLE>
</HEAD>
<BODY>


<P align="center"><FONT size="+2" color="green">Docente</FONT></P>


<html:form action="/Docente">

	<TABLE  align="center" >
		<tr>
			<td>Cognome:</td>
			<td>
				<html:text property="oDocente.cognome"> </html:text>
			</td>
	</tr>	

<tr>

	<td>
	&nbsp;
	</td>
	
</tr>

	<tr>
		<td>
			Nome: 
		</td>
		<td>	 
			<html:text property="oDocente.nome"> </html:text>
		</td>
	</tr>
</TABLE >
<BR/> 
<BR/>
<DIV align="center">

<html:submit property="metodo" value="registra"/>
&nbsp;&nbsp;&nbsp;&nbsp;
<html:submit property="metodo" value="annulla"/>
<BR>
</DIV>
</html:form>
</BODY>
</HTML>
