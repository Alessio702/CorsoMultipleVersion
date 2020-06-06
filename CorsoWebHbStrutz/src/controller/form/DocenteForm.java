package controller.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;

import model.session.Docente;

public class DocenteForm extends ActionForm{
	
	private List<Docente> elencoDocenti = new ArrayList<Docente>();
	private String metodo;
	private int chiave;
	private Docente oDocente;

	public Docente getoDocente() {
		return oDocente;
	}

	public void setoDocente(Docente oDocente) {
		this.oDocente = oDocente;
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
	
	public List<Docente> getElencoDocenti() {
		return elencoDocenti;
	}

	public void setElencoDocenti(List<Docente> elencoDocenti) {
		this.elencoDocenti = elencoDocenti;
	}

	//Method
	public ActionErrors validaForm() {
		ActionErrors errors = new ActionErrors();
		if(StringUtils.isBlank(this.oDocente.getCognome())) {
			errors.add("cognome", new ActionMessage("errors.required", "cognome"));
			errors.add("nome", new ActionMessage("errors.required", "nome"));
		}
		return errors;
	}
	
}
