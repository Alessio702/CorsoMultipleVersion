package model.dao;

import model.session.Discente;

public class DiscenteDAO extends AbstractDAO<Discente> {

	@Override
	public Class<Discente> getPersistentClass() {
		return Discente.class;
	}

}
