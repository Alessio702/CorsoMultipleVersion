package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import controller.form.CorsoForm;
import model.dao.CorsoService;
import model.dao.DiscenteService;
import model.dao.DocenteService;
import model.session.Corso;

public class CorsoAction extends DispatchAction {
	CorsoService oCor = new CorsoService();
	DocenteService oDoc = new DocenteService();
	DiscenteService oDisc = new DiscenteService();

	public ActionForward visualizzaElenco(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List<Corso> elenco = oCor.findAll();
		CorsoForm CorsoForm = (CorsoForm) form;
		if (elenco.size() > 0) {
			CorsoForm.setChiave(elenco.get(0).getId());
		}
		CorsoForm.setElencoCorsi(elenco);
		return mapping.findForward("elenco");
	}
	
	public ActionForward home(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return mapping.findForward("start");
	}
	
	public ActionForward annulla(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return visualizzaElenco(mapping, form, request, response);
	}
	
	public ActionForward nuovo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		CorsoForm CorsoForm = (CorsoForm) form;
		CorsoForm.setoCorso(new Corso());
		CorsoForm.setElencoDocenti(oDoc.findAll());
		return mapping.findForward("nuovo");
	}
	
	public ActionForward modifica(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		CorsoForm CorsoForm = (CorsoForm) form;
		CorsoForm.setoCorso(oCor.findById(CorsoForm.getChiave()));
		CorsoForm.setIdCorsoDocente(CorsoForm.getoCorso().getoDocente().getId());
		return mapping.findForward("modifica");
	}
	
	public ActionForward elimina(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		CorsoForm CorsoForm = (CorsoForm) form;
		oCor.delete(oCor.findById(CorsoForm.getChiave()));
		return visualizzaElenco(mapping, CorsoForm, request, response);
	}
	
	public ActionForward partecipanti(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		CorsoForm CorsoForm = (CorsoForm) form;
		CorsoForm.setoCorso(oCor.findById(CorsoForm.getChiave()));
		return mapping.findForward("partecipanti");
	}
	
	public ActionForward inserisci_partecipante(ActionMapping mapping, ActionForm form, HttpServletRequest request,
		      HttpServletResponse response) {
		    CorsoForm corsoForm = (CorsoForm) form;
		    corsoForm.setNonpartecipanti(oCor.discentiNonPartecipanti(corsoForm.getoCorso()));
		    return mapping.findForward("inserisci_partecipante");
		  }
		  
		  public ActionForward aggiungi_partecipante(ActionMapping mapping, ActionForm form, HttpServletRequest request,
		      HttpServletResponse response) {
		    CorsoForm corsoForm = (CorsoForm) form;
		    ActionForward actionFor = null;
		    corsoForm.getoCorso().getPartecipanti().add(oDisc.findById(corsoForm.getIdCorsoDiscente()));
		    
		    if (corsoForm.getoCorso().getId() == 0)
		      actionFor = mapping.findForward("nuovo");
		    else
		      actionFor = mapping.findForward("modifica");
		    
		    return actionFor;
		  }
	
	public ActionForward registra(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		  CorsoForm CorsoForm = (CorsoForm) form;
		  if(CorsoForm.getIdCorsoDocente() != 0) {
			  CorsoForm.getoCorso().setoDocente(oDoc.findById(CorsoForm.getIdCorsoDocente()));
			  if(CorsoForm.getoCorso().getId() == 0) 
				  oCor.persist(CorsoForm.getoCorso());
			  else
				  oCor.update(CorsoForm.getoCorso());
		  }
		  CorsoForm.setIdCorsoDocente(0);
		  return visualizzaElenco(mapping, CorsoForm, request, response);
	}

}