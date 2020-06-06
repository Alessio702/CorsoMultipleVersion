package com.example.demo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "HB_CORSO1")
public class Corso {


	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "iddocente")
	@NotNull(message="il campo non può essere nullo")
	private Docente odocente;

	@ManyToOne
	@JoinColumn(name = "idaula")
	@NotNull(message="il campo non può essere nullo")
	private Aula oaula;

	@Column(name = "corso")
	@NotBlank(message="il campo non può essere vuoto")
	private String corso;

	@Column(name = "durata")
	@NotBlank(message="il campo non può essere vuoto")
	private String durata;

	@Column(name = "datainizio")
	@NotBlank(message="il campo non può essere vuoto")
	private Date datainizio;
	

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "HB_CORSO_DISCENTE1", joinColumns = { @JoinColumn(name = "IDCORSO") }, inverseJoinColumns = {
			@JoinColumn(name = "IDDiscente") })
	@NotEmpty(message="il campo deve essere valorizzato")
	private Set<@Valid Discente> partecipanti = new HashSet<>();

	public Set<Discente> getPartecipanti() {
		return partecipanti;
	}

	public void setPartecipanti(Set<Discente> partecipanti) {
		this.partecipanti = partecipanti;
	}

	public Date getDatainizio() {
		return datainizio;
	}

	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Docente getOdocente() {
		return odocente;
	}

	public void setOdocente(Docente odocente) {
		this.odocente = odocente;
	}

	public Aula getOaula() {
		return oaula;
	}

	public void setOaula(Aula oaula) {
		this.oaula = oaula;
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
