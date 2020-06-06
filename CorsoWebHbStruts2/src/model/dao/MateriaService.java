package model.dao;

import model.session.Materia;

public class MateriaService extends AbstractService<MateriaDAO, Materia> {
	
	@Override
	public MateriaDAO createDAO() {
		return new MateriaDAO();
	}
}
