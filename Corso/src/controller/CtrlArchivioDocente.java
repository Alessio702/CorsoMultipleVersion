package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.session.Discente;
import model.session.Docente;

/**
 * Servlet implementation class CtrlArchivioDocente
 */
@WebServlet("/CtrlArchivioDocente")
public class CtrlArchivioDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CtrlArchivioDocente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String azione = request.getParameter("cmdAzione");
		if (azione == null) {
			visualizzaElenco(request, response);
		} else if (azione.equals("Torna alla Home")) {
			getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
		} else if (azione.equals("Nuovo")) {
			nuovoDocente(request, response);
		} else if (azione.equals("Annulla")) {
			visualizzaElenco(request, response);
		} else if (azione.equals("Registra")) {
			salvaDocente(request, response);
			visualizzaElenco(request, response);
		} else if (azione.equals("Modifica")) {
			modificaDocente(request, response);
		} else if (azione.equals("Elimina")) {
			eliminaDocente(request, response);
		} else if (azione.equals("Conferma")) {
			cancellaDocente(request, response);
			visualizzaElenco(request, response);
		}

	}

	private void cancellaDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		((Docente) request.getSession().getAttribute("beanDocente")).elimina();

	}

	private void eliminaDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().setAttribute("beanDocente", new Docente(Integer.parseInt(request.getParameter("rdoIDDocente"))));
		getServletContext().getRequestDispatcher("/ArchivioDocente/PgsArchivioDocenteElimina.jsp").forward(request, response);
	}

	private void modificaDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("beanDocente", new Docente(Integer.parseInt(request.getParameter("rdoIDDocente"))));
		getServletContext().getRequestDispatcher("/ArchivioDocente/PgsArchivioDocenteNuovoModifica.jsp")
				.forward(request, response);

	}

	private void salvaDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		((Docente) request.getSession().getAttribute("beanDocente")).setCognome(request.getParameter("txtCognome"));
		((Docente) request.getSession().getAttribute("beanDocente")).setNome(request.getParameter("txtNome"));
		((Docente) request.getSession().getAttribute("beanDocente")).salva();

	}

	private void nuovoDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Docente oDocente = new Docente();
		HttpSession oSessione = request.getSession();
		oSessione.setAttribute("beanDocente", oDocente);
		getServletContext().getRequestDispatcher("/ArchivioDocente/PgsArchivioDocenteNuovoModifica.jsp")
				.forward(request, response);
	}

	private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Docente> elenco = Docente.elenco();
		request.setAttribute("elencoDocenti", elenco);
		// definizione di un'oggetto della classe servlet context
		ServletContext oContesto = getServletContext();
		// definizione di un oggetto per il dispatching o pubblicazione della pgs
		RequestDispatcher oDispatcher = oContesto.getRequestDispatcher("" + "/ArchivioDocente/PgsArchivioDocente.jsp");
		oDispatcher.forward(request, response);
	}

}
