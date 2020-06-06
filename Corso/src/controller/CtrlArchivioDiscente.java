package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.session.Discente;

/**
 * Servlet implementation class CtrlArchivioDiscente
 */
@WebServlet("/CtrlArchivioDiscente")
public class CtrlArchivioDiscente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrlArchivioDiscente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String azione = request.getParameter("cmdAzione");
		if(azione == null) {
			visualizzaElenco(request, response);
		}
		else if (azione.equals("Torna alla Home")) {
			getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
		}
		else if (azione.equals("Nuovo")) {
			nuovoDiscente(request, response);
		}
		else if (azione.equals("Annulla")) {
			visualizzaElenco(request, response);
		}
		else if (azione.equals("Registra")) {
			salvaDiscente(request, response);
			visualizzaElenco(request, response);
		}
		else if (azione.equals("Modifica")) {
			modificaDiscente(request, response);
		}
		else if (azione.equals("Elimina")) {
			eliminaDiscente(request, response);
		}
		else if(azione.equals("Conferma")) {
			cancellaDiscente(request, response);
			visualizzaElenco(request, response);
		}
	}
	
	
	private void cancellaDiscente(HttpServletRequest request, HttpServletResponse response) {
		((Discente) request.getSession().getAttribute("beanDiscente")).elimina();

	}
	
	

	private void eliminaDiscente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("beanDiscente", new Discente(Integer.parseInt(request.getParameter("rdoIDDiscente"))));
		getServletContext().getRequestDispatcher("/ArchivioDiscente/PgsArchivioDiscenteElimina.jsp").forward(request, response);
	}

	private void modificaDiscente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("beanDiscente", new Discente(Integer.parseInt(request.getParameter("rdoIDDiscente"))));
		getServletContext().getRequestDispatcher("/ArchivioDiscente/PgsArchivioDiscenteNuovoModifica.jsp").forward(request, response);

	}

	private void salvaDiscente(HttpServletRequest request, HttpServletResponse response) {
		((Discente) request.getSession().getAttribute("beanDiscente")).setCognome(request.getParameter("txtCognome"));
		((Discente) request.getSession().getAttribute("beanDiscente")).setNome(request.getParameter("txtNome"));
		((Discente) request.getSession().getAttribute("beanDiscente")).setMatricola(request.getParameter("txtMatricola"));
		((Discente) request.getSession().getAttribute("beanDiscente")).salva();
	}

	private void nuovoDiscente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Discente oDiscente = new Discente();
		request.getSession().setAttribute("beanDiscente", oDiscente);
		getServletContext().getRequestDispatcher("/ArchivioDiscente/PgsArchivioDiscenteNuovoModifica.jsp").forward(request, response);
	}

	private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Discente> elenco = Discente.elenco();
		request.setAttribute("elencoDiscenti", elenco);
		getServletContext().getRequestDispatcher("/ArchivioDiscente/PgsArchivioDiscente.jsp").forward(request, response);
		
	}

}
