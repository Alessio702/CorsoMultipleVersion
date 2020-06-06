package com.example.demo.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Aula;
import com.example.demo.service.AulaService;

@RestController
@RequestMapping("/Rest/Aula")
public class RestAulaController {
	
	@Autowired
	AulaService aulaser;
	
	   @GetMapping
	    public Iterable<Aula> getAll() {
	        return aulaser.getAllAule();
	    }
	   
	   @GetMapping(value = "/{id}")
	    public Aula getByID(@PathVariable("id") Integer id) {
		   Aula oaula = aulaser.getAulaById(id);
	        if (oaula == null) {
	            throw new EntityNotFoundException("Missing Entity");
	        }
	        return oaula;
	    }
	   
	   @DeleteMapping(value = "/{id}")
	    public void delete(@PathVariable("id") Integer id) {
		   aulaser.deleteAula(id);
		   
	    }
	 
	   @PostMapping
	    public Aula create(@RequestBody Aula oaula) {
	        return aulaser.saveOrUpdate(oaula);
	    }

	    @PutMapping("/{id}")
	    public Aula update(@PathVariable("id") Integer id, @RequestBody Aula oaula) {
	        return aulaser.saveOrUpdate(oaula);
	    }
}
