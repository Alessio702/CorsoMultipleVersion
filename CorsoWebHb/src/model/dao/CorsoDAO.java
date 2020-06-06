package model.dao;

import model.session.Corso;

public class CorsoDAO extends AbstractDAO<Corso>{
	
	@Override
	public Class<Corso> getPersistentClass() {
		return Corso.class;
	}

}
