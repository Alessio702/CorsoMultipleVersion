<%@page import="model.session.Discente"%>
<%@ page language="java" 
 contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 import="model.session.Corso"
 import="model.session.Docente"
 import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pgsGestioneCorsoNuovo.jsp</title>
</head>

<body>
 <jsp:useBean id="beanCorso" scope="session" class="model.session.Corso">
  <jsp:setProperty name="beanCorso" property="*" />
 </jsp:useBean>
 
 <p align = "center">
  <font size = "+2" color = "green">Corso</font>
 </p>
 
 <form method = "post" action="/WebHbCorso/CtrlGestioneCorso">
  <table align = "center">
   <tr>
    <td>Nome Corso:</td>  
    <td><input type = "text" name = "txtCorso" value = "<%= beanCorso.getCorso() %>" size = "20" maxlength="50"></td>
   </tr>
   <tr>
    <td>&nbsp;</td>
   </tr>
   <tr>
    <td>Durata:</td>
    <td><input type = "text" name = "txtDurata" value = "<%= beanCorso.getDurata() %>" size="20" maxlength="50"></td>
   </tr>
   <tr>
    <td>&nbsp;</td>
   </tr>
   <tr>
    <td>
     Docenti: 
    </td>
    <td>
     <select name="cboDocente">
      <option selected="selected"> </option>
      <% List pgsElenco = (List) request.getAttribute("elencoDocenti");
      
      if(pgsElenco.size() > 0) 
      {      
       int i = 0;
       if (beanCorso.getoDocente() == null) 
       {
        %> <option value ="0" selected = "selected"></option>
       
        <% while(i < pgsElenco.size()) 
        { %>
        <option value="<%= ((Docente)pgsElenco.get(i)).getId() %>"><%= ((Docente)pgsElenco.get(i)).getCognome() 
            + " " + ((Docente)pgsElenco.get(i)).getNome() %></option>
        <% i++; 
        }
        }
        else
        {
         while(i < pgsElenco.size())
         {
          if(beanCorso.getoDocente().getId() == ((Docente) pgsElenco.get(i)).getId()) 
          { %>
           <option value="<%= ((Docente)pgsElenco.get(i)).getId() %>" selected = "selected">
           <%= ((Docente)pgsElenco.get(i)).getCognome() + " " + ((Docente)pgsElenco.get(i)).getNome() %></option>
         <%  } 
          else 
          { %>
           <option value="<%= ((Docente)pgsElenco.get(i)).getId() %>">
           <%= ((Docente)pgsElenco.get(i)).getCognome() + " " + ((Docente)pgsElenco.get(i)).getNome() %></option>
         <% }
          
          i++;
         }
        }
      }%>
     </select>
      <br>
     </td>
   </tr>
  </table>
  <P></P>
  <%  List pgsElencoPartecipanti = (List) request.getAttribute("elencoPartecipanti");
   if (pgsElencoPartecipanti.size() > 0)
   {    
    %>
    <table border = "1" align = "center">
     <tr>
      <td> </td>
      <td>Cognome</td>
      <td>Nome</td>
      <td>Matricola</td>
     </tr>
     <% 
      for(int i = 0; i < pgsElencoPartecipanti.size(); i++)
      {
       %>
      <tr>
       <td><input type = "radio" name = "rdoIDPartecipanteElimina" value ="<%= ((Discente) pgsElencoPartecipanti.get(i)).getId() %>" checked = "checked"></td>
       <td> <%= ((Discente)pgsElencoPartecipanti.get(i)).getCognome() %></td>
       <td> <%= ((Discente)pgsElencoPartecipanti.get(i)).getNome() %></td>
       <td> <%= ((Discente)pgsElencoPartecipanti.get(i)).getMatricola() %></td>
      </tr>
      <% } %> 
    </table>
   <% } else { %> <p align = "center"> Non ci sono Partecipanti! </p><% } %>
  <br><br>
  <div align = "center">
   <input type = "submit" name = "cmdAzione" value = "Inserisci Partecipante"> <br><br>
   <input type = "submit" name = "cmdAzione" value = "Elimina Partecipante"> <br>
   <br><br>
   <input type = "submit" name = "cmdAzione" value = "Registra">&nbsp;
   <input type = "submit" name = "cmdAzione" value = "Annulla">
  </div>
 </form>
</body>
</html>