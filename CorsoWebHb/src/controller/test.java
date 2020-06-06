package controller;

import java.text.ParseException;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import model.dao.AulaService;
import model.dao.CorsoService;
import model.dao.DocenteService;
import model.dao.StudenteService;
import model.session.Aula;
import model.session.Corso;
import model.session.Docente;
import model.session.Persona;
import model.session.Studente;
import util.UDate;

public class test {

	// come variabile statica
	// sia nel modo in basso istanziando l'oggetto

	
	private static StudenteService oStud = new StudenteService();
	
	public static void main(String[] args) {

	
	//List<Studente> elenco = new StudenteService().executeHQLQuery("SELECT s FROM model.session.Studente s WHERE s.nome = \'Alex\'");
		
//		List<String> elenco = new StudenteService().executeHQLGeneric(String.class, "SELECT s.nome FROM model.session.Studente s");
	
//		List<Persona> elenco = new StudenteService().executeHQLGeneric(Persona.class, "SELECT p FROM Persona p");
		
//		Studente oStudente = new Studente();
//		oStudente.setCognome("Serafini");
//		oStudente.setNome("Alba");
//		oStudente.setMatricola("123");
//		oStud.persist(oStudente);
		
		
		
		List<Studente> test = oStud.findWithCriteria(Restrictions.eq(Studente.PROPERTY_nome, "Alba"));
	
		int i = 0;
	}

}
