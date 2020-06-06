package controller.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import model.dao.DocenteService;
import model.session.Corso;
import model.session.Discente;
import model.session.Docente;

public class CorsoForm extends ActionForm{
	
	private List<Corso> elencoCorsi = new ArrayList<Corso>();
	private String metodo;
	private int chiave;
	private Corso oCorso;
	private List<Discente> nonpartecipanti = new ArrayList<Discente>();
	private int idCorsoDiscente;
	private List<Docente> elencoDocenti = new DocenteService().findAll();
	private int idCorsoDocente;
	


	public List<Discente> getNonpartecipanti() {
		return nonpartecipanti;
	}

	public void setNonpartecipanti(List<Discente> nonpartecipanti) {
		this.nonpartecipanti = nonpartecipanti;
	}

	public int getIdCorsoDiscente() {
		return idCorsoDiscente;
	}

	public void setIdCorsoDiscente(int idCorsoDiscente) {
		this.idCorsoDiscente = idCorsoDiscente;
	}

	
	public List<Docente> getElencoDocenti() {
		return elencoDocenti;
	}

	public int getIdCorsoDocente() {
		return idCorsoDocente;
	}

	public void setIdCorsoDocente(int idCorsoDocente) {
		this.idCorsoDocente = idCorsoDocente;
	}

	public void setElencoDocenti(List<Docente> elencoDocenti) {
		this.elencoDocenti = elencoDocenti;
	}

	public Corso getoCorso() {
		return oCorso;
	}

	public void setoCorso(Corso oCorso) {
		this.oCorso = oCorso;
	}

	public int getChiave() {
		return chiave;
	}

	public void setChiave(int chiave) {
		this.chiave = chiave;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	
	public List<Corso> getElencoCorsi() {
		return elencoCorsi;
	}

	public void setElencoCorsi(List<Corso> elencoCorsi) {
		this.elencoCorsi = elencoCorsi;
	}


	
}
