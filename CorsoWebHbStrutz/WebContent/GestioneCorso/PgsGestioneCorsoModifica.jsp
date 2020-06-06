<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 import = "model.session.Corso"
 import = "model.session.Docente"
 import = "model.session.Discente"
 import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestioneCorsoModifica.jsp</title>
</head>
<body>
 <html:form action = "/Corso">
  <div align = "center">
   <font size = "+3">Corso</font>
   <br><br>
   <table>
    <tr>
     <td>Nome Corso:</td>  
     <td><html:text property = "oCorso.corso"/></td>
    </tr>
    <tr>
     <td>Docente: </td>
     <td>
      <html:select property = "idCorsoDocente">
       <html:optionsCollection property = "elencoDocenti" label = "nome" value = "id"/>
      </html:select>
     </td>
    </tr>
    <tr>
     <td>Durata: </td>
     <td><html:text property = "oCorso.durata"/></td>
    </tr>
    
   </table>
   <br><br>
   <!-- elenco partecipanti -->
   <h2>Elenco Partecipanti</h2>
		<br><br>
		<logic:empty property="oCorso.partecipanti" name="CorsoForm">
			<div align="center">
				Non ci sono Partecipanti!
			</div>
				<html:submit property = "metodo" value = "elimina_partecipante"/>&nbsp;&nbsp;
			<br><br>
		</logic:empty>
		<logic:notEmpty property="oCorso.partecipanti" name="CorsoForm">
			<table align="center" border="1">
				<tr>
					<td> </td>
					<td>Nome</td>
					<td>Cognome</td>
					<td>Matricola</td>
				</tr>
			
	
				<logic:iterate id="currentCorso" property="oCorso.partecipanti" name="CorsoForm" type="model.session.Discente">
					<tr>
					<td> <html:radio property="chiave" value="id" idName="currentCorso"></html:radio> </td>
					<td><bean:write name="currentCorso" property="nome"/> </td> 
					<td><bean:write name="currentCorso" property="cognome"/> </td>
					<td><bean:write name="currentCorso" property="matricola"/> </td>	
				</tr>
				</logic:iterate>
				
				
			</table>
			</logic:notEmpty>
	<html:submit property = "metodo" value = "inserisci_partecipante"/> &nbsp;&nbsp;
   <html:submit property = "metodo" value = "registra"/>&nbsp;&nbsp;
   <html:submit property = "metodo" value = "annulla"/>
  </div>
 </html:form>
</body>
</html>