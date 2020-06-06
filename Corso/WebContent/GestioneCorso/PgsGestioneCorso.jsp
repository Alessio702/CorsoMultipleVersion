<!DOCTYPE html>
<%@page import="model.session.Corso"%>
<html>
<head>
<%@ page language="java" 
  contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"
     import="java.util.ArrayList"%>
 <meta charset="ISO-8859-1">
 <title>pgsGestioneCorso.jsp</title>
</head>
<body>
 <form method = "post" action = "/Corso/CtrlGestioneCorso" name = "GestioneCorso">
  <p>&nbsp;&nbsp; <input type="submit" name="cmdAzione" value="Torna alla Home">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <font size="+3">Gestione Corsi</font>
  </p>
  <% ArrayList pgsElenco = (ArrayList) request.getAttribute("elencoCorsi");
   int numeroRighe = pgsElenco.size();
   
   if(numeroRighe > 0)
   {
    int i = 0;
  %>
  <table border = "1">
   <tbody>
    <tr>
     <td> </td>
     <td>Corso</td>     
     <td>Cognome</td>
     <td>Nome</td> 
     <td>Durata</td>  
    </tr>
    <%while(i < numeroRighe)
     { %>
     <tr>
      <td>
      <input type="radio" name="rdoIDCorso" value="<%= ((Corso)pgsElenco.get(i)).getChiave() %>" checked = "checked"> 
      </td>
      <td> <%= ((Corso)pgsElenco.get(i)).getCorso() %></td>
      <td> <%= ((Corso)pgsElenco.get(i)).getDocente().getCognome() %></td>
      <td> <%= ((Corso)pgsElenco.get(i)).getDocente().getNome() %></td>
      <td> <%= ((Corso)pgsElenco.get(i)).getDurata() %></td>
     </tr>
     <% i++;
     } %>
   </tbody>
  </table>
  <p> </p>
  <% } else {%> Non ci sono Corsi <% } %> <br>
  
  <input type = "submit" name = "cmdAzione" value = "Nuovo">
  &nbsp;&nbsp;&nbsp;<input type = "submit" name = "cmdAzione" value = "Modifica">
  &nbsp;&nbsp;&nbsp;<input type = "submit" name = "cmdAzione" value = "Partecipanti">
  &nbsp;&nbsp;&nbsp;<input type = "submit" name = "cmdAzione" value = "Elimina">
  <br>
 </form>
</body>
</html>