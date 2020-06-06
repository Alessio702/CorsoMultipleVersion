package model.dao;

import java.util.List;

import model.session.Aula;


public class AulaService extends AbstractService<AulaDAO, Aula> {

	private static AulaService oAul = new AulaService();
	
	@Override
	public AulaDAO createDAO() {
		return new AulaDAO();
	}
	
	public void elencoAula() {
		List<Aula> elenco = new AulaService().findAll();
		for (int i = 0; i < elenco.size(); i++) {
			System.out.println(elenco.get(i).getDescrizione() + " " + elenco.get(i).getnumeroPosti());
		}
	}

	public void nuovaAula() {
		Aula oAula = new Aula();
		oAula.setDescrizione("Java");
		oAula.setNumeroPosti(10);
		new AulaService().persist(oAula);
		List<Aula> elenco = new AulaService().findAll();
		for (int i = 0; i < elenco.size(); i++) {
			System.out.println(elenco.get(i).getDescrizione() + " " + elenco.get(i).getnumeroPosti());
		}
	}

	public void modificaAula() {
		Aula oAula = new AulaService().findById(1);
		oAula.setDescrizione("html");
		oAula.setNumeroPosti(20);
		new AulaService().update(oAula);
		List<Aula> elenco = new AulaService().findAll();
		for (int i = 0; i < elenco.size(); i++) {
			System.out.println(elenco.get(i).getDescrizione() + " " + elenco.get(i).getnumeroPosti());
		}
	}

	public void eliminaAula() {
		Aula oAula = new AulaService().findById(2);
		if (oAula.getId() != 0)
			oAul.delete(oAula.getId());
	}

}
