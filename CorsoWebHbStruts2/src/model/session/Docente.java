package model.session;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "HB_DOCENTE1")
public class Docente extends Persona {
	public static final String PROPERTY_anniesp = "anniesp";

	@Column(name = "anniesp")
	private String anniesp;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "HB_DOCENTE_MATERIE", joinColumns = { @JoinColumn(name = "IDDOCENTE") }, inverseJoinColumns = {
			@JoinColumn(name = "IDMATERIA") })
	private List<Materia> materie = new ArrayList<Materia>();

	public String getAnniesp() {
		return anniesp;
	}

	public void setAnniesp(String anniesp) {
		this.anniesp = anniesp;
	}

	public List<Materia> getMaterie() {
		return materie;
	}

	public void setMaterie(List<Materia> materie) {
		this.materie = materie;
	}


	


}
