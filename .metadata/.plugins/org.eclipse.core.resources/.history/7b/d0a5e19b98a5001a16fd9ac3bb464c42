package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Aula;
import com.example.demo.model.Corso;
import com.example.demo.model.Discente;
import com.example.demo.model.Docente;
import com.example.demo.service.AulaService;
import com.example.demo.service.CorsoService;
import com.example.demo.service.DiscenteService;
import com.example.demo.service.DocenteService;

@Controller
@RequestMapping(value = "/Corso")
public class CorsoController {

	@Autowired
	CorsoService corsoservice;
	
	@Autowired
	DocenteService docenteservice;
	
	@Autowired
	DiscenteService discenteservice;
	
	@Autowired
	AulaService aulaservice;
	
	
	
	@RequestMapping(value = "/ListaCorsi", method = RequestMethod.GET)
	public ModelAndView listacorsi() {
		ModelAndView model = new ModelAndView("Corso/List");
		List<Corso> listecorsi = corsoservice.getAllCorsi();
		model.addObject("elencoCorsi", listecorsi);
		return model;
	}

	@RequestMapping(value = "/AddCorso", method = RequestMethod.GET)
	public ModelAndView addDocente() {
		ModelAndView model = new ModelAndView();
		Corso ocorso = new Corso();
		model.addObject("oggettoCorso", ocorso);
		model.setViewName("Corso/AddEditCorso");
		List<Docente> listadocenti = docenteservice.getAllDocenti();
		model.addObject("elencoDocenti", listadocenti);
		List<Discente> listadiscenti = discenteservice.getAllDiscenti();
		model.addObject("elencoDiscenti", listadiscenti);
		List<Aula> listaaule = aulaservice.getAllAule();
		model.addObject("elencoAule", listaaule);
		return model;
	}
	
	@RequestMapping(value = "/EditCorso/{id}")
	public ModelAndView editCorso(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		Corso ocorso = corsoservice.getCorsoById(id);
		model.addObject("oggettoCorso", ocorso);
		List<Docente> listadocenti = docenteservice.getAllDocenti();
		model.addObject("elencoDocenti", listadocenti);
		List<Discente> listadiscenti = discenteservice.getAllDiscenti();
		model.addObject("elencoDiscenti", listadiscenti);
		List<Aula> listaaule = aulaservice.getAllAule();
		model.addObject("elencoAule", listaaule);
		model.setViewName("Corso/AddEditCorso");
		return model;
	}
	
	@RequestMapping(value= "/SaveCorso", method = RequestMethod.POST)
	public ModelAndView saveCorso(@Valid @ModelAttribute("oggettoCorso") Corso ocorso, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			List<Docente> listadocenti = docenteservice.getAllDocenti();
			model.addObject("elencoDocenti", listadocenti);
			List<Discente> listadiscenti = discenteservice.getAllDiscenti();
			model.addObject("elencoDiscenti", listadiscenti);
			List<Aula> listaaule = aulaservice.getAllAule();
			model.addObject("elencoAule", listaaule);
			model.setViewName("Corso/AddEditCorso");
			return model;
		} else {
			//ocorso.getDatainizio(). // ocorso.getDatainizio().toString().substring(ocorso.getDatainizio().toString().length()-4, ocorso.getDatainizio().toString().length());
			
		corsoservice.saveOrUpdate(ocorso);
		return new ModelAndView("redirect:/Corso/ListaCorsi");
		}
	}

	@RequestMapping(value = "/DeleteCorso/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCorso(@PathVariable("id") Integer id) {
		corsoservice.deleteCorso(id);
		return new ModelAndView("redirect:/Corso/ListaCorsi");
	}
	
	
}











