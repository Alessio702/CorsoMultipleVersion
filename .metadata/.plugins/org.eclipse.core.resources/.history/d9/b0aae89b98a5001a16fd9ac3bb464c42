package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Aula;
import com.example.demo.repository.AulaRepository;

@Service
@Transactional
public class AulaServiceImplementation implements AulaService {

	@Autowired
	AulaRepository aulaRep;

	@Override
	public List<Aula> getAllAule() {
		return (List<Aula>) aulaRep.findAll();
	}

	@Override
	public Aula getAulaById(Integer idAula) {

		return aulaRep.findById(idAula).get();
	}

	@Override
	public Aula saveOrUpdate(Aula oaula) {
		return aulaRep.save(oaula);
	}

	@Override
	public void deleteAula(Integer idAula) {
		aulaRep.deleteById(idAula);
	}


}
