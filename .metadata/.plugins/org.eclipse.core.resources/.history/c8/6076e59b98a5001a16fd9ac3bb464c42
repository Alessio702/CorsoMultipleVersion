package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "HB_DOCENTE1")
public class Docente {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "cognome")
	@NotBlank(message="il campo non può essere vuoto")
	private String cognome;

	@Column(name = "nome")
	@NotBlank(message = "Il campo non può essere vuoto")
	private String nome;
	
	private String fullName;
	
	

	public String getFullName() {
		return fullName = this.nome + " " + this.cognome;
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

//	public String getTitoloDiStudio() {
//		return titoloDiStudio;
//	}
//
//	public void setTitoloDiStudio(String titoloDiStudio) {
//		this.titoloDiStudio = titoloDiStudio;
//	}



}
