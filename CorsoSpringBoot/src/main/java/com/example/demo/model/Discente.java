package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name="HB_DISCENTE1")
public class Discente {



	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="cognome")
	@NotBlank(message="il campo non può essere vuoto")
	private String cognome;

	@Column(name="nome")
	@NotBlank(message="il campo non può essere vuoto")
	private String nome;

	@Column(name="matricola")
	@NotBlank(message="il campo non può essere vuoto")
	private String matricola;
	
	 @ManyToMany(mappedBy = "partecipanti")
	    private Set<Corso> corsi = new HashSet<>();
	 
	 
	
	public Set<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(Set<Corso> corsi) {
		this.corsi = corsi;
	}
	private String fullStudent;

	
	
	public String getFullStudent() {
		return fullStudent = this.cognome + " " + this.nome;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}






}
