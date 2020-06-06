package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CorsoService;
import model.dao.DocenteService;
import model.session.Corso;
import model.session.Docente;

/**
 * Servlet implementation class CtrlRicercaPerDocente
 */
@WebServlet("/CtrlRicercaCorsoPerDocente")
public class CtrlRicercaCorsoPerDocente extends HttpServlet 
{
 private String paginaCorrente;
 private static final long serialVersionUID = 1L;
 private static DocenteService oDoc = new DocenteService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrlRicercaCorsoPerDocente() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  String azione = request.getParameter("cmdAzione");
  
  if (azione == null)
   visualizzaElenco(request, response);
  
  else if (azione.equals("Torna alla Home"))
   getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
  
  else if (azione.equals("Cerca Corsi"))
   elencoCorsiDocente(request, response);
  
 }

 private void elencoCorsiDocente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  List<Docente> elenco = new DocenteService().findAll();
  request.setAttribute("elencoDocenti", elenco);
  
  List<Corso> elencoCorsi = new CorsoService().findAll();
  request.setAttribute("elencoCorsi", elencoCorsi);
  
  Docente oDocente = oDoc.findById((Integer.parseInt(request.getParameter("cboDocente"))));
  request.getSession().setAttribute("beanDocente", oDocente);
  
  this.paginaCorrente = "/RicercaCorsoPerDocente/PgsRicercaCorsoPerDocente.jsp";
  pubblicaPagina(request, response);
 }

 private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub  
  List<Docente> elenco = new DocenteService().findAll();
  request.setAttribute("elencoDocenti", elenco);
  
  List<Corso> elencoCorsi = new CorsoService().findAll();
  request.setAttribute("elencoCorsi", elencoCorsi);
  
  request.setAttribute("beanDocente", new Docente());
  
  this.paginaCorrente = "/RicercaCorsoPerDocente/PgsRicercaCorsoPerDocente.jsp";
  pubblicaPagina(request, response);
 }

 private void pubblicaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  getServletContext().getRequestDispatcher(this.paginaCorrente).forward(request, response);
 }

}