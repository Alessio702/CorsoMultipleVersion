package model.dao;

import model.session.Persona;

public class PersonaDAO extends AbstractDAO<Persona> {

	@Override
	public Class<Persona> getPersistentClass() {
		return Persona.class;
	}

}

