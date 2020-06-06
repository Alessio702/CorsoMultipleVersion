package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AulaService;
import model.dao.CorsoService;
import model.dao.DiscenteService;
import model.dao.DocenteService;
import model.session.Corso;
import model.session.Discente;
import model.session.Docente;
import util.UDate;

/**
 * Servlet implementation class CtrlGestioneCorso
 */
@WebServlet("/CtrlGestioneCorso")
public class CtrlGestioneCorso extends HttpServlet {
	private String PaginaCorrente;
	private static final long serialVersionUID = 1L;
	private static DocenteService oDoc = new DocenteService();
	private static AulaService oAul = new AulaService();
	private static CorsoService oCors = new CorsoService();
	private static DiscenteService oDisc = new DiscenteService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CtrlGestioneCorso() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		else if (azione.equals("Registra")) {
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

		else if (azione.equals("Conferma")) {
			cancellaCorso(request, response);
			visualizzaElenco(request, response);
		}

		else if (azione.equals("Partecipanti"))
			elencoPartecipanti(request, response);
	}

	private void elencoPartecipanti(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("beanCorso",
				oCors.findById((Integer.parseInt(request.getParameter("rdoIDCorso")))));

		List<Discente> listaPartecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti();
		request.setAttribute("elencoPartecipanti", listaPartecipanti);

		getServletContext().getRequestDispatcher("/GestioneCorso/PgsElencoPartecipanti.jsp").forward(request, response);
	}

	private void cancellaCorso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		oCors.delete(((Corso) request.getSession().getAttribute("beanCorso")).getId());
	}

	private void eliminaCorso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("beanCorso",
				oCors.findById((Integer.parseInt(request.getParameter("rdoIDCorso")))));

		getServletContext().getRequestDispatcher("/GestioneCorso/PgsGestioneCorsoElimina.jsp").forward(request,
				response);
	}

	private void eliminaPartecipante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ((Corso)
		// request.getSession().getAttribute("beanCorso")).rimuoviPartecipante(Integer.parseInt(request.getParameter("rdoIDPartecipanteElimina")));
		oCors.removePart(((Corso) request.getSession().getAttribute("beanCorso")),
				oDisc.findById(Integer.parseInt(request.getParameter("rdoIDPartecipanteElimina"))));
		//		oCors.update(((Corso) request.getSession().getAttribute("beanCorso")));

		List<Discente> listaPartecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti();
		request.setAttribute("elencoPartecipanti", listaPartecipanti);

		List<Docente> elenco = new DocenteService().findAll();
		request.setAttribute("elencoDocenti", elenco);

		pubblicaPagina(request, response);
	}

	//	private void eliminaPartecipante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	//	 {
	//	  // TODO Auto-generated method stub  
	//	//  Cor.removePart(((Corso) request.getSession().getAttribute("beanCorso")), (((Discente) request.getSession().getAttribute("beanDiscente"))));
	//	  Cor.removePart(((Corso) request.getSession().getAttribute("beanCorso")), Dis.findById(Integer.parseInt(request.getParameter("rdoIDPartecipanteElimina"))));
	//	  
	//	  List<Discente> listaPartecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti();
	//	  request.setAttribute("elencoPartecipanti", listaPartecipanti);
	//	  
	//	  List<Docente> elenco = Doc.findAll();
	//	  request.setAttribute("elencoDocenti", elenco);
	//	  
	//	  pubblicaPagina(request, response);
	//	 }

	private void modificaCorso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("beanCorso",
				oCors.findById((Integer.parseInt(request.getParameter("rdoIDCorso")))));

		List<Discente> partecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti();
		request.setAttribute("elencoPartecipanti", partecipanti);

		List<Docente> elenco = new DocenteService().findAll();
		request.setAttribute("elencoDocenti", elenco);

		this.PaginaCorrente = "/GestioneCorso/PgsGestioneCorsoModifica.jsp";
		pubblicaPagina(request, response);
	}

	private void registraPartecipante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti()
		.add(oDisc.findById(Integer.parseInt(request.getParameter("rdoIDPartecipante"))));
		// oCors.persist(((Corso) request.getSession().getAttribute("beanCorso")));

		// ((Corso)
		// request.getSession().getAttribute("beanCorso")).aggiungiPartecipante(Integer.parseInt(request.getParameter("rdoIDPartecipante")));
		List<Discente> listaPartecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti(); // oCors.findAllPartecipanti();
		request.setAttribute("elencoPartecipanti", listaPartecipanti);

		// Dispatchare la pagina nuovo Corso
		List<Docente> elenco = new DocenteService().findAll();
		request.setAttribute("elencoDocenti", elenco);

		getServletContext().getRequestDispatcher("/GestioneCorso/PgsGestioneCorsoNuovo.jsp").forward(request, response);
	}

	private void annullaPartecipante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Dispatchare la pagina nuovo Corso
		List<Docente> elenco = new DocenteService().findAll();
		request.setAttribute("elencoDocenti", elenco);

		List<Discente> listapartecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti();
		request.setAttribute("elencoPartecipanti", listapartecipanti);

		getServletContext().getRequestDispatcher("/GestioneCorso/PgsGestioneCorsoNuovo.jsp").forward(request, response);
	}

	private void inserisciPartecipante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Pubblicare l'elenco dei Discenti Non partecipanti
		List<Discente> elencoNonPartecipanti = oCors
				.discentiNonPartecipanti(((Corso) request.getSession().getAttribute("beanCorso")));// ((Corso)
		// request.getSession().getAttribute("beanCorso")).
		request.setAttribute("nonPartecipanti", elencoNonPartecipanti);

		((Corso) request.getSession().getAttribute("beanCorso")).setCorso(request.getParameter("txtCorso"));
		((Corso) request.getSession().getAttribute("beanCorso")).setDurata(request.getParameter("txtDurata"));
		((Corso) request.getSession().getAttribute("beanCorso"))
		.setoDocente(oDoc.findById(Integer.parseInt(request.getParameter("cboDocente"))));
		((Corso) request.getSession().getAttribute("beanCorso")).setoAula(oAul.findById(2));
		try {
			((Corso) request.getSession().getAttribute("beanCorso")).setDatainizio(UDate.ctrlData("05/05/2005"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/GestioneCorso/PgsGestionePartecipanti.jsp").forward(request,
				response);
	}

	private void salvaCorso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		((Corso) request.getSession().getAttribute("beanCorso"))
			.setCorso(request.getParameter("txtCorso"));
		((Corso) request.getSession().getAttribute("beanCorso"))
			.setDurata(request.getParameter("txtDurata"));
		((Corso) request.getSession().getAttribute("beanCorso"))
			.setoDocente(oDoc.findById(Integer.parseInt(request.getParameter("cboDocente"))));
		((Corso) request.getSession().getAttribute("beanCorso"))
			.setoAula(oAul.findById(42));

		try {
			((Corso) request.getSession().getAttribute("beanCorso"))
				.setDatainizio(UDate.ctrlData("05/05/2005"));
		} catch (ParseException e) {
			e.printStackTrace();

			if (((Corso) request.getSession().getAttribute("beanCorso")).getId() == 0)
				oCors.persist(((Corso) request.getSession().getAttribute("beanCorso")));
			else
				oCors.update(((Corso) request.getSession().getAttribute("beanCorso")));
		}
	}

	private void nuovoCorso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Corso oCorso = new Corso();
		request.getSession().setAttribute("beanCorso", oCorso);

		List<Discente> partecipanti = ((Corso) request.getSession().getAttribute("beanCorso")).getPartecipanti();
		request.setAttribute("elencoPartecipanti", partecipanti);

		List<Docente> elenco = new DocenteService().findAll();
		request.setAttribute("elencoDocenti", elenco);

		this.PaginaCorrente = "/GestioneCorso/PgsGestioneCorsoNuovo.jsp"; // Attenzione
		pubblicaPagina(request, response);

	}

	private void pubblicaPagina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher(this.PaginaCorrente).forward(request, response);
	}

	private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Corso> elenco = new CorsoService().findAll();
		request.setAttribute("elencoCorsi", elenco);
		getServletContext().getRequestDispatcher("/GestioneCorso/PgsGestioneCorso.jsp").forward(request, response);

	}

}