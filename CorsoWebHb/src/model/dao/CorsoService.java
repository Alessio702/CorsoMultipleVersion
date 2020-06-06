package model.dao;

import java.text.ParseException;
import java.util.List;

import model.session.Aula;
import model.session.Corso;
import model.session.Docente;
import model.session.Studente;
import util.UDate;

public class CorsoService extends AbstractService<CorsoDAO, Corso> {

	@Override
	public CorsoDAO createDAO() {
		return new CorsoDAO();
	}

	private static CorsoService oCors = new CorsoService(); // L'istanziamento di studenteservice si pu� fare sia cos�
	private static AulaService oAul = new AulaService();
	private static DocenteService oDoc = new DocenteService();
	private static StudenteService oStud = new StudenteService();

	
	public List<Studente> findAllPartecipanti() {
		return executeHQLGeneric(Studente.class, "SELECT part FROM Corso corso JOIN c.partecipanti part");
	}
	
	public void nuovoCorso() throws ParseException {
	Aula oAula = oAul.findById(42);
	Docente oDocente = oDoc.findById(2);
	Corso oCorso = new Corso();
			oCorso.setoDocente(oDocente);
			oCorso.setoAula(oAula);
			oCorso.setCorso("PHP");
			oCorso.setDurata("2 anno");
			oCorso.setDatainizio(UDate.ctrlData("20/02/2018"));
			oCorso.getPartecipanti().add(oStud.findById(1));
			new CorsoService().persist(oCorso);
			List<Corso> elenco = new CorsoService().findAll();
			for (int i=0;i<elenco.size(); i++) {
				System.out.println(elenco.get(i).getoDocente() + " " + elenco.get(i).getoAula() +
						" " + elenco.get(i).getCorso() + " " + elenco.get(i).getDurata() +
						" " + elenco.get(i).getDatainizio()); } }

	public void modificaCorso() {
		Aula oAula = oAul.findById(42);
		Docente oDocente = oDoc.findById(2);
		Corso oCorso = new CorsoService().findById(81);
		oCorso.setoDocente(oDocente);
		oCorso.setoAula(oAula);
		oCorso.setCorso("STRATZ");
		oCorso.setDurata("1 MESE");
		try {
			oCorso.setDatainizio(UDate.estraiData("2002-03-03"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oCorso.getPartecipanti().add(oStud.findById(2));
		new CorsoService().update(oCorso);
		List<Corso> elenco = new CorsoService().findAll();
		for (int i = 0; i < elenco.size(); i++) {
			System.out.println(elenco.get(i).getoDocente() + " " + elenco.get(i).getoAula() + " "
					+ elenco.get(i).getCorso() + " " + elenco.get(i).getDurata() + " " + elenco.get(i).getDatainizio());
		}
	}

	public void eliminaCorso() {
			Corso oCorso = oCors.findById(81);
			if(oCorso.getId() != 0)
				oCors.delete(oCorso.getId()); }

	public void eliminaPartecipante() {
	Corso oCorso = oCors.findById(81);
	Studente oStudente = oStud.findById(1);
	oCors.removePart(oCorso, oStudente);
	oCors.update(oCorso); }

	
	public void removePart(Corso cor, Studente stu) {
		int i = 0;
		boolean removed = false;
		while (i < cor.getPartecipanti().size() && !removed) {
			if (cor.getPartecipanti().get(i).getId() == stu.getId()) {
				cor.getPartecipanti().remove(i);
				removed = true;
			}
			i++;
		}
	}

	public void removePart(Corso cor, int stu) {
		Studente oStud = new StudenteService().findById(stu);
		removePart(cor, oStud);
	}

	public void removePart(int cor, int stu) {
		Corso oCor = this.findById(cor);
		removePart(oCor, stu);
	}
}
