package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import controller.form.DiscenteForm;
import model.dao.DiscenteService;
import model.session.Discente;

public class DiscenteAction extends DispatchAction {
	DiscenteService oDisc = new DiscenteService();

	public ActionForward visualizzaElenco(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		List<Discente> elenco = oDisc.findAll();

		DiscenteForm DiscenteForm = (DiscenteForm) form;

		if(elenco != null && elenco.size() > 0) {
			DiscenteForm.setChiave(elenco.get(0).getId());
		}
		DiscenteForm.setElencoDiscenti(elenco);

		return mapping.findForward("elenco");
	}

	public ActionForward home(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return mapping.findForward("start");
	}
	
	public ActionForward nuovo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		DiscenteForm DiscenteForm = (DiscenteForm) form;
		DiscenteForm.setoDiscente(new Discente());
		return mapping.findForward("nuovo");
	}
	public ActionForward annulla(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return visualizzaElenco(mapping, form, request, response);
	}
	
	public ActionForward registra(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		  DiscenteForm DiscenteForm = (DiscenteForm) form;
		  if (DiscenteForm.getoDiscente().getId() == 0)
		   oDisc.persist(DiscenteForm.getoDiscente());
		  else 
		   oDisc.update(DiscenteForm.getoDiscente());
		  
		  return visualizzaElenco(mapping, DiscenteForm, request, response);
	}
	
	public ActionForward modifica(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		DiscenteForm DiscenteForm = (DiscenteForm) form;
		DiscenteForm.setoDiscente(oDisc.findById(DiscenteForm.getChiave()));
		return mapping.findForward("modifica");
	}
	
	public ActionForward elimina(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		DiscenteForm DiscenteForm = (DiscenteForm) form;
		oDisc.delete(oDisc.findById(DiscenteForm.getChiave()));
		return visualizzaElenco(mapping, DiscenteForm, request, response);
	}
	

	
	
}
	


