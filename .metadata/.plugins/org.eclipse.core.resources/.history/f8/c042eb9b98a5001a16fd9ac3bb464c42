package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Docente;
import com.example.demo.repository.DocenteRepository;

@Service
@Transactional
public class DocenteServiceImplementation implements DocenteService {
	
	@Autowired
	DocenteRepository docenteRep;

	@Override
	public List<Docente> getAllDocenti() {
		return (List<Docente>) docenteRep.findAll();
	}

	@Override
	public Docente getDocenteById(Integer idDocente) {
		return docenteRep.findById(idDocente).get();
	}

	@Override
	public void saveOrUpdate(Docente odocente) {
		docenteRep.save(odocente);		
	}

	@Override
	public void deleteDocente(Integer idDocente) {
		docenteRep.deleteById(idDocente);
	}


}
