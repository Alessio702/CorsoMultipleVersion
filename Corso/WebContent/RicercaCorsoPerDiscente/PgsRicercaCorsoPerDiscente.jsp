<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.session.Corso"
    import="model.session.Discente"
    import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pgsRicercaCorsoPerDiscente.jsp</title>
</head>
<body>
<jsp:useBean id="beanCorso" scope="session" class="model.session.Corso">
	<jsp:setProperty name="beanCorso" property="*" />
</jsp:useBean>

<jsp:useBean id="beanDiscente" scope="session" class="model.session.Discente">
	<jsp:setProperty name="beanDiscente" property="*" />
</jsp:useBean>

<FORM method="post" action="/Corso/CtrlRicercaCorsoPerDiscente" name="RicercaCorsoPerDiscente">
&nbsp;&nbsp; <input type="submit" name="cmdAzione" value="Torna alla Home">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<P align="center">
	<font size="+3">Ricerca Corsi per Discenti</font>
</P>
<TABLE align="center">
	<TR>
	<TD>
		<select name="cboDiscente2">
			
			
			<%ArrayList pgsElenco= (ArrayList) request.getAttribute("elencoDiscenti");
		   		if(pgsElenco.size() > 0) {
		   			int i = 0; 
		   			if (beanDiscente.getChiave() == 0) {
		   				
		   				%><option value="0" selected="selected"></option><%
		   						
		   						while (i < pgsElenco.size() ) { %>
		   			  			<option value="<%= ((Discente)pgsElenco.get(i)).getChiave() %>">
		   			  			<%= ((Discente)pgsElenco.get(i)).getCognome() + " " + 
		   			  				((Discente)pgsElenco.get(i)).getNome() + " " +
		   			  				((Discente)pgsElenco.get(i)).getMatricola() %>
		   			  			</option>
		   			  			<% i++;
		   			  			}
		   				
		   				} else {
		   					while (i < pgsElenco.size() ) {
		   						if (beanDiscente.getChiave() == ((Discente) pgsElenco.get(i)).getChiave() ) {
		   							%>
		   							
		   							<option value="<%= ((Discente)pgsElenco.get(i)).getChiave() %>" selected="selected">
		   			  			<%= ((Discente)pgsElenco.get(i)).getCognome() + " " + 
		   			  				((Discente)pgsElenco.get(i)).getNome() + " " +
		   			  				((Discente)pgsElenco.get(i)).getMatricola() %>
		   			  			</option>
		   			  			
		   						<%}
		   						else { %>
		   						
		   						<option value="<%= ((Discente)pgsElenco.get(i)).getChiave() %>">
		   			  			<%= ((Discente)pgsElenco.get(i)).getCognome() + " " + 
		   			  				((Discente)pgsElenco.get(i)).getNome() + " " +
		   			  				((Discente)pgsElenco.get(i)).getMatricola() %>
		   			  			</option>
		   						<%
		   						} i++;
		   					}
		   					
		   				}
		   		}%>
		  			
		</select>
	</TD>
	<TD>
		<input type="submit" name="cmdAzione" value="Cerca">
	</TD>
	</TR>
</TABLE>

<% if (beanDiscente.getChiave() != 0 ) { %>

	<TABLE align="center" border="1">
	<TR>
		<TD>
		Elenco dei corsi seguiti:
		</TD>
	</TR>
	
	<% ArrayList pgsElencoCorsi = (ArrayList) request.getAttribute("elencoCorsi");
		if (pgsElencoCorsi.size() > 0 ) {
			for (int i = 0; i < pgsElencoCorsi.size(); i++) {
				for (int j = 0; j < ((Corso) pgsElencoCorsi.get(i)).getPartecipanti().size(); j++) {
					if ( Integer.parseInt(request.getParameter("cboDiscente2")) == 
							((Corso) pgsElencoCorsi.get(i)).getPartecipanti().get(j).getChiave()) {
						%><TR><TD><%= ((Corso) pgsElencoCorsi.get(i)).getCorso() %></TD></TR>
					<%}
				}	
			}
		} %>
	</TABLE>
<% } %>
</FORM>
</body>
</html>