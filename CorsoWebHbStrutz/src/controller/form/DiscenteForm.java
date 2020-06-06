package controller.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import model.session.Discente;

public class DiscenteForm extends ActionForm{
	
	private List<Discente> elencoDiscenti = new ArrayList<Discente>();
	private String metodo;
	private int chiave;
	private Discente oDiscente;

	public Discente getoDiscente() {
		return oDiscente;
	}

	public void setoDiscente(Discente oDiscente) {
		this.oDiscente = oDiscente;
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
	
	public List<Discente> getElencoDiscenti() {
		return elencoDiscenti;
	}

	public void setElencoDiscenti(List<Discente> elencoDiscenti) {
		this.elencoDiscenti = elencoDiscenti;
	}

	
	
}
