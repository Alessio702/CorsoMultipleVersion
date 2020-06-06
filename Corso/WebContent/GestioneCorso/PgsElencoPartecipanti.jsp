<%@page import="model.entity.CorsoSet"%>
<%@page import="model.entity.DiscenteSet"%>
<%@ page language="java" 
 contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.ArrayList"
    import = "model.session.Discente"
    import = "model.session.Corso" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="ISO-8859-1">
 <title>pgsAggiungiPartecipante.jsp</title>
</head>

<body>
 <form method = "post" action = "/Corso/CtrlGestioneCorso" name = "listaPartecipanti">
  <jsp:useBean id = "beanDiscente" scope = "session" class = "model.session.Discente">
   <jsp:setProperty name = "beanDiscente" property="*" />
  </jsp:useBean>
  
  <p>&nbsp;&nbsp; <input type="submit" name="cmdAzione" value="Torna alla Home">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <font size="+3" style = "text-align: center">Partecipanti</font>
  </p>
  
  <table bgcolor ="lightgreen" align = "center" border = "1">
   <% ArrayList pgsPartecipanti = (ArrayList) request.getAttribute("elencoPartecipanti");
   if (pgsPartecipanti.size() > 0) 
   { %>
    <table border = "1" align = "center">
     <tbody>
      <tr>
       <td>Cognome</td>
       <td>Nome</td>
       <td>Matricola</td>
      </tr>
      <%  for (int i = 0; i < pgsPartecipanti.size(); i++) 
       { %>
        <tr>
         <td><%= ((Discente) pgsPartecipanti.get(i)).getCognome() %></td>
         <td><%= ((Discente) pgsPartecipanti.get(i)).getNome() %></td>
         <td><%= ((Discente) pgsPartecipanti.get(i)).getMatricola() %></td>
        </tr>
      <%  } %>
     </tbody>
    </table> 
  <% }
   else
   { %> <p align = "center"> Non ci sono partecipanti! </p><% } %>
  </table>
  <p></p>
 </form>
</body>
</html>