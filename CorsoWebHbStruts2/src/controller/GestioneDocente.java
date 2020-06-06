package controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.DocenteService;
import model.dao.MateriaService;
import model.session.Docente;
import model.session.Materia;

public class GestioneDocente extends ActionSupport implements SessionAware {

	// Attributi
	public static final String KEY_LIST = "lista";
	public static final String KEY_OBJ = "oggetto";
	public static final String KEY_LISTMAT = "listamaterie";
	private SessionMap<String, Object> sessionMap;
	private String idMateria;
	private List<Materia> elencoMaterie;
	private String chiave;
	private Docente odocente;
	private String cognomeDoc;
	private String nomeDoc;
	private String anniEspDoc;

	DocenteService oDoc = new DocenteService();
	MateriaService oMat = new MateriaService();
	
	
	
	// Get e set
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}


	public List<Materia> getElencoMaterie() {
		return elencoMaterie;
	}

	public void setElencoMaterie(List<Materia> elencoMaterie) {
		this.elencoMaterie = elencoMaterie;
	}



	public String getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(String idMateria) {
		this.idMateria = idMateria;
	}

	public String getCognomeDoc() {
		return cognomeDoc;
	}

	public void setCognomeDoc(String cognomeDoc) {
		this.cognomeDoc = cognomeDoc;
	}
	
	public String getNomeDoc() {
		return nomeDoc;
	}

	public void setNomeDoc(String nomeDoc) {
		this.nomeDoc = nomeDoc;
	}

	public Docente getOdocente() {
		return odocente;
	}

	public void setOdocente(Docente odocente) {
		this.odocente = odocente;
	}

	public String getChiave() {
		return chiave;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	private void setProprieta(Docente oDocente) {
		if(!StringUtils.isBlank(nomeDoc))
			oDocente.setNome(this.nomeDoc);
		else
			oDocente.setNome("");
		if(!StringUtils.isBlank(cognomeDoc))
			oDocente.setCognome(this.cognomeDoc);
		else
			oDocente.setCognome("");
		if(!StringUtils.isBlank(anniEspDoc))
			oDocente.setAnniesp(this.anniEspDoc);
			
	}

	
	
	//metodi
	public String execute() {
		sessionMap.put(KEY_LIST, oDoc.findAll());
		return "search";
	}

	public String modificaDocente() {
		sessionMap.put(KEY_OBJ, oDoc.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		sessionMap.put(KEY_LISTMAT, oMat.findAll());
		return "modifica";
	}

	public String nuovoDocente() {

		sessionMap.put(KEY_OBJ, new Docente());
		sessionMap.put(KEY_LISTMAT, oMat.findAll());
		return "nuovo";
	}

	public String aggiungiMateria() {
		Docente oDocente = (Docente) sessionMap.get(KEY_OBJ);
		oDocente.getMaterie().add(oMat.findById(Integer.parseInt(this.idMateria)));
		setProprieta(oDocente);
		return "nuovomodifica";
	}

	
	public String rimuoviMateria() {
		Docente oDocente = (Docente) sessionMap.get(KEY_OBJ);

		int i = 0;

		while (i < oDocente.getMaterie().size()) {
			if (oDocente.getMaterie().get(i).getId() == Integer.parseInt(this.idMateria)) {
				oDocente.getMaterie().remove(i);

				i = oDocente.getMaterie().size();
			}
			i++;
		}
		return "nuovomodifica";
	}
	

	public String eliminaDocente() {
		oDoc.delete(oDoc.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		return execute();
	}

	public String annulla() {
		return execute();
	}

	public String registra() {
		Docente odocente = (Docente) sessionMap.get(KEY_OBJ);
		if (StringUtils.isBlank(nomeDoc)) {
			addActionError("Campo Nome obbligatorio");
		}
		if (StringUtils.isBlank(cognomeDoc)) {
			addActionError("Campo Cognome obbligatorio");
		}
		if (!hasActionErrors()) {
			odocente.setNome(nomeDoc);
			odocente.setCognome(cognomeDoc);
			odocente.setAnniesp(anniEspDoc);
			oDoc.persistOrUpdate(odocente);
			addActionMessage("Il salvataggio è stato riuscito");
			return execute();
		} else {
			return "nuovomodifica";
		}

	}

}