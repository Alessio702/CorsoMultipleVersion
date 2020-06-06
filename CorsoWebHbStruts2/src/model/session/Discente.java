package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="HB_DISCENTE1")
public class Discente extends Persona {

	public static final String PROPERTY_matricola = "matricola";

	
	@Column(name="matricola")
	private String matricola;



	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}






}
