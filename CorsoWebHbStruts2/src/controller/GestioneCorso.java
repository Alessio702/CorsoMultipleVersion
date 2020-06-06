package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AulaService;
import model.dao.CorsoService;
import model.dao.DiscenteService;
import model.dao.DocenteService;
import model.dao.MateriaService;
import model.session.Corso;
import model.session.Discente;
import model.session.Docente;
import model.session.Materia;

public class GestioneCorso extends ActionSupport implements SessionAware {

	// Attributi
	public static final String KEY_LIST = "lista";
	public static final String KEY_LISTDISC = "listadisc";
	public static final String KEY_OBJ = "oggetto";
	public static final String KEY_MAP = "mappa";
	public static final String KEY_MAPMAT = "mappamaterie";
	private SessionMap<String, Object> sessionMap;
	private String IDMateria;
	private String chiave;
	private Corso ocorso;
	private String corsoCor;
	private String durataCor;
	private String IDDocente;
	private String idPartecipante;
	private List<Materia> elencoMaterie;
	private List<Docente> elencoDocenti;
	private List<Discente> elencoDiscenti;

	CorsoService oCor = new CorsoService();
	DocenteService oDoc = new DocenteService();
	DiscenteService oDisc = new DiscenteService();
	MateriaService oMat = new MateriaService();
	
	
	// Get e set

	public List<Docente> getElencoDocenti() {
		return elencoDocenti;
	}

	public void setElencoDocenti(List<Docente> elencoDocenti) {
		this.elencoDocenti = elencoDocenti;
	}

	public String getIDMateria() {
		return IDMateria;
	}

	public void setIDMateria(String iDMateria) {
		IDMateria = iDMateria;
	}

	public List<Materia> getElencoMaterie() {
		return elencoMaterie;
	}

	public void setElencoMaterie(List<Materia> elencoMaterie) {
		this.elencoMaterie = elencoMaterie;
	}

	public String getIdPartecipante() {
		return idPartecipante;
	}

	public void setIdPartecipante(String idPartecipante) {
		this.idPartecipante = idPartecipante;
	}

	public List<Discente> getElencoDiscenti() {
		return elencoDiscenti;
	}

	public void setElencoDiscenti(List<Discente> elencoDiscenti) {
		this.elencoDiscenti = elencoDiscenti;
	}

	public String getIDDocente() {
		return IDDocente;
	}

	public void setIDDocente(String iDDocente) {
		IDDocente = iDDocente;
	}

	public String getCorsoCor() {
		return corsoCor;
	}

	public void setCorsoCor(String corsoCor) {
		this.corsoCor = corsoCor;
	}

	public String getDurataCor() {
		return durataCor;
	}

	public void setDurataCor(String durataCor) {
		this.durataCor = durataCor;
	}

	public Corso getOdocente() {
		return ocorso;
	}

	public void setOdocente(Corso ocorso) {
		this.ocorso = ocorso;
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

	public String execute() {
		sessionMap.put(KEY_LIST, oCor.findAll());
		return "search";
	}

	public String modificaCorso() {

		HashMap<String, String> map = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Docente");
				elencoDocenti = oDoc.findAll();
				for (int i = 0; i < elencoDocenti.size(); i++) {
					put(String.valueOf(elencoDocenti.get(i).getId()),
							elencoDocenti.get(i).getNome() + " " + elencoDocenti.get(i).getCognome());
				}
			}
		};
		HashMap<String, String> mapmat = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona una materia");
				elencoMaterie = oMat.findAll();
				for (int i = 0; i < elencoMaterie.size(); i++) {
					put(String.valueOf(elencoMaterie.get(i).getId()),
							elencoMaterie.get(i).getNome() + " " + elencoMaterie.get(i).getTipologia());
				}
			}
		};
		sessionMap.put(KEY_OBJ, oCor.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		sessionMap.put(KEY_MAP, map);
		sessionMap.put(KEY_MAPMAT, mapmat);
		sessionMap.put(KEY_LISTDISC, oDisc.findAll());
		return "modifica";
	}

	public String nuovoCorso() {
		HashMap<String, String> map = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Docente");
				elencoDocenti = oDoc.findAll();
				for (int i = 0; i < elencoDocenti.size(); i++) {
					put(String.valueOf(elencoDocenti.get(i).getId()),
							elencoDocenti.get(i).getNome() + " " + elencoDocenti.get(i).getCognome());
				}
			}
		};
		HashMap<String, String> mapmat = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona una materia");
				elencoMaterie = oMat.findAll();
				for (int i = 0; i < elencoMaterie.size(); i++) {
					put(String.valueOf(elencoMaterie.get(i).getId()),
							elencoMaterie.get(i).getNome() + " " + elencoMaterie.get(i).getTipologia());
				}
			}
		};
		sessionMap.put(KEY_OBJ, new Corso());
		sessionMap.put(KEY_MAP, map);
		sessionMap.put(KEY_MAPMAT, mapmat);
		sessionMap.put(KEY_LISTDISC, oDisc.findAll());
		return "nuovo";
	}

	public String aggiungiPartecipante() {
		Corso oCorso = (Corso) sessionMap.get(KEY_OBJ);

		oCorso.getPartecipanti().add(oDisc.findById(Integer.parseInt(this.idPartecipante)));
		setProprieta(oCorso);
		return "nuovomodifica";
	}

	public void setProprieta(Corso oCorso) {
	    if (!StringUtils.isBlank(corsoCor))
	      oCorso.setCorso(this.corsoCor);
	    else
	      oCorso.setCorso("");
	  
	    if (!StringUtils.isBlank(durataCor))
	      oCorso.setDurata(this.durataCor);
	    else
	      oCorso.setDurata("");
	    if (!StringUtils.isBlank(IDDocente))
	      oCorso.setOdocente(new DocenteService().findById(Integer.parseInt(this.IDDocente)));
	    else
	      oCorso.setOdocente(null);
	    if (!StringUtils.isBlank(IDMateria))
		      oCorso.setOmateria(new MateriaService().findById(Integer.parseInt(this.IDMateria)));
		    else
		      oCorso.setOmateria(null);
	 
	  }

	public String rimuoviPartecipante() {
		Corso oCorso = (Corso) sessionMap.get(KEY_OBJ);

		int i = 0;

		while (i < oCorso.getPartecipanti().size()) {
			if (oCorso.getPartecipanti().get(i).getId() == Integer.parseInt(this.idPartecipante)) {
				oCorso.getPartecipanti().remove(i);

				i = oCorso.getPartecipanti().size();
			}
			i++;
		}
		return "nuovomodifica";
	}

	public String eliminaCorso() {
		oCor.delete(oCor.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		return execute();
	}

	public String annulla() {
		return execute();
	}

	public String registra() {
		Corso ocorso = (Corso) sessionMap.get(KEY_OBJ);
		ocorso.setCorso(corsoCor);
		ocorso.setOdocente(oDoc.findById(Integer.parseInt(this.IDDocente)));
		ocorso.setDurata(durataCor);
		ocorso.setOaula(new AulaService().findById(2));
		ocorso.setOmateria(oMat.findById(Integer.parseInt(this.IDMateria)));
		oCor.persistOrUpdate(ocorso);
		return execute();
	}
}