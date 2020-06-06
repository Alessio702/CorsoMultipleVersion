package model.dao;

import model.session.Materia;

public class MateriaDAO extends AbstractDAO<Materia> {
	
	@Override
	public Class<Materia> getPersistentClass() {
		return Materia.class;
	}

}
