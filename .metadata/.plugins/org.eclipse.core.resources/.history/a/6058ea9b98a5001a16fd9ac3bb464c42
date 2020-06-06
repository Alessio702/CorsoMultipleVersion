package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Discente;
import com.example.demo.repository.DiscenteRepository;

@Service
@Transactional
public class DiscenteServiceImplementation implements DiscenteService {

	@Autowired
	DiscenteRepository discenteRep;

	@Override
	public List<Discente> getAllDiscenti() {
		return (List<Discente>) discenteRep.findAll();
	}

	@Override
	public Discente getDiscenteById(Integer idDiscente) {
		return discenteRep.findById(idDiscente).get();
	}

	@Override
	public void saveOrUpdate(Discente odiscente) {
		discenteRep.save(odiscente);		
	}

	@Override
	public void deleteDiscente(Integer idDiscente) {
		discenteRep.deleteById(idDiscente);
	}

}
