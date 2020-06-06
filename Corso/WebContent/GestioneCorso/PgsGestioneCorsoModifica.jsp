<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 import = "model.session.Corso"
 import = "model.session.Docente"
 import = "model.session.Discente"
 import = "java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pgsGestioneCorsoModifica.jsp</title>
</head>
<body>
 <jsp:useBean id="beanCorso" scope="session" class="model.session.Corso">
  <jsp:setProperty name="beanCorso" property="*" />
 </jsp:useBean>
 
 <p align = "center">
  <font size = "+2" color = "green">Modifica Corso</font>
 </p>
 
 <form method = "post" action = "/Corso/CtrlGestioneCorso">
  <table align = "center">
   <tr>
    <td>Nome Corso:</td>
    <td>
     <input type = "text" name = "txtCorso" value = "<%=beanCorso.getCorso()%>" size = "20" maxlength = "50">
    </td>
   </tr>
   <tr>
    <td>&nbsp;</td>
   </tr>
   <tr>
    <td>Durata:</td>
    <td>
     <input type = "text" name = "txtDurata" value="<%= beanCorso.getDurata() %>" size = "20" maxlength = "50">
    </td>
   </tr>
   <tr>
    <td>&nbsp;</td>
   </tr>
   <tr>
    <td>Docenti:</td>
    <td>
     <select name = "cboDocente">
     <% ArrayList pgsElenco = (ArrayList) request.getAttribute("elencoDocenti");
      if (pgsElenco.size() > 0) 
      {
       int i = 0;
       while (i < pgsElenco.size()) 
       {
        if (beanCorso.getChiaveDocente() == ((Docente) pgsElenco.get(i)).getChiave()) 
        { %>
         <option value="<%=((Docente) pgsElenco.get(i)).getChiave()%>" selected="selected">
          <%=((Docente) pgsElenco.get(i)).getCognome() + " " + ((Docente) pgsElenco.get(i)).getNome()%>
         </option>
        <%
        } 
        else 
        {
        %>
         <option value="<%=((Docente) pgsElenco.get(i)).getChiave()%>">
          <%=((Docente) pgsElenco.get(i)).getCognome() + " "
           + ((Docente) pgsElenco.get(i)).getNome()%>
         </option>
        <% }
        
        i++;
       }
      } %>
     </select>
     <br/><br>
    </td>
   </tr>
  </table>
  <br><br>
  <% ArrayList pgsPartecipanti = (ArrayList) request.getAttribute("elencoPartecipanti");
   if (pgsPartecipanti.size() > 0) 
   { %>
    <table border = "1" align = "center">
     <tbody>
      <tr>
       <td></td>
       <td>Cognome</td>
       <td>Nome</td>
       <td>Matricola</td>
      </tr>
      <%  for (int i = 0; i < pgsPartecipanti.size(); i++) 
       { %>
        <tr>
         <td>
          <input type = "radio" name = "rdoIDPartecipanteElimina" value="<%=((Discente) pgsPartecipanti.get(i)).getChiave()%>">
         </td>
         <td><%= ((Discente) pgsPartecipanti.get(i)).getCognome() %></td>
         <td><%= ((Discente) pgsPartecipanti.get(i)).getNome() %></td>
         <td><%= ((Discente) pgsPartecipanti.get(i)).getMatricola() %></td>
        </tr>
      <%  } %>
     </tbody>
    </table> 
  <% }
   else
   { %> Non ci sono partecipanti! <% } %>
  <br><br>
  <div align = "center">
   <input type = "submit" name = "cmdAzione" value = "Inserisci Partecipante"><br>
   <br> <input type = "submit" name = "cmdAzione" value = "Elimina Partecipante"><br><br> 
   <input type = "submit" name = "cmdAzione" value = "Registra">
   &nbsp;&nbsp; 
   <input type = "submit" name = "cmdAzione" value = "Annulla">
   <br>
  </div>
 </form>
</body>
</html>