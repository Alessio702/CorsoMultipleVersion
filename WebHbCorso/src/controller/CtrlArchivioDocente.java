package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DocenteService;
import model.session.Docente;

/**
 * Servlet implementation class CtrlArchivioDocente
 */
@WebServlet("/CtrlArchivioDocente")
public class CtrlArchivioDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DocenteService oDoc = new DocenteService();

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
		oDoc.delete(((Docente) request.getSession().getAttribute("beanDocente")).getId());
	}

	private void eliminaDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Docente oDocente = oDoc.findById(Integer.parseInt(request.getParameter("rdoIDDocente")));
		request.getSession().setAttribute("beanDocente", oDocente);
		getServletContext().getRequestDispatcher("/ArchivioDocente/PgsArchivioDocenteElimina.jsp").forward(request, response);
}

	private void modificaDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Docente oDocente = oDoc.findById(Integer.parseInt(request.getParameter("rdoIDDocente")));
		request.getSession().setAttribute("beanDocente", oDocente);
		getServletContext().getRequestDispatcher("/ArchivioDocente/PgsArchivioDocenteNuovoModifica.jsp").forward(request, response);

	}

	private void salvaDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		((Docente) request.getSession().getAttribute("beanDocente")).setCognome(request.getParameter("txtCognome"));
		((Docente) request.getSession().getAttribute("beanDocente")).setNome(request.getParameter("txtNome"));
		if(((Docente) request.getSession().getAttribute("beanDocente")).getId() == 0)
			oDoc.persist(((Docente) request.getSession().getAttribute("beanDocente"))); 
		else
			oDoc.update(((Docente) request.getSession().getAttribute("beanDocente")));
	
	}

	private void nuovoDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Docente oDocente = new Docente();
		request.getSession().setAttribute("beanDocente", oDocente);
		getServletContext().getRequestDispatcher("/ArchivioDocente/PgsArchivioDocenteNuovoModifica.jsp").forward(request, response);
	
	}

	private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Docente> elenco = new DocenteService().findAll();
		request.setAttribute("elencoDocenti", elenco);
		getServletContext().getRequestDispatcher("/ArchivioDocente/PgsArchivioDocente.jsp").forward(request, response);
		
	}

}
