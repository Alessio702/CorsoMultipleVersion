package model.dao;

import java.util.List;

import model.session.Discente;

public class DiscenteService extends AbstractService<DiscenteDAO, Discente> {

	@Override
	public DiscenteDAO createDAO() {
		return new DiscenteDAO();
	}

	private static DiscenteService oStud = new DiscenteService();
	
	
	
	


	
	public List<Discente> findByX(String campo, Object valore) {
		getDao().openCurrentSessionwithTransaction();
		List<Discente> result = getDao().getCurrentSession()
				.createQuery("SELECT s FROM model.session.Discente s WHERE s." + campo + "=\'" + valore + "/'",
						Discente.class)
				.getResultList();
		getDao().closeCurrentSessionwithTransaction();
		return result;
	}

	public List<Discente> findByNome(String nome) {
		getDao().openCurrentSessionwithTransaction();
		List<Discente> result = getDao().getCurrentSession()
				.createQuery("SELECT s FROM model.session.Discente s WHERE s.nome = \'" + nome + "\'", Discente.class)
				.getResultList();
		getDao().closeCurrentSessionwithTransaction();
		return result;
	}

//	@Override
//	public List<Discente> findAll() {
//		getDao().openCurrentSessionwithTransaction();
//		List<Discente> result = getDao().getCurrentSession()
//				.createQuery("SELECT s FROM model.session.Discente s WHERE s.nome = \'nome\'", Discente.class)
//				.getResultList();
//		getDao().closeCurrentSessionwithTransaction();
//		return result;
//	}

	public void elencoDiscente() {
		List<Discente> elenco = new DiscenteService().findAll();
		// new DiscenteService().refresh(elenco.get(i));
		for (int i = 0; i < elenco.size(); i++) {
			System.out.println(
					elenco.get(i).getNome() + " " + elenco.get(i).getCognome() + " " + elenco.get(i).getMatricola());
		}
	}

	public void nuovoDiscente() {
		Discente oDiscente = new Discente();
		oDiscente.setCognome("Prezioso");
		oDiscente.setNome("Fabio");
		oDiscente.setMatricola("64490");
		new DiscenteService().persist(oDiscente);
		List<Discente> elenco = new DiscenteService().findAll();
		for (int i = 0; i < elenco.size(); i++) {
			System.out.println(
					elenco.get(i).getNome() + " " + elenco.get(i).getCognome() + " " + elenco.get(i).getMatricola());
		}
	}

	public void modificaDiscente() {
		Discente oDiscente = new DiscenteService().findById(1);
		oDiscente.setCognome("Prezioso");
		oDiscente.setNome("Sergio");
		oDiscente.setMatricola("74490");
		new DiscenteService().update(oDiscente);
		List<Discente> elenco = new DiscenteService().findAll();
		System.out.println(
				elenco.get(0).getNome() + " " + elenco.get(0).getCognome() + " " + elenco.get(0).getMatricola());
	}

	public void eliminaDiscente() {
		Discente oDiscente = new DiscenteService().findById(1);
		if (oDiscente.getId() != 0)
			oStud.delete(oDiscente.getId());
	}
}
