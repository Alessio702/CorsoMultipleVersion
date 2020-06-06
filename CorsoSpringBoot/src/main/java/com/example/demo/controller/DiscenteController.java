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

import com.example.demo.model.Discente;
import com.example.demo.service.DiscenteService;

@Controller
@RequestMapping(value = "/Discente")
public class DiscenteController {

	@Autowired
	DiscenteService discenteservice;

	@RequestMapping(value = "/ListaDiscenti", method = RequestMethod.GET)
	public ModelAndView listadiscenti() {
		ModelAndView model = new ModelAndView("Discente/List");
		List<Discente> listediscenti = discenteservice.getAllDiscenti();
		model.addObject("elencoDiscenti", listediscenti);
		return model;
	}

	@RequestMapping(value = "/AddDiscente", method = RequestMethod.GET)
	public ModelAndView addDiscente() {
		ModelAndView model = new ModelAndView();
		Discente odiscente = new Discente();
		model.addObject("oggettoDiscente", odiscente);
		model.setViewName("Discente/AddEditDiscente");
		return model;
	}

	@RequestMapping(value = "/EditDiscente/{id}", method = RequestMethod.GET)
	public ModelAndView editDiscente(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		Discente odiscente = discenteservice.getDiscenteById(id);
		model.addObject("oggettoDiscente", odiscente);
		model.setViewName("Discente/AddEditDiscente");
		return model;
	}

	@RequestMapping(value= "/SaveDiscente", method = RequestMethod.POST)
	public ModelAndView saveDiscente(@Valid @ModelAttribute("oggettoDiscente") Discente odiscente, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("Discente/AddEditDiscente");
			return model;
		} else {
		discenteservice.saveOrUpdate(odiscente);
		return new ModelAndView("redirect:/Discente/ListaDiscenti");
		}
	}

	@RequestMapping(value = "/DeleteDiscente/{id}", method = RequestMethod.GET)
	public ModelAndView deleteDiscente(@PathVariable("id") Integer id) {
		discenteservice.deleteDiscente(id);
		return new ModelAndView("redirect:/Discente/ListaDiscenti");
	}

}
