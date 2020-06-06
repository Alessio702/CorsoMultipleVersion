<%@ page language="java" 
  contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pgsGestioneCorsoElimina.jsp</title>
</head>
<body>
 <jsp:useBean id="beanCorso" scope="session" class = "model.session.Corso">
  <jsp:setProperty name="beanCorso" property="*" />
 </jsp:useBean>
 
 <P align="center"><FONT size="+2" color="green">Corso</FONT></P>
 
 <form method = "post" action = "/Corso/CtrlGestioneCorso">
  <table align = "center">
   <tr>
    <td align = "center">Vuoi eliminare il Corso?</td>
   </tr>
   <tr>
    <td>
     <input type = "submit" name ="cmdAzione" value = "Conferma">
    </td>
    <td>
     <input type = "submit" name ="cmdAzione" value = "Annulla">
    </td>
   </tr>
  </table>
 </form>
</body>
</html>