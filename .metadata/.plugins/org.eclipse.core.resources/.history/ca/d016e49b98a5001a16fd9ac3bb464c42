package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "HB_AULA1")
public class Aula {

	public static final String PROPERTY_id = "id";
	public static final String PROPERTY_descrizione = "descrizione";
	public static final String PROPERTY_numeroPosti = "numeroPosti";

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "descrizione")
	@NotBlank(message = "Il campo non può essere vuoto")
	private String descrizione;

	@Column(name = "numeroPosti")
	@NotNull(message = "Il campo non può essere vuoto")
	@Min(value = 1)
	private Integer numeroPosti;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(Integer numeroPosti) {
		this.numeroPosti = numeroPosti;
	}





}
