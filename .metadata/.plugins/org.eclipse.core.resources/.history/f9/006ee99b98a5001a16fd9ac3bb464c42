package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Corso;
import com.example.demo.model.Docente;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.repository.DocenteRepository;

@Service
@Transactional
public class CorsoServiceImplementation implements CorsoService {

	@Autowired
	CorsoRepository corsoRep;

	@Override
	public List<Corso> getAllCorsi() {
		return (List<Corso>) corsoRep.findAll();
	}

	@Override
	public Corso getCorsoById(Integer id) {
		return corsoRep.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Corso ocorso) {
		corsoRep.save(ocorso);		
	}

	@Override
	public void deleteCorso(Integer idCorso) {
		corsoRep.deleteById(idCorso);
	}


}
