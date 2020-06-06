package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import controller.form.DocenteForm;
import model.dao.DocenteService;
import model.session.Docente;

public class DocenteAction extends DispatchAction {
	DocenteService oDoc = new DocenteService();

	public ActionForward visualizzaElenco(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List<Docente> elenco = oDoc.findAll();
		DocenteForm docenteForm = (DocenteForm) form;
		if(elenco != null && elenco.size() > 0) {
			docenteForm.setChiave(elenco.get(0).getId());
		}
		docenteForm.setElencoDocenti(elenco);
		return mapping.findForward("elenco");
	}

	public ActionForward home(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return mapping.findForward("start");
	}
	
	public ActionForward nuovo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		DocenteForm docenteForm = (DocenteForm) form;
		docenteForm.setoDocente(new Docente());
		return mapping.findForward("nuovo");
	}
	
	public ActionForward annulla(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return visualizzaElenco(mapping, form, request, response);
	}
	
	public ActionForward registra(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		  
		  DocenteForm docenteForm = (DocenteForm) form;
		  ActionErrors errors = docenteForm.validaForm();
		  if(errors.isEmpty()) {
			  if(docenteForm.getChiave() == 0)
				  oDoc.persist(docenteForm.getoDocente());
			  else
				  oDoc.update(docenteForm.getoDocente());
		  }
			  
		  if (docenteForm.getoDocente().getId() == 0)
		   oDoc.persist(docenteForm.getoDocente());
		  else 
		   oDoc.update(docenteForm.getoDocente());
		  
		  return visualizzaElenco(mapping, docenteForm, request, response);
	}
	
	public ActionForward modifica(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		DocenteForm docenteForm = (DocenteForm) form;
		docenteForm.setoDocente(oDoc.findById(docenteForm.getChiave()));
		return mapping.findForward("modifica");
	}
	
	public ActionForward elimina(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		DocenteForm docenteForm = (DocenteForm) form;
		oDoc.delete(oDoc.findById(docenteForm.getChiave()));
		return visualizzaElenco(mapping, docenteForm, request, response);
		
	}
	
	
}
	


