<%@page import="java.util.List"%>
<%@ page language="java" 
 contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "model.session.Docente"
    import = "model.session.Corso" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco Corsi Per Docente</title>
</head>
<body>
 <jsp:useBean id="beanCorso" scope="session" class="model.session.Corso">
  <jsp:setProperty name="beanCorso" property="*"/>
 </jsp:useBean>
 
 <jsp:useBean id="beanDocente" scope="session" class="model.session.Docente">
  <jsp:setProperty name="beanDocente" property="*"/>
 </jsp:useBean>
 
 <form method = "post" action = "/WebHbCorso/CtrlRicercaCorsoPerDocente" name = "RicercaCorso">
  <p>&nbsp;&nbsp; <input type="submit" name="cmdAzione" value="Torna alla Home">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </p>
  
  <p align = "center">
   <font size="+3">Ricerca Corso Per Docente</font>
  </p>
  
  <% List pgsElenco = (List) request.getAttribute("elencoDocenti");  
     if(pgsElenco.size() > 0)
     { 
    %>
    <p align = "center"><select name = "cboDocente">
     <option selected = "selected"></option>
      <%  int i = 0;
      while (i < pgsElenco.size()) 
      { %>
       <option value = "<%=((Docente) pgsElenco.get(i)).getId() %>">
        <%=((Docente) pgsElenco.get(i)).getCognome() + " " + ((Docente) pgsElenco.get(i)).getNome()%>
       </option>
       <% i++;
      } %>
    </select>
  <% } 
     else
     { %> <p align = "center"> Non ci sono Docenti! </p> <% } %>
  <input type = "submit" name = "cmdAzione" value = "Cerca Corsi"></p>
  <br><br>
  
  <%  if (beanDocente.getId() != 0) 
   { %>
  <table width = "150px" border = "1" align = "center">
   <tr>
    <td>Elenco dei corsi</td>
   </tr>
   <%  List pgsElencoCorsi = (List) request.getAttribute("elencoCorsi");
    if (pgsElencoCorsi.size() > 0) 
    {
     for(int i = 0; i< pgsElencoCorsi.size(); i++)
     {
      if (beanDocente.getId() == ((Corso) pgsElencoCorsi.get(i)).getoDocente().getId())
      { %>
       <tr>
        <td><%= ((Corso) pgsElencoCorsi.get(i)).getCorso() %></td>
       </tr>
     <% }
     }
    } 
    else
    { %>
     <tr>
      <td>Il docente non sostiene alcun corso!</td>
     </tr>
   <%  } %>
  </table>
  <%  }
   else
   { %>
    <p align = "center">Non ci sono Docenti!</p>
  <%  } %>
  <br><br>
 </form>
</body>
</html>