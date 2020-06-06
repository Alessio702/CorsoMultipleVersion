<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pgsArchivioDiscenteElimina.jsp</title>
</head>
<body>
<jsp:useBean id="beanDiscente" scope="session"
	class="model.session.Discente">
	<jsp:setProperty name="beanDiscente" property="*" />
</jsp:useBean>

<P align="center"><FONT size="+2" color="green">Sei sicuro di voler eliminare il Discente?</FONT></P>


<FORM method="post" action="/Corso/CtrlArchivioDiscente">

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