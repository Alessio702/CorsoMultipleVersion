
<%@ page language="java" 
 contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.List"
    import = "model.session.Discente"
    import = "model.session.Corso" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="ISO-8859-1">
 <title>pgsAggiungiPartecipante.jsp</title>
</head>

<body>
 <form method = "post" action = "/WebHbCorso/CtrlGestioneCorso" name = "listaPartecipanti">
  <jsp:useBean id = "beanCorso" scope = "session" class = "model.session.Corso">
   <jsp:setProperty name = "beanCorso" property="*" />
  </jsp:useBean>
  
  <p>&nbsp;&nbsp; <input type="submit" name="cmdAzione" value="Torna alla Home">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <font size="+3" align = "center">Partecipanti</font>
  </p>
  
  <table bgcolor ="lightgreen" align = "center" border = "1">
   <tr>
    <td></td>
    <td>Cognome</td>
    <td>Nome</td>
    <td>Matricola</td>
   </tr>
   <% List pgsElenco = (List) request.getAttribute("nonPartecipanti");
   
   if (pgsElenco.size() > 0)
   {
    for(int i = 0; i < pgsElenco.size(); i++)
    {
     %>
    <tr>
     <td><input type = "radio" name = "rdoIDPartecipante" value ="<%= ((Discente) pgsElenco.get(i)).getId() %>" checked = "checked"></td>
     <td> <%= ((Discente)pgsElenco.get(i)).getCognome() %></td>
     <td> <%= ((Discente)pgsElenco.get(i)).getNome() %></td>
     <td> <%= ((Discente)pgsElenco.get(i)).getMatricola() %></td>
    </tr>
    <% } %>
  </table>
  <% } else {%> Non ci sono Discenti <% } %> 
  <P></P>
  
  <br><br>
  <div align = "center">
   <input type = "submit" name = "cmdAzione" value = "Registra Partecipante"> <br><br>
   <input type = "submit" name = "cmdAzione" value = "Annulla Partecipante"> <br>
  </div>
 </form>
</body>
</html>