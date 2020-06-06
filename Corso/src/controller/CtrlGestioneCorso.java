package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.session.Corso;
import model.session.Discente;
import model.session.Docente;
import util.UDate;

/**
 * Servlet implementation class CtrlGestioneCorso
 */
@WebServlet("/CtrlGestioneCorso")
public class CtrlGestioneCorso extends HttpServlet 
{
 private String PaginaCorrente;
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrlGestioneCorso() {
        super();
        // TODO Auto-generated constructor stub
    }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  // doGet(request, response);
  
  String azione = request.getParameter("cmdAzione");
  
  if (azione == null)
   visualizzaElenco(request, response);
  
  else if (azione.equals("Torna alla Home"))
   getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
  
  else if (azione.equals("Nuovo"))
   nuovoCorso(request, response);
   
  else if (azione.equals("Annulla"))
   visualizzaElenco(request, response);
  
  else if (azione.equals("Modifica"))
   modificaCorso(request, response);
  
  else if (azione.equals("Registra"))
  { 
    salvaCorso(request, response);
    visualizzaElenco(request, response);
  }
  
  else if (azione.equals("Registra Partecipante"))
   registraPartecipante(request, response);
  
  else if (azione.equals("Annulla Partecipante"))
   annullaPartecipante(request, response);
  
  else if (azione.equals("Inserisci Partecipante"))
   inserisciPartecipante(request, response);
  
  else if (azione.equals("Elimina Partecipante"))
   eliminaPartecipante(request, response);

  else if (azione.equals("Elimina"))
   eliminaCorso(request, response);
  
  else if (azione.equals("Conferma"))
  {
   cancellaCorso(request, response);
   visualizzaElenco(request, response);
  }
  
  else if (azione.equals("Partecipanti"))
   elencoPartecipanti(request, response);
 }
 
 private void elencoPartecipanti(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  request.getSession().setAttribute("beanCorso", new Corso(Integer.parseInt(request.getParameter("rdoIDCorso"))));
  
  ArrayList<Discente> listaPartecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti();
  request.setAttribute("elencoPartecipanti", listaPartecipanti);
  
  getServletContext().getRequestDispatcher("/GestioneCorso/PgsElencoPartecipanti.jsp").forward(request, response);
 }

 private void cancellaCorso(HttpServletRequest request, HttpServletResponse response) 
 {
  // TODO Auto-generated method stub
  ((Corso) request.getSession().getAttribute("beanCorso")).elimina();
 }

 private void eliminaCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  request.getSession().setAttribute("beanCorso", new Corso(Integer.parseInt(request.getParameter("rdoIDCorso"))));
  
  getServletContext().getRequestDispatcher("/GestioneCorso/PgsGestioneCorsoElimina.jsp").forward(request, response);
 }

 private void eliminaPartecipante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub  
  ((Corso) request.getSession().getAttribute("beanCorso")).rimuoviPartecipante(Integer.parseInt(request.getParameter("rdoIDPartecipanteElimina")));
  
  ArrayList<Discente> listaPartecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti();
  request.setAttribute("elencoPartecipanti", listaPartecipanti);
  
  ArrayList<Docente> elenco = Docente.elenco();
  request.setAttribute("elencoDocenti", elenco);
  
  pubblicaPagina(request, response);
 }

 private void modificaCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  request.getSession().setAttribute("beanCorso", new Corso(Integer.parseInt(request.getParameter("rdoIDCorso"))));
  
  ArrayList<Discente> partecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti();
  request.setAttribute("elencoPartecipanti", partecipanti);
  
  ArrayList<Docente> elenco = Docente.elenco();
  request.setAttribute("elencoDocenti", elenco);
  
  this.PaginaCorrente = "/GestioneCorso/PgsGestioneCorsoModifica.jsp";
  pubblicaPagina(request, response);
 }
 
 private void registraPartecipante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  // Prendere il discente selezionato (radiobutton) e chiamare aggiungi partecipanti
  ((Corso) request.getSession().getAttribute("beanCorso")).aggiungiPartecipante(Integer.parseInt(request.getParameter("rdoIDPartecipante")));
  ArrayList<Discente> listaPartecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti();
  request.setAttribute("elencoPartecipanti", listaPartecipanti);
  
  // Dispatchare la pagina nuovo Corso
  ArrayList<Docente> elenco = Docente.elenco();
  request.setAttribute("elencoDocenti", elenco);
  
  getServletContext().getRequestDispatcher("/GestioneCorso/PgsGestioneCorsoNuovo.jsp").forward(request, response);
 }

 private void annullaPartecipante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  // Dispatchare la pagina nuovo Corso
  ArrayList<Docente> elenco = Docente.elenco();
  request.setAttribute("elencoDocenti", elenco);
  
  ArrayList<Discente> listapartecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti();
  request.setAttribute("elencoPartecipanti", listapartecipanti);
  
  getServletContext().getRequestDispatcher("/GestioneCorso/PgsGestioneCorsoNuovo.jsp").forward(request, response);
 }

 private void inserisciPartecipante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  // Pubblicare l'elenco dei Discenti Non partecipanti
  ArrayList<Discente> elencoNonPartecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).discentiNonPartecipanti();
  request.setAttribute("nonPartecipanti", elencoNonPartecipanti);
  
  ((Corso) request.getSession().getAttribute("beanCorso")).setCorso(request.getParameter("txtCorso"));
  ((Corso) request.getSession().getAttribute("beanCorso")).setDurata(request.getParameter("txtDurata"));
  ((Corso) request.getSession().getAttribute("beanCorso")).setDocente(Integer.parseInt(request.getParameter("cboDocente")));
  
  // Dispatchare la pagina di non partecipante
  getServletContext().getRequestDispatcher("/GestioneCorso/PgsGestionePartecipanti.jsp").forward(request, response);
 }

 private void salvaCorso(HttpServletRequest request, HttpServletResponse response) 
 {
  // TODO Auto-generated method stub
  ((Corso) request.getSession().getAttribute("beanCorso")).setCorso(request.getParameter("txtCorso"));
  ((Corso) request.getSession().getAttribute("beanCorso")).setDurata(request.getParameter("txtDurata"));
  ((Corso) request.getSession().getAttribute("beanCorso")).setDocente(Integer.parseInt(request.getParameter("cboDocente")));
  ((Corso) request.getSession().getAttribute("beanCorso")).setAula(42);
  try 
  {
   ((Corso) request.getSession().getAttribute("beanCorso")).setDatainizio(UDate.ctrlData("05/05/2005"));
  } 
  catch (ParseException e) 
  {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
  ((Corso) request.getSession().getAttribute("beanCorso")).salva();
 }

 private void nuovoCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  Corso oCorso = new Corso();
  request.getSession().setAttribute("beanCorso", oCorso);
  
  /*ArrayList<Discente> studentiNonPartecipanti = oCorso.discentiNonPartecipanti();
  request.setAttribute("nonPartecipanti", studentiNonPartecipanti);*/
  
  ArrayList<Discente> partecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti();
  request.setAttribute("elencoPartecipanti", partecipanti);
  
  ArrayList<Docente> elenco = Docente.elenco();
  request.setAttribute("elencoDocenti", elenco);
  
  this.PaginaCorrente = "/GestioneCorso/PgsGestioneCorsoNuovo.jsp";       // Attenzione
  pubblicaPagina(request, response);
  
 }

 private void pubblicaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
  // TODO Auto-generated method stub
  getServletContext().getRequestDispatcher(this.PaginaCorrente).forward(request, response);
 }

 private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {

  ArrayList<Corso> elenco = Corso.elenco();
  request.setAttribute("elencoCorsi", elenco);
  
  getServletContext().getRequestDispatcher("/GestioneCorso/PgsGestioneCorso.jsp").forward(request, response);
 }
 
}