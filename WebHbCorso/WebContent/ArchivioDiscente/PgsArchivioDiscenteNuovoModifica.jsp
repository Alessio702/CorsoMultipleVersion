<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>pgsArchivioDiscenteNuovoModifica.jsp</TITLE>
</HEAD>
<BODY>

	<jsp:useBean id="beanDiscente" scope="session"
		class="model.session.Discente">
		<jsp:setProperty name="beanDiscente" property="*" />
	</jsp:useBean>

	<P align="center">
		<FONT size="+2" color="green">Discente</FONT>
	</P>


	<FORM method="post" action="/WebHbCorso/CtrlArchivioDiscente">


		<TABLE align="center">
			<tr>

				<td>Cognome:</td>

				<td><INPUT type="text" name="txtCognome"
					value="<%=beanDiscente.getCognome()%>" size="20" maxlength="50">
				</td>

			</tr>

			<tr>

				<td>&nbsp;</td>

			</tr>

			<tr>

				<td>Nome:</td>

				<td><INPUT type="text" name="txtNome"
					value="<%=beanDiscente.getNome()%>" size="20" maxlength="50">

				</td>

			</tr>

			<tr>

				<td>Matricola:</td>

				<td><INPUT type="text" name="txtMatricola"
					value="<%=beanDiscente.getMatricola()%>" size="20" maxlength="50">

				</td>

			</tr>
		</TABLE>
		<BR /> <BR />
		<DIV align="center">

			<INPUT type="submit" name="cmdAzione" value="Registra">
			&nbsp;&nbsp; <INPUT type="submit" name="cmdAzione" value="Annulla">
			<BR>

		</DIV>
	</FORM>



</BODY>
</HTML>
