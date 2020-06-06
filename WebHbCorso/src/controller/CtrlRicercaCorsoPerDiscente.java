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
import model.dao.DiscenteService;
import model.dao.DocenteService;
import model.session.Corso;
import model.session.Discente;

/**
 * Servlet implementation class CtrlRicercaCorsoPerDiscente
 */
@WebServlet("/CtrlRicercaCorsoPerDiscente")
public class CtrlRicercaCorsoPerDiscente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DiscenteService oDisc = new DiscenteService();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CtrlRicercaCorsoPerDiscente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String azione = request.getParameter("cmdAzione");
		if (azione == null) {
			visualizzaScelta(request, response);
		} else if (azione.equals("Torna alla Home")) {
			getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
		} else if (azione.equals("Cerca")) {
			corsoPerDiscente(request, response);
		}
	}

	private void corsoPerDiscente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Discente> elenco = new DiscenteService().findAll();
		request.setAttribute("elencoDiscenti", elenco);
		List<Corso> elencoCorsi = new CorsoService().findAll();
		request.setAttribute("elencoCorsi", elencoCorsi);
		Discente oDiscente = oDisc.findById((Integer.parseInt(request.getParameter("cboDiscente2"))));
		request.getSession().setAttribute("beanDiscente", oDiscente);
		getServletContext().getRequestDispatcher("" + "/RicercaCorsoPerDiscente/PgsRicercaCorsoPerDiscente.jsp").forward(request, response);
	}

	private void visualizzaScelta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Discente> elenco = new DiscenteService().findAll();
		request.setAttribute("elencoDiscenti", elenco);
		List<Corso> elencoCorsi = new CorsoService().findAll();
		request.setAttribute("elencoCorsi", elencoCorsi);
		request.setAttribute("beanDiscente", new Discente());
		getServletContext().getRequestDispatcher("/RicercaCorsoPerDiscente/PgsRicercaCorsoPerDiscente.jsp").forward(request, response);

	}

}
