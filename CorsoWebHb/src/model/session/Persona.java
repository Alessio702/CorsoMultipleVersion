package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@MappedSuperclass
// Ci sono 3 modi per sviluppare l'ereditarietà o con 
// mappedsuperclass o con l' InheritanceType.SINGLE_TABLE
// o con InheritanceType.TABLE_PER_CLASS o con Type. JOINED
@Entity
@Table(name = "HB_PERSONA")
@Inheritance(strategy = InheritanceType.JOINED)

public class Persona {
	public static final String PROPERTY_id = "id";
	public static final String PROPERTY_cognome = "cognome";
	public static final String PROPERTY_nome = "nome";

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "cognome")
	private String cognome;

	@Column(name = "nome")
	private String nome;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

}
