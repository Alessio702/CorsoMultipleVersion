package model.dao;

import model.session.Docente;

public class DocenteDAO extends AbstractDAO<Docente> {

	@Override
	public Class<Docente> getPersistentClass() {
		return Docente.class;
	}

}

