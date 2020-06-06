package controller;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

//import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {
	
	private String scelta;


	private HashMap<String, String> map = new HashMap<String, String> () 
			{
		{
			put("DocenteRedirect", "Gestione Docente");
			put("CorsoRedirect", "Gestione Corso");
			put("DiscenteRedirect", "Gestione Discente");
			put("MateriaRedirect", "Gestione Materia");
			put("PersonaRedirect", "Gestione Persona");
			put("DragRedirect", "Drag and Drop");
		}
			};
			
	public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	
	public String getScelta() {
		return scelta;
	}

	public void setScelta(String scelta) {
		this.scelta = scelta;
	}
	
	public String execute() throws Exception {
		String result = INPUT;
		
		if(StringUtils.isNotBlank(scelta)) {
			result = scelta;
			scelta = null;
		}
		return result;
	}
}
