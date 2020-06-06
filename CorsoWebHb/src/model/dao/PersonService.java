package model.dao;

import model.session.Persona;

public class PersonService extends AbstractService<PersonaDAO, Persona> {
	
	@Override
	public PersonaDAO createDAO() {
		return new PersonaDAO();
	}


}
