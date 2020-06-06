package model.dao;

import model.session.Aula;

public class AulaDAO extends AbstractDAO<Aula> {

	@Override
	public Class<Aula> getPersistentClass() {
		return Aula.class;
	}

}

