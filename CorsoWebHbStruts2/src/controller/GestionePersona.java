package controller;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.PersonaService;
import model.session.Persona;

public class GestionePersona extends ActionSupport implements SessionAware {
	
	public static final String KEY_LIST = "lista";
	public static final String KEY_OBJ = "oggetto";
	private SessionMap<String, Object> sessionMap;
	private String chiave;
	private Persona opersona;
	PersonaService oPer = new PersonaService();
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public Persona getOpersona() {
		return opersona;
	}
	public void setOpersona(Persona opersona) {
		this.opersona = opersona;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	
	public String execute() {
		sessionMap.put(KEY_LIST, oPer.findAll());
		return "search";
	}
	
	public String annulla() {
		return execute();
	}
	
}
