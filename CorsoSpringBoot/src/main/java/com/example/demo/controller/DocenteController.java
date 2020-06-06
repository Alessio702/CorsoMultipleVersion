package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Docente;
import com.example.demo.service.DocenteService;

@Controller
@RequestMapping(value = "/Docente")

public class DocenteController {

	@Autowired
	DocenteService docenteservice;
	
	Map<String, Object> sessionMap = new HashMap<String, Object>();
	ModelAndView modelprova = new ModelAndView();
	
	//gestione delle eccezioni generiche
//	 @ExceptionHandler(Exception.class)
//	    public ModelAndView genericErrorPage(Model model, BindingResult result) {
//		 	model.addAttribute("listadioggetti", elencooggetti);
	
//		 	return modelprova;
//	    }

	@RequestMapping(value = "/ListaDocenti", method = RequestMethod.GET)
	public ModelAndView listadocenti() {
		ModelAndView model = new ModelAndView("Docente/List");
		List<Docente> listedocenti = docenteservice.getAllDocenti();
		model.addObject("elencoDocenti", listedocenti);
		return model;
	}

	@RequestMapping(value = "/AddDocente", method = RequestMethod.GET)
	public ModelAndView addDocente() {
		ModelAndView model = new ModelAndView();
		Docente odocente = new Docente();
		model.addObject("oggettoDocente", odocente);
		model.setViewName("Docente/AddEditDocente");
		return model;
	}

	
	@RequestMapping(value = "/EditDocente/{id}", method = RequestMethod.GET)
	public ModelAndView editDocente(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		Docente odocente = docenteservice.getDocenteById(id);
		model.addObject("oggettoDocente", odocente);
		model.setViewName("Docente/AddEditDocente");

		return model;
	}

	@RequestMapping(value = "/SaveDocente", method = RequestMethod.POST)
	public ModelAndView saveDocente(@Valid @ModelAttribute("oggettoDocente") Docente odocente, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("Docente/AddEditDocente");
			return model;
		} else {
			docenteservice.saveOrUpdate(odocente);
			return new ModelAndView("redirect:/Docente/ListaDocenti");
		}
	}

	@RequestMapping(value = "/DeleteDocente/{id}", method = RequestMethod.GET)
	public ModelAndView deleteDocente(@PathVariable("id") Integer id) {
		docenteservice.deleteDocente(id);
		return new ModelAndView("redirect:/Docente/ListaDocenti");
	}

}
