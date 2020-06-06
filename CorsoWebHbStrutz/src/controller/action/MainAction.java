package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import controller.form.MainForm;

public class MainAction extends DispatchAction 
{
	public ActionForward menu(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		MainForm mainForm = (MainForm) form;
		mainForm.setRdoScelta("0");
		return mapping.findForward("caricaMenu");
	}
	
	public ActionForward invio(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		MainForm mainForm = (MainForm) form;
		return mapping.findForward(mainForm.getRdoScelta());
	}

}
