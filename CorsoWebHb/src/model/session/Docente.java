package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HB_DOCENTE")
public class Docente extends Persona {
	
	public static final String PROPERTY_matricola = "titolo_di_studio";

	
//	public static final String PROPERTY_id = "id";
//	public static final String PROPERTY_cognome = "cognome";
//	public static final String PROPERTY_nome = "nome";

//	@Column(name = "id")
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int id;
//
//	@Column(name = "cognome")
//	private String cognome;

	@Column(name = "titolo_di_studio")
	private String titoloDiStudio;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getCognome() {
//		return cognome;
//	}
//
//	public void setCognome(String cognome) {
//		this.cognome = cognome;
//	}

	public String getTitoloDiStudio() {
		return titoloDiStudio;
	}

	public void setTitoloDiStudio(String titoloDiStudio) {
		this.titoloDiStudio = titoloDiStudio;
	}



}
