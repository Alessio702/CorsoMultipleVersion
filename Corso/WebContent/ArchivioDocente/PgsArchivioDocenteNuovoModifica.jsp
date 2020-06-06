<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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

<jsp:useBean id="beanDocente" scope="session"
	class="model.session.Docente">
	<jsp:setProperty name="beanDocente" property="*" />
</jsp:useBean>

<P align="center"><FONT size="+2" color="green">Docente</FONT></P>


<FORM method="post" action="/Corso/CtrlArchivioDocente">


<TABLE  align="center" >
<tr>

	<td>
	 	Cognome:	 
	</td>
	
	<td>
		<INPUT type="text" name="txtCognome" value="<%= beanDocente.getCognome()%>" size="20" maxlength="50">
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
		 
	<INPUT type="text" name="txtNome" value="<%= beanDocente.getNome()%>" size="20" maxlength="50">
	
	</td>
	
</tr>
</TABLE >
<BR/> 
<BR/>
<DIV align="center">

<INPUT type="submit" name="cmdAzione" value="Registra"> &nbsp;&nbsp;
<INPUT type="submit" name="cmdAzione" value="Annulla"> <BR>

</DIV></FORM>



</BODY>
</HTML>
