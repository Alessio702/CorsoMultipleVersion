package model.dao;

import java.util.List;

import model.session.Persona;

public class PersonaService extends AbstractService<PersonaDAO, Persona> {

	@Override
	public PersonaDAO createDAO() {
		return new PersonaDAO();
	}
}