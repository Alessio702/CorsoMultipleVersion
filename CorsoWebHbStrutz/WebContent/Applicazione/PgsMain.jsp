<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>pgsMain.jsp</TITLE>
</HEAD>
<BODY>

<P align="center"> <FONT size="+2" color="ff0000#">Menù</FONT><BR>

<html:form action="/Main">
<DIV align="center">
<TABLE>
 <TBODY>
  <TR>
   <TD><html:radio property="rdoScelta" value="0"/></TD>
   <TD>Archivio&nbsp;Docente</TD> 
  </TR> 
   
  <TR>
   <TD><html:radio property="rdoScelta" value="1"/></TD>
   <TD>Archivio&nbsp;Discente</TD> 
  </TR> 
  <TR>
   <TD><html:radio property="rdoScelta" value="2"/></TD>
   <TD>Gestione&nbsp;Corso</TD> 
  </TR> 
  <TR>
    <TD><html:radio property="rdoScelta" value="3"/></TD>
   <TD>Ricerca&nbsp;Corso&nbsp;Per&nbsp;Docente</TD> 
  </TR>   
  <TR>
   <TD><html:radio property="rdoScelta" value="4"/></TD>
   <TD>Ricerca&nbsp;Corso&nbsp;Per&nbsp;Discente</TD> 
  </TR>   

 </TBODY>   

    
</TABLE>
<BR>
<html:submit property="metodo" value="invio"/>
</DIV>
</html:form>
<DIV ALIGN="center"><br>
</div>

</BODY>
</HTML>