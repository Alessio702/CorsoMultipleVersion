<%@page import="model.session.Discente"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" 
 contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestioneCorsoNuovo.jsp</title>
</head>

<body>

 <p align = "center">
  <font size = "+2" color = "green">Corso</font>
 </p>
 
 <html:form action="/Corso">
 
  <table align = "center">
   <tr>
    <td>Nome Corso:</td>  
    <td><html:text property="oCorso.corso"/></td>
   </tr>
   
   <tr>
    <td>&nbsp;</td>
   </tr>
   
   <tr>
    <td>Durata:</td>
    <td><html:text property="oCorso.durata"/></td>
   </tr>
   <tr>
    <td>&nbsp;</td>
   </tr>
<tr>
    <td>
     Docenti: 
    </td>

	<td>
      <html:select property="idCorsoDocente">
       <html:optionsCollection property="elencoDocenti" label="nome" value="id" />
 	</html:select>
	</td>
</tr>

  </table>
  
  
  
 
  <br><br>
  <div align = "center">
   <html:submit property="metodo" value="inserisci_partecipante"/> <br><br>
   <html:submit property="metodo" value="elimina_partecipante"/> <br>
   <br><br>
   <html:submit property="metodo" value = "registra"/>&nbsp;
   <html:submit property="metodo" value = "annulla"/>
  </div>
 </html:form>
</body>
</html>