package model.dao;

import java.util.List;

import model.session.Docente;

public class DocenteService extends AbstractService<DocenteDAO, Docente> {

	@Override
	public DocenteDAO createDAO() {
		return new DocenteDAO();
	}

	private static DocenteService oDoc = new DocenteService();
	
	public void elencoDocente() {
		List<Docente> elenco = new DocenteService().findAll();
		for (int i = 0; i < elenco.size(); i++) {
			System.out.println(elenco.get(i).getNome() + " " + elenco.get(i).getCognome());
		}
	}
	
	public void nuovoDocente() {
		Docente oDocente = new Docente();
		oDocente.setCognome("Serafini");
		oDocente.setNome("Claudio");
		new DocenteService().persist(oDocente);
		List<Docente> elenco = new DocenteService().findAll();
		for (int i = 0; i < elenco.size(); i++) {
			System.out.println(elenco.get(i).getNome() + " " + elenco.get(i).getCognome());
		}
	}

	public void modificaDocente() {
		Docente oDocente = new DocenteService().findById(2);
		oDocente.setCognome("Prezioso");
		oDocente.setNome("Alex");
		new DocenteService().update(oDocente);
		List<Docente> elenco = new DocenteService().findAll();
		for (int i = 0; i < elenco.size(); i++) {
			System.out.println(elenco.get(i).getNome() + " " + elenco.get(i).getCognome());
		}
	}

	public void eliminaDocente() {
		Docente oDocente = new DocenteService().findById(2);
		if (oDocente.getId() != 0)
			oDoc.delete(oDocente.getId());
	}

	

}
