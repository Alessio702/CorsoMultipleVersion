package model.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.session.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "HB_CORSO1")
public class Corso {

	public static final String PROPERTY_id = "id";
	public static final String PROPERTY_oDocente = "iddocente";
	public static final String PROPERTY_oAula = "idaula";
	public static final String PROPERTY_corso = "corso";
	public static final String PROPERTY_durata = "durata";
	public static final String PROPERTY_datainzio = "datainizio";
	public static final String PROPERTY_partecipanti = "partecipanti";

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "iddocente")
	private Docente oDocente;

	@ManyToOne
	@JoinColumn(name = "idaula")
	private Aula oAula;

	@Column(name = "corso")
	private String corso;

	@Column(name = "durata")
	private String durata;

	@Column(name = "datainizio")
	private Date datainizio;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "HB_CORSO_DISCENTE1", joinColumns = { @JoinColumn(name = "IDCORSO") }, inverseJoinColumns = {
			@JoinColumn(name = "IDDiscente") })

	private List<Discente> partecipanti = new ArrayList<Discente>();

	public List<Discente> getPartecipanti() {
		return partecipanti;
	}

	public void setPartecipanti(ArrayList<Discente> partecipanti) {
		this.partecipanti = partecipanti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Docente getoDocente() {
		return oDocente;
	}

	public void setoDocente(Docente oDocente) {
		this.oDocente = oDocente;
	}

	public Aula getoAula() {
		return oAula;
	}

	public void setoAula(Aula oAula) {
		this.oAula = oAula;
	}

	public Date getDatainizio() {
		return datainizio;
	}

	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public String getDurata() {
		return durata;
	}

	public void setDurata(String durata) {
		this.durata = durata;
	}

}
