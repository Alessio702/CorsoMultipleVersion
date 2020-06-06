package controller;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.DiscenteService;
import model.session.Discente;

public class GestioneDiscente extends ActionSupport implements SessionAware {
    
    //Attributi
    public static final String KEY_LIST = "lista";
    public static final String KEY_OBJ = "oggetto";
    private SessionMap<String, Object> sessionMap;
    private String chiave;
    private Discente odiscente;
    private String cognomeDisc;
    private String nomeDisc;
    private String matricolaDisc;

	DiscenteService oDisc = new DiscenteService();
    
    
    //Get e set
    
	
	
    public String getMatricolaDisc() {
		return matricolaDisc;
	}


	public void setMatricolaDisc(String matricolaDisc) {
		this.matricolaDisc = matricolaDisc;
	}

	public String getCognomeDisc() {
		return cognomeDisc;
	}

	public void setCognomeDisc(String cognomeDisc) {
		this.cognomeDisc = cognomeDisc;
	}


	public String getNomeDisc() {
		return nomeDisc;
	}


	public void setNomeDisc(String nomeDisc) {
		this.nomeDisc = nomeDisc;
	}

    
    public Discente getOdiscente() {
		return odiscente;
	}


	public void setOdiscente(Discente odiscente) {
		this.odiscente = odiscente;
	}



    public String getChiave() {
		return chiave;
	}


	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	
    @Override
    public void setSession(Map<String, Object> arg0)
    {
    	this.sessionMap = (SessionMap<String, Object>) arg0;
    }

    
    public String execute() {
        sessionMap.put(KEY_LIST, oDisc.findAll());
        return "search"; 
    }
    
    public String modificaDiscente() {
    	sessionMap.put(KEY_OBJ, oDisc.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		return "modifica";
    }
    
    public String nuovoDiscente() {
    	sessionMap.put(KEY_OBJ, new Discente());
    	return "nuovo";
    }
    
    public String eliminaDocente() {
    	oDisc.delete(oDisc.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		return execute();
    }
    
    
    public String annulla() {
    	return execute();
    }
    
    public String registra() {
    	Discente odiscente = (Discente) sessionMap.get(KEY_OBJ);
    	odiscente.setNome(nomeDisc);
    	odiscente.setCognome(cognomeDisc);
    	odiscente.setMatricola(matricolaDisc);
    	oDisc.persistOrUpdate(odiscente);
    	return execute();
    }
    
  
}