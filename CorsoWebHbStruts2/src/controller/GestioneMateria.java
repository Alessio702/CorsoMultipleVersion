package controller;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.MateriaService;
import model.session.Materia;

public class GestioneMateria extends ActionSupport implements SessionAware {

	
	public static final String KEY_LIST = "lista";
	public static final String KEY_OBJ = "oggetto";
	private String nome;
	private String tipologia;
	private String chiave;
	private Materia omateria;
	private String nomeMat;
	private String tipologiaMat;
	private SessionMap<String, Object> sessionMap;
	MateriaService oMat = new MateriaService();
	
	
	public String getNomeMat() {
		return nomeMat;
	}
	public void setNomeMat(String nomeMat) {
		this.nomeMat = nomeMat;
	}
	public String getTipologiaMat() {
		return tipologiaMat;
	}
	public void setTipologiaMat(String tipologiaMat) {
		this.tipologiaMat = tipologiaMat;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipologia() {
		return tipologia;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public Materia getOmateria() {
		return omateria;
	}
	public void setOmateria(Materia omateria) {
		this.omateria = omateria;
	}
	
	public String execute() {
		sessionMap.put(KEY_LIST, oMat.findAll());
		return "search";
	}
	
	public String annulla() {
		return execute();
	}
	
	public String nuovaMateria() {
		sessionMap.put(KEY_OBJ, new Materia());
		return "nuovo";
	}
	
	public String modificaMateria() {
		sessionMap.put(KEY_OBJ, oMat.findById(Integer.parseInt(this.chiave.replace("/'", ""))));
		return execute();
	}
	
	public String eliminaMateria() {
		oMat.delete(oMat.findById(Integer.parseInt(this.chiave.replace("/'", ""))));
		return execute();
	}
	
	public String registra() {
		Materia omateria = (Materia) sessionMap.get(KEY_OBJ);
		omateria.setNome(nomeMat);
		omateria.setTipologia(tipologiaMat);
		oMat.persistOrUpdate(omateria);
		return execute();
	}
	
	
	
	
}
