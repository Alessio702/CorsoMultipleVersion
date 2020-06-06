<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pgsArchivioDocenteElimina.jsp</title>
</head>
<body>
<jsp:useBean id="beanDocente" scope="session"
	class="model.session.Docente">
	<jsp:setProperty name="beanDocente" property="*" />
</jsp:useBean>

<P align="center"><FONT size="+2" color="green">Sei sicuro di voler eliminare il Docente?</FONT></P>


<FORM method="post" action="/Corso/CtrlArchivioDocente">

<TABLE  align="center" >
<tr>

	
	
	<td>
		<INPUT type="submit" name="cmdAzione" value="Conferma" size="20" maxlength="50">
	</td>
	
</tr>	

<tr>

	<td>
	&nbsp;
	</td>
	
</tr>

<tr>


	
	<td>
		 
	<INPUT type="submit" name="cmdAzione" value="Annulla" size="20" maxlength="50">
	
	</td>
	
</tr>
</TABLE >
</FORM>
</body>
</html>