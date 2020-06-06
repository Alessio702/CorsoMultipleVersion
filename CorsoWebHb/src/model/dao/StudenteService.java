package model.dao;

import java.util.List;

import model.session.Studente;

public class StudenteService extends AbstractService<StudenteDAO, Studente> {

	@Override
	public StudenteDAO createDAO() {
		return new StudenteDAO();
	}

	private static StudenteService oStud = new StudenteService();
	
	
	
	


	
	public List<Studente> findByX(String campo, Object valore) {
		getDao().openCurrentSessionwithTransaction();
		List<Studente> result = getDao().getCurrentSession()
				.createQuery("SELECT s FROM model.session.Studente s WHERE s." + campo + "=\'" + valore + "/'",
						Studente.class)
				.getResultList();
		getDao().closeCurrentSessionwithTransaction();
		return result;
	}

	public List<Studente> findByNome(String nome) {
		getDao().openCurrentSessionwithTransaction();
		List<Studente> result = getDao().getCurrentSession()
				.createQuery("SELECT s FROM model.session.Studente s WHERE s.nome = \'" + nome + "\'", Studente.class)
				.getResultList();
		getDao().closeCurrentSessionwithTransaction();
		return result;
	}

	@Override
	public List<Studente> findAll() {
		getDao().openCurrentSessionwithTransaction();
		List<Studente> result = getDao().getCurrentSession()
				.createQuery("SELECT s FROM model.session.Studente s WHERE s.nome = \'nome\'", Studente.class)
				.getResultList();
		getDao().closeCurrentSessionwithTransaction();
		return result;
	}

	public void elencoStudente() {
		List<Studente> elenco = new StudenteService().findAll();
		// new StudenteService().refresh(elenco.get(i));
		for (int i = 0; i < elenco.size(); i++) {
			System.out.println(
					elenco.get(i).getNome() + " " + elenco.get(i).getCognome() + " " + elenco.get(i).getMatricola());
		}
	}

	public void nuovoStudente() {
		Studente oStudente = new Studente();
		oStudente.setCognome("Prezioso");
		oStudente.setNome("Fabio");
		oStudente.setMatricola("64490");
		new StudenteService().persist(oStudente);
		List<Studente> elenco = new StudenteService().findAll();
		for (int i = 0; i < elenco.size(); i++) {
			System.out.println(
					elenco.get(i).getNome() + " " + elenco.get(i).getCognome() + " " + elenco.get(i).getMatricola());
		}
	}

	public void modificaStudente() {
		Studente oStudente = new StudenteService().findById(1);
		oStudente.setCognome("Prezioso");
		oStudente.setNome("Sergio");
		oStudente.setMatricola("74490");
		new StudenteService().update(oStudente);
		List<Studente> elenco = new StudenteService().findAll();
		System.out.println(
				elenco.get(0).getNome() + " " + elenco.get(0).getCognome() + " " + elenco.get(0).getMatricola());
	}

	public void eliminaStudente() {
		Studente oStudente = new StudenteService().findById(1);
		if (oStudente.getId() != 0)
			oStud.delete(oStudente.getId());
	}
}
