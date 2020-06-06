package controller.form;

import org.apache.struts.action.ActionForm;

public class MainForm extends ActionForm {

	private String rdoScelta;
	private String metodo;
	
	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getRdoScelta() {
		return rdoScelta;
	}

	public void setRdoScelta(String rdoScelta) {
		this.rdoScelta = rdoScelta;
	}
	
	
	
}
